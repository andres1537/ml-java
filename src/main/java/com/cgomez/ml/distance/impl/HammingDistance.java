/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.distance.impl;

import java.nio.charset.StandardCharsets;

import com.cgomez.ml.distance.IDistanceMeasure;

/**
 * Calculates the
 * <a href="https://en.wikipedia.org/wiki/Hamming_distance">Hamming Distance</a>
 * between two strings.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class HammingDistance implements IDistanceMeasure<String> {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5549680015125740119L;

    /* (non-Javadoc)
     * @see com.cgomez.ml.distance.DistanceMeasure#distance(java.lang.Object, java.lang.Object)
     */
    @Override
    public Double distance(String a, String b) {
	return similarity(a.toLowerCase().trim(), b.toLowerCase().trim()) / Math.max(a.trim().length(), b.trim().length());
    }	
    
    /* (non-Javadoc)
     * @see com.cgomez.ml.distance.IDistanceMeasure#similarity(java.lang.Object, java.lang.Object)
     */
    @Override
    public Double similarity(String a, String b) {
	byte aBytes[] = a.getBytes(StandardCharsets.UTF_8);
	byte bBytes[] = b.getBytes(StandardCharsets.UTF_8);

	int len = (aBytes.length > bBytes.length) ? aBytes.length : bBytes.length;
	int res[] = new int[len];
	double value = 0d;

	for (int i = 0; i < len; i++) {
	    if (i < aBytes.length) {
		if (i < bBytes.length) {
		    res[i] = (aBytes[i] ^ bBytes[i]) > 0 ? 1 : 0;
		    
		} else {
		    res[i] = (aBytes[i] ^ 0) > 0 ? 1 : 0;
		}
		
	    } else {
		res[i] = (0 ^ bBytes[i]) > 0 ? 1 : 0;
	    }
	}

	for (int num : res) {
	    value += num;
	}

	return value;
    }
}