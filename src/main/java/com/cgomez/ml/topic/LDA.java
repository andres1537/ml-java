/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.ml.topic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import com.cgomez.util.MatrixUtils;
import com.cgomez.util.StringUtils;
import com.cgomez.util.constant.Constant;

/**
 * The Class LDA.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public class LDA {

    /** The Constant instance. */
    private static final LDA instance = new LDA();

    /** The terms. */
    private RealMatrix terms;

    /** The topics. */
    private RealMatrix topics;
    
    /** The data. */
    private String[][] data;
    
    /** The words. */
    private String[] words;
    
    /** The ids. */
    private Map<String, Integer> ids;
    
    /**
     * Instantiates a new lda.
     */
    private LDA() {
    }

    /**
     * Gets the single instance of LDA.
     *
     * @return single instance of LDA
     */
    public static LDA getInstance() {
	return instance;
    }
    
    /**
     * Load.
     *
     * @param termsDistributionFile the terms distribution file
     * @param topicsDistributionFile the topics distribution file
     * @param dataFile the data file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void load(final File termsDistributionFile, final File topicsDistributionFile, final File dataFile) throws IOException {
	loadTermsDistribution(termsDistributionFile);
	loadTopicsDistribution(topicsDistributionFile);
	loadData(dataFile);
    }
    
    /**
     * Load terms distribution.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void loadTermsDistribution(final File file) throws IOException {
	int[] dimension = MatrixUtils.getMatrixDimension(file, Constant.SEMICOLON);
	words = new String[dimension[0]];
	terms = new Array2DRowRealMatrix(dimension[0], dimension[1] - 1);
	LineIterator it = null;

	try {

	    it = FileUtils.lineIterator(file, CharEncoding.UTF_8);
	    String line = null;
	    String[] tokens = null;
	    int i = 0;

	    while (it.hasNext()) {
		line = it.nextLine();
		tokens = line.split(Constant.SEMICOLON);
		words[i] = tokens[0];
		for (int j = 0; j < tokens.length - 1; j++) {
		    terms.setEntry(i, j, Double.valueOf(tokens[j + 1]));
		}

		i++;
	    }

	} catch (IOException e) {
	    throw new IOException("loadTermsDistribution: Can't be loaded the file: " + file.getAbsolutePath());

	} finally {
	    LineIterator.closeQuietly(it);
	}
    }

    /**
     * Load topics distribution.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void loadTopicsDistribution(final File file) throws IOException {
	int[] dimension = MatrixUtils.getMatrixDimension(file, Constant.SEMICOLON);
	topics = new Array2DRowRealMatrix(dimension[0], dimension[1]);
	LineIterator it = null;

	try {

	    it = FileUtils.lineIterator(file, CharEncoding.UTF_8);
	    String line = null;
	    String[] tokens = null;
	    int i = 0;

	    while (it.hasNext()) {
		line = it.nextLine();
		tokens = line.split(Constant.SEMICOLON);
		for (int j = 0; j < tokens.length; j++) {
		    topics.setEntry(i, j, Double.valueOf(tokens[j]));
		}

		i++;
	    }

	} catch (IOException e) {
	    throw new IOException("loadTopicsDistribution: Can't be loaded the file: " + file.getAbsolutePath());

	} finally {
	    LineIterator.closeQuietly(it);
	}
    }

    /**
     * Load data.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void loadData(final File file) throws IOException {
	int[] dimension = MatrixUtils.getMatrixDimension(file, Constant.SEMICOLON);
	data = new String[dimension[0]-1][dimension[1]];
	ids = new HashMap<String, Integer>();
	LineIterator it = null;

	try {

	    it = FileUtils.lineIterator(file, CharEncoding.UTF_8);
	    it.nextLine();	// skip header line
	    String line = null;
	    String[] tokens = null;
	    int i = 0;

	    while (it.hasNext()) {
		line = it.nextLine();
		tokens = line.split(Constant.SEMICOLON);
		ids.put(tokens[0].toLowerCase().trim(), i);
		for (int j = 0; j < tokens.length; j++) {
		    data[i][j] = tokens[j];
		}

		i++;
	    }

	} catch (IOException e) {
	    throw new IOException("loadData: Can't be loaded the file: " + file.getAbsolutePath());

	} finally {
	    LineIterator.closeQuietly(it);
	}
    }

    /**
     * Find topics by document.
     *
     * @param id the id
     * @param numberTopics the number topics
     * @param proportionTerms the proportion terms
     * @return the list
     */
    public List<Topic> findTopicsByDocument(String id, int numberTopics, double proportionTerms) {
	List<Topic> topicsOfDoc = new ArrayList<Topic>();
	Integer docId = ids.get(id);
	if (docId != null) {
	    double[] probabilities = topics.getColumn(docId);
	    topicsOfDoc = selectTopics(probabilities, numberTopics, proportionTerms);
	}
	
	return topicsOfDoc;
    }
    
    /**
     * Find topics of text.
     *
     * @param str the str
     * @param numberTopics the number topics
     * @param proportionTerms the proportion terms
     * @return the list
     */
    public List<Topic> findTopicsOfText(String str, int numberTopics,  double proportionTerms) {
	RealMatrix query = buildQuery(str);
	RealMatrix result = query.transpose().multiply(terms);
	double[] probabilities = result.getRow(0);
  	return selectTopics(probabilities, numberTopics, proportionTerms);
    }
    
    /**
     * Builds the query.
     *
     * @param str the str
     * @return the real matrix
     */
    private RealMatrix buildQuery(String str) {
	double[] v = new double[words.length];
	str = StringUtils.removeNonLetterCharacters(str);
	str = StringUtils.removeStopWords(str);
	Set<String> listWords = StringUtils.removeDuplicates(str, Constant.WHITE_SPACE);
	int i = 0;

	for (String word : listWords) {
	    i = ArrayUtils.indexOf(words, word);
	    if (i > 0) {
		v[i] = 1;
	    }
	}

	return new Array2DRowRealMatrix(v);
    }
    
    /**
     * Select topics.
     *
     * @param probabilities the probabilities
     * @param numberTopics the number topics
     * @param proportionTerms the proportion terms
     * @return the list
     */
    private List<Topic> selectTopics(double[] probabilities, int numberTopics, double proportionTerms) {
	List<Topic> topics = new ArrayList<Topic>();
	Topic topic = null;
	for (int i = 0; i < probabilities.length; i++) {
	    topic = new Topic();
	    topic.setNumber(i+1);
	    topic.setProbability(probabilities[i]);
	    topic.setTerms(selectTerms(i, proportionTerms));
	    topics.add(topic);
	}
	
	Collections.sort(topics);
	return new ArrayList<Topic>(topics.subList(0, numberTopics));
    }
    
    /**
     * Select terms.
     *
     * @param topic the topic
     * @param proportionTerms the proportion terms
     * @return the list
     */
    private List<Term> selectTerms(int topic, double proportionTerms) {
	if (proportionTerms <= 0d) {
	    return null;
	}
	
	List<Term> termsOfTopic = new ArrayList<Term>();
	double[] probabilities = terms.getColumn(topic);
	Term term = null;
	for (int i = 0; i < words.length; i++) {
	    term = new Term();
	    term.setWord(words[i]);
	    term.setProbability(probabilities[i]);
	    termsOfTopic.add(term);
	}
	
	Collections.sort(termsOfTopic);
	int proportion = (int) Math.round(termsOfTopic.size() * proportionTerms);
	return new ArrayList<Term>(termsOfTopic.subList(0, proportion));
    }
}