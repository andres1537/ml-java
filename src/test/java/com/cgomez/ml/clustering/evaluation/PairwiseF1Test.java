/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.ml.clustering.evaluation;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.SortedMap;

import org.junit.Test;

import com.cgomez.util.Instance;
import com.cgomez.util.InstanceUtils;

/**
 * The Class PairwiseF1Test.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class PairwiseF1Test extends AbstractMetricTest {

    /**
     * P f1.
     */
    @Test
    public void pF1() {
	Collection<Instance> instances = data();
	SortedMap<String, List<String>> actual = InstanceUtils.convertToMap(instances, false);
	SortedMap<String, List<String>> predicted = InstanceUtils.convertToMap(instances, true);
	PairwiseF1 pF1Metric = new PairwiseF1(actual, predicted);
	assertEquals(0.5, pF1Metric.pairwisePrecision(), 0.001d);
	assertEquals(0.666666667, pF1Metric.pairwiseRecall(), 0.001d);
	assertEquals(0.571428571, pF1Metric.compute(), 0.001d);
    }
}