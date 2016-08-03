/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.util;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringEscapeUtils;

import com.cgomez.util.constant.Constant;
import com.cgomez.util.constant.StopWordsSet;

/**
 * The Class StringUtils.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public final class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * Instantiates a new string utils.
     */
    private StringUtils() {
    }
    
    /**
     * Removes the stop words.
     *
     * @param str the str
     * @return the string
     */
    public static String removeStopWords(String str) {
	StringBuffer buffer = new StringBuffer();
	if (StringUtils.isNoneBlank(str)) {
	    for (String token : str.split(Constant.WHITE_SPACE)) {
		if (!StopWordsSet.ENGLISH.contains(token.toLowerCase())) {
		    buffer.append(token).append(Constant.WHITE_SPACE);
		}
	    }
	    
	    return buffer.toString().trim();
	}

	return null;
    }
    
    /**
     * Removes the non letter characters.
     *
     * @param str the str
     * @return the string
     */
    public static String removeNonLetterCharacters(String str) {
	if (StringUtils.isNoneBlank(str)) {
	    String p = Constant.PATTERN_NON_LETTER_CHARACTERS.matcher(str).replaceAll(Constant.WHITE_SPACE);
	    return Constant.PATTERN_WHITE_SPACES.matcher(p).replaceAll(Constant.WHITE_SPACE).trim();
	}
	
	return null;
    }
    
    /**
     * Removes the duplicates.
     *
     * @param str the str
     * @param separator the separator
     * @return the string
     */
    public static Set<String> removeDuplicates(String str, String separator) {
	Set<String> subList = new HashSet<String>();
	List<String> tokens = Arrays.asList(str.split(separator));
	for (String token : tokens) {
	    subList.add(token);
	}
	
	return subList;
     }
    
    /**
     * Choose random words.
     *
     * @param words the words
     * @param ratio the ratio
     * @return the list
     */
    public static Set<String> chooseRandomWords(Set<String> words, double ratio) {
	String[] w = words.toArray(new String[words.size()]);
	Set<String> subList = new HashSet<String>();
	int number = (int) (w.length == 1 ? 1 : Math.ceil(w.length / ratio));
	Random random = new Random();
	while (number > subList.size()) {
	    int i = random.nextInt(w.length);
	    subList.add(w[i]);
	}
	
	return subList;
    }
    
    /**
     * Stemming.
     *
     * @param str the str
     * @return the string
     */
    public static String stemming(String str) {
	Stemmer stemmer = new Stemmer();
	StringBuilder sb = new StringBuilder();
	if (StringUtils.isNoneBlank(str)) {
	    StringTokenizer st = new StringTokenizer(str);
	    if (st.hasMoreTokens()) {
		String token = st.nextToken();
		stemmer.add(token.toCharArray(), token.length());
		stemmer.stem();
		sb.append(stemmer.toString());
	    
		while (st.hasMoreTokens()) {
		    token = st.nextToken();
		    stemmer.add(token.toCharArray(), token.length());
		    stemmer.stem();
		    sb.append(Constant.WHITE_SPACE).append(stemmer.toString());
		}
	    }
	}
	
	return sb.toString();
    }
    
    /**
     * To string.
     *
     * @param list the list
     * @param separator the separator
     * @return the string
     */
    public static String toString(Collection<String> coll, String separator) {
	StringBuffer buffer = new StringBuffer();
	String[] tokens = null;
	
	for (String str : coll) {
	    tokens = str.split(separator);
	    for (int i = 0; i < tokens.length; i++) {
		buffer.append(separator);
		buffer.append(tokens[i]);
	    }
	}
	
	return buffer.toString().trim();
    }
    
    /**
     * Convert to characters.
     *
     * @param txt the txt
     * @return the string
     */
    public static String convertToCharacters(String s) {
	return StringEscapeUtils.unescapeHtml4(s);
    }
    
    /**
     * Strip accents.
     *
     * @param s the s
     * @return the string
     */
    public static String stripAccents(String s) {
	String sn = Normalizer.normalize(s, Normalizer.Form.NFD);
        sn = sn.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return sn;
    }
}