/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.ml.measure.distance.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cgomez.ml.measure.TFIDF;
import com.cgomez.util.StringUtils;
import com.cgomez.util.constant.Constant;

/**
 * The Class AbstractDistance.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public abstract class AbstractDistance {
    
    /**
     * Builds the vectors.
     *
     * @param a the a
     * @param b the b
     * @return the list
     */
    protected List<double[]> buildVectors(String a, String b) {
	List<double[]> vectors = new ArrayList<double[]>();
	String ab = a.concat(Constant.WHITE_SPACE).concat(b);
	Set<String> terms = StringUtils.removeDuplicates(ab, Constant.WHITE_SPACE);
	double[] vectorA = new double[terms.size()];
	double[] vectorB = new double[terms.size()];
	int i = 0;
	for (String term : terms) {
	    vectorA[i] = new TFIDF().tf(a, term);
	    vectorB[i] = new TFIDF().tf(b, term);
	    i++;
	}
	
	vectors.add(vectorA);
	vectors.add(vectorB);
	return vectors;
    }
}