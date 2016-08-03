/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh.hash.impl;

import java.util.Random;

import com.cgomez.search.lsh.hash.IHashFunction;

/**
 * The Class ShingleHash.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class ShingleHash implements IHashFunction<String> {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3179530666190351578L;
    
    /** The shingle size. */
    private int shingleSize;
    
    /** The r. */
    private double r;

    /**
     * Instantiates a new shingle hash.
     *
     * @param shingleSize the shingle size
     */
    public ShingleHash(int shingleSize) {
	this.shingleSize = shingleSize;
	r = new Random().nextDouble();
    }

    /* (non-Javadoc)
     * @see com.cgomez.search.lsh.hash.IHashFunction#hash(java.lang.Object)
     */
    @Override
    public Integer hash(String str) {
	String shingle = null;

	if (str.length() <= shingleSize) {
	    shingle = str;
		
	} else {
	    int a = (int) Math.round(str.length() * r);
	    int b = a + shingleSize;
	    if (b > str.length()) {
		b = str.length();
		a = b - shingleSize;
	    }
		
	    shingle = str.substring(a, b);
	}
	    
	return shingle.hashCode();
    }
}