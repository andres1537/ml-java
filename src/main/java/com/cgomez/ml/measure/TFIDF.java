/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.ml.measure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.cgomez.util.constant.Constant;

/**
 * The Class TFIDF.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public class TFIDF {
    
    /**
     * Similarity.
     *
     * @param docs the docs
     * @param doc the doc
     * @param term the term
     * @return the double
     */
    public double similarity(Collection<String> docs, String doc, String term) {
	return tf(doc, term) * idf(docs, term);
    }

    /**
     * Tf.
     *
     * @param doc the doc
     * @param term the term
     * @return the double
     */
    public double tf(String doc, String term) {
	double frequency = 0;
	Map<String, Integer> termsFrequency = new HashMap<String, Integer>();
	int occurrencesMostFrequentTermInDoc = 0;
	
	if (!doc.contains(term)) {
	    return 0d;
	}
	
	for (String termOfDoc : doc.split(Constant.WHITE_SPACE)) {
	    // tf
	    if (termOfDoc.equalsIgnoreCase(term)) {
		frequency++;
	    }
	    
	    // most frequent term in document
	    if (termsFrequency.get(termOfDoc) == null) {
		termsFrequency.put(termOfDoc, 0);
	    }
	    termsFrequency.put(termOfDoc, termsFrequency.get(termOfDoc) + 1);
	    if (occurrencesMostFrequentTermInDoc < termsFrequency.get(termOfDoc)) {
		occurrencesMostFrequentTermInDoc = termsFrequency.get(termOfDoc);
	    }
	}
	
	return (double) frequency / occurrencesMostFrequentTermInDoc;
    }

    /**
     * Idf.
     *
     * @param docs the docs
     * @param term the term
     * @return the double
     */
    private double idf(Collection<String> docs, String term) {
	double nt = 0d;
	
	for (String doc : docs) {
	    for (String termOfDoc : doc.split(Constant.WHITE_SPACE)) {
		if (termOfDoc.equalsIgnoreCase(term)) {
		    nt++;
		    break;
		}
	    }
	}
	
	if (nt == 0d) {
	    return 0d;
	}
	
	return Math.log((double) docs.size() / nt) / Math.log(2);
    }
}