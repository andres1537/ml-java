/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.clustering.evaluation;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * F1 metric calculated using pairwise precision and pairwise recall.
 * 
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 */
public final class PairwiseF1 {

    /** The actual. */
    private Map<String, List<String>> actual;

    /** The predicted. */
    private Map<String, List<String>> predicted;

    /**
     * Instantiates a new pairwise f1.
     *
     * @param actual the actual
     * @param predicted the predicted
     */
    public PairwiseF1(Map<String, List<String>> actual, Map<String, List<String>> predicted) {
	this.actual = actual;
	this.predicted = predicted;
    }

    /**
     * Compute.
     *
     * @return the double
     */
    public double compute() {
	return 2 * pairwisePrecision() * pairwiseRecall() / (pairwisePrecision() + pairwiseRecall());
    }

    /**
     * Pairwise precision.
     *
     * @return the double
     */
    public double pairwisePrecision() {
	return (double) pairsIntersection() / pairs(predicted);
    }

    /**
     * Pairwise recall.
     *
     * @return the double
     */
    public double pairwiseRecall() {
	return (double) pairsIntersection() / pairs(actual);
    }

    /**
     * Pairs intersection.
     *
     * @return the int
     */
    private int pairsIntersection() {
	int count = 0;
	int actualPairs = 0;
	int predictedPairs = 0;

	for (String key : actual.keySet()) {
	    if (predicted.containsKey(key)) {
		actualPairs = actual.get(key).size() / 2;
		predictedPairs = predicted.get(key).size() / 2;
		count += Math.min(actualPairs, predictedPairs);
	    }
	}

	return count;
    }

    /**
     * Pairs.
     *
     * @param map the map
     * @return the int
     */
    private int pairs(Map<String, List<String>> map) {
	int count = 0;

	for (Entry<String, List<String>> entry : map.entrySet()) {
	    count += entry.getValue().size() / 2;
	}

	return count;
    }
}