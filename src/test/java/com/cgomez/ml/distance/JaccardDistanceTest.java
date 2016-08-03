/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.distance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cgomez.ml.distance.impl.JaccardDistance;

/**
 * The Class JaccardDistanceTest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class JaccardDistanceTest {
    
    /**
     * Test distance.
     */
    @Test
    public void testDistance() {
	String a = "Anil K Gupta";
	String b = "Arobinda Gupta";

	JaccardDistance distance = new JaccardDistance();
	double distanceValue = distance.distance(a, b);
	assertEquals("Distance expected is about 0.75", 0.75, distanceValue, 0d);
    }
    
    /**
     * Test similarity.
     */
    @Test
    public void testSimilarity() {
	String a = "Anil K Gupta";
	String b = "Arobinda Gupta";

	JaccardDistance distance = new JaccardDistance();
	double similarityValue = distance.similarity(a, b);
	assertEquals("Distance expected is about 0.25", 0.25, similarityValue, 0d);
    }
}