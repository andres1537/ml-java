/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.distance.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.StatUtils;

import com.cgomez.ml.distance.IDistanceMeasure;
import com.cgomez.util.StringUtils;
import com.cgomez.util.constant.Constant;

/**
 * The Class CosineDistance.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class CosineDistance extends AbstractDistance implements IDistanceMeasure<String> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8886041841323167334L;
    
    /*
     * (non-Javadoc)
     * 
     * @see com.cgomez.ml.distance.DistanceMeasure#distance(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    public Double distance(String a, String b) {
	return 1d - similarity(a.toLowerCase().trim(), b.toLowerCase().trim());
    }

    /* (non-Javadoc)
     * @see com.cgomez.ml.distance.IDistanceMeasure#similarity(java.lang.Object, java.lang.Object)
     */
    @Override
    public Double similarity(String a, String b) {
	List<double[]> vectors = buildVectors(a, b); 
	double[] vectorA = vectors.get(0);
	double[] vectorB = vectors.get(1);
	return dotProduct(vectorA, vectorB) / (norm(vectorA) * norm(vectorB));
    }
    
    /**
     * Similarity.
     *
     * @param docs the docs
     * @param query the query
     * @return the double
     */
    public double similarity(Map<String, String> docs, String query) {
	double mean = 0d;
	
	if (StringUtils.isNoneBlank(query)) {
	    double[] scores = null;
	    String[] termsOfQuery = query.split(Constant.WHITE_SPACE);
	    Map<String, double[]> vectors = new HashMap<String, double[]>();
	    double[] tempVector = null;
	
	    for (String key : docs.keySet()) {
		tempVector = new double[termsOfQuery.length];
		for (int i = 0; i < termsOfQuery.length; i++) {
		    tempVector[i] = new TFIDF().similarity(docs.values(), docs.get(key), termsOfQuery[i]);
		}
		vectors.put(key, tempVector);    
	    }
	
	    double[] queryVector = new double[termsOfQuery.length];
	    for (int i = 0; i < termsOfQuery.length; i++) {
		queryVector[i] = new TFIDF().similarity(docs.values(), query, termsOfQuery[i]);
	    }
		
	    int i = 0;
	    scores = new double[vectors.size()];
	    for (String key : vectors.keySet()) {
		if (StatUtils.sum(vectors.get(key)) > 0d) {
		    scores[i] = dotProduct(queryVector, vectors.get(key)) / (norm(queryVector) * norm(vectors.get(key)));    
		}
		i++;
	    }
	    
	    mean = StatUtils.mean(scores);
	}
	
	return mean;
    }
    
    /**
     * Compute the norm L2 : sqrt(Sum_i( v_i²)).
     *
     * @author Thibault Debatty http://www.debatty.info
     * @param vector the vector
     * @return L2 norm
     */
    private Double norm(double[] vector) {
	double agg = 0;
	for (double value : vector) {
	    agg += value * value;
	}
	return Math.sqrt(agg);
    }

    /**
     * Dot product.
     *
     * @author Thibault Debatty http://www.debatty.info
     * @param vectorA the vector a
     * @param vectorB the vector b
     * @return the double
     */
    private Double dotProduct(double[] vectorA, double[] vectorB) {
	double agg = 0;
	for (int i = 0; i < vectorA.length; i++) {
	    agg += vectorA[i] * vectorB[i];
	}
	return agg;
    }
}