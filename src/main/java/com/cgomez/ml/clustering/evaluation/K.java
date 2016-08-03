/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.clustering.evaluation;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.StatUtils;

/**
 * The K metric determines the trade-off between the average cluster purity
 * (ACP) and the average author purity (AAP). Given an ambiguous group, ACP 
 * evaluates the purity of the empirical clusters with respect to the
 * theoretical clusters for this ambiguous group. Thus, if the empirical
 * clusters are pure (i.e., they contain only citations associated with the same
 * author), the corresponding ACP value will be 1.
 * 
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 */
public final class K {
    
    /** The m. */
    private RealMatrix m;
    
    /**
     * Instantiates a new k.
     *
     * @param m the m
     */
    public K(RealMatrix m) {
	this.m = m;
    }

    /**
     * The K metric consists of the geometric mean between ACP and AAP values.
     * It evaluates the purity p and cohesion of the empirical clusters
     * extracted by each method
     *
     * @return the double
     * @see com.cgomez.evaluation.metric.IMetric#compute(org.apache.commons.math3.linear.RealMatrix)
     */
    public double compute() {
	return Math.sqrt(acp() * aap());
    }

    /**
     * Acp. Rows must be "real classes", and Columns must be "predicted classes"
     * .
     *
     * @return the double
     */
    public double acp() {
	return averageCluster(m);
    }

    /**
     * Aap. Rows must be "real classes", and Columns must be "predicted classes"
     * .
     *
     * @return the double
     */
    public double aap() {
	return averageCluster(m.transpose());
    }

    /**
     * Average cluster.
     *
     * @param m the m
     * @return the double
     */
    private double averageCluster(RealMatrix m) {
	double[] column = null;
	int N = 0;
	int n = 0;
	double sum = 0;
	
	for (int i = 0; i < m.getColumnDimension(); i++) {
	    column = m.getColumn(i);
	    n = (int) StatUtils.sum(column);
	    for (double nij : column) {
		sum += Math.pow(nij, 2) / n;
		N += nij;
	    }
	}
	
	return sum / N;
    }
}