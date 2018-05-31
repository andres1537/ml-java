/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.distance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cgomez.ml.measure.distance.impl.LevenshteinDistance;


/**
 * The Class LevenshteinDistanceTest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class LevenshteinDistanceTest {
    
    /**
     * Test distance.
     */
    @Test
    public void testDistance() {
	String a = "Anil K Gupta";
	String b = "Arobinda Gupta";

	LevenshteinDistance distance = new LevenshteinDistance();
	double distanceValue = distance.distance(a, b);
	assertEquals("Distance expected is about 0.42857142857142855", 0.42857142857142855, distanceValue, 0d);
    }
    
    /**
     * Test similarity.
     */
    @Test
    public void testSimilarity() {
	String a = "Anil K Gupta";
	String b = "Arobinda Gupta";

	LevenshteinDistance distance = new LevenshteinDistance();
	double similarityValue = distance.similarity(a, b);
	assertEquals("Distance expected is 6.0", 6.0, similarityValue, 0d);
    }
}