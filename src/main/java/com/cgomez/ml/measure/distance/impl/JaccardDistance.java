/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.measure.distance.impl;

import java.util.List;

import com.cgomez.ml.measure.distance.IDistanceMeasure;


/**
 * The Class JaccardDistance.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class JaccardDistance extends AbstractDistance implements IDistanceMeasure<String> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7075728150209848696L;

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
	
        int inter = 0;
        int union = 0;
        for (int i = 0; i < vectorA.length; i++) {
            if (vectorA[i] > 0d || vectorB[i] > 0d) {
                union++;
                if (vectorA[i] > 0d && vectorB[i] > 0d) {
                    inter++;
                }
            }
        }
    
        return (double) inter / union;
    }
}