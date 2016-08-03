/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.clustering.evaluation;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.SortedMap;

import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Test;

import com.cgomez.util.Instance;
import com.cgomez.util.InstanceUtils;
import com.cgomez.util.MatrixUtils;

/**
 * The Class KTest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class KTest extends AbstractMetricTest {

    /**
     * K.
     */
    @Test
    public void k() {
	Collection<Instance> instances = data();
	SortedMap<String, List<String>> actual = InstanceUtils.convertToMap(instances, false);
        SortedMap<String, List<String>> predicted = InstanceUtils.convertToMap(instances, true);
        RealMatrix m = MatrixUtils.convertToMatrix(actual, predicted);
        K kMetric = new K(m);
        assertEquals(0.7777777777777778, kMetric.acp(), 0.001d);
        assertEquals(0.8333333333333334, kMetric.aap(), 0.001d);
        assertEquals(0.8050764858994133, kMetric.compute(), 0.001d);
    }
}