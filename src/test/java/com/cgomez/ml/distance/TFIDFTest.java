/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.ml.distance;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cgomez.ml.measure.TFIDF;


/**
 * The Class TFIDFTest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public class TFIDFTest {
    
    /**
     * Test similarity documents.
     */
    @Test
    public void testSimilarityDocuments() {
	Map<String, String> docs = new HashMap<String, String>();
	docs.put("1", "search improv via automat queri reformul");
	docs.put("2", "intellig search full text databas");
	docs.put("3", "expert system automat queri reform");
	String term = "search";

	TFIDF tfidf = new TFIDF();
	double similarityValue = tfidf.similarity(docs.values(), docs.get("1"), term);
	assertEquals("Similarity expected is about 0.5849625007211562", 0.5849625007211562, similarityValue, 0d);
    }
}