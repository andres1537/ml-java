/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.distance;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cgomez.ml.measure.distance.impl.CosineDistance;


/**
 * The Class CosineDistanceTest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class CosineDistanceTest {
    
    /**
     * Test distance.
     */
    @Test
    public void testDistance() {
	String a = "Anil K Gupta";
	String b = "Arobinda Gupta";

	CosineDistance distance = new CosineDistance();
	double distanceValue = distance.distance(a, b);
	assertEquals("Distance expected is about 0.591751709536137", 0.591751709536137, distanceValue, 0.00001d);
    }
    
    /**
     * Test similarity.
     */
    @Test
    public void testSimilarity() {
	String a = "Anil K Gupta";
	String b = "Arobinda Gupta";

	CosineDistance distance = new CosineDistance();
	double similarityValue = distance.similarity(a, b);
	assertEquals("Distance expected is about 0.408248290463863", 0.408248290463863, similarityValue, 0.00001d);
    }
    
    /**
     * Test similarity documents.
     */
    @Test
    public void testSimilarityDocuments() {
	Map<String, String> docs = new HashMap<String, String>();
	docs.put("1", "The game of life is a game of everlasting learning game");
	docs.put("2", "The unexamined life is not worth living");
	docs.put("3", "Never stop learning");
	String query = "life learning";

	CosineDistance distance = new CosineDistance();
	double similarityValue = distance.similarity(docs, query);
	assertEquals("Similarity expected is about 0.804737854124365", 0.804737854124365, similarityValue, 0d);
    }
}