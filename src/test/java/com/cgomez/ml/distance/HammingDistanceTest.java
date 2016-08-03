/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.distance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cgomez.ml.distance.impl.HammingDistance;

/**
 * The Class HammingDistanceTest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class HammingDistanceTest {
    
    /**
     * Test distance.
     */
    @Test
    public void testDistance() {
	String a = "Anil K Gupta";
	String b = "Arobinda Gupta";
	
	HammingDistance distance = new HammingDistance();
	double distanceValue = distance.distance(a, b);
	assertEquals("Distance expected is about 0.9285714285714286", 0.9285714285714286, distanceValue, 0d);
    }
    
    /**
     * Test similarity.
     */
    @Test
    public void testSimilarity() {
	String a = "Anil K Gupta";
	String b = "Arobinda Gupta";
	
	HammingDistance distance = new HammingDistance();
	double similarityValue = distance.similarity(a, b);
	assertEquals("Distance expected is 13.0", 13.0, similarityValue, 0d);
    }
}