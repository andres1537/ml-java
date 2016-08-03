/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh.factories.impl;

import com.cgomez.ml.distance.IDistanceMeasure;
import com.cgomez.ml.distance.impl.HammingDistance;
import com.cgomez.search.lsh.factories.AbstractLocalityFactory;
import com.cgomez.search.lsh.hash.IHashFunction;
import com.cgomez.search.lsh.hash.impl.ShingleHash;

/**
 * A factory for creating HammingLocality objects.
 */
public class HammingLocalityFactory extends AbstractLocalityFactory<String> {
    
    /** The shingle size. */
    private int shingleSize;

    /**
     * Instantiates a new hamming locality factory.
     *
     * @param numberOfHashTables the number of hash tables
     * @param shingleSize the shingle size
     */
    public HammingLocalityFactory(int numberOfHashTables, int shingleSize) {
	super.numberOfHashTables = numberOfHashTables;
	this.shingleSize = shingleSize;
    }

    /**
     * Creates a new HammingLocality object.
     *
     * @return the hash function< string>
     */
    /* (non-Javadoc)
     * @see com.cgomez.search.lsh.factories.LocalityFactory#createHashFunction()
     */
    @Override
    public IHashFunction<String> createHashFunction() {
	return new ShingleHash(shingleSize);
    }

    /**
     * Creates a new HammingLocality object.
     *
     * @return the distance measure< string>
     */
    /* (non-Javadoc)
     * @see com.cgomez.search.lsh.factories.LocalityFactory#createDistanceMeasure()
     */
    @Override
    public IDistanceMeasure<String> createDistanceMeasure() {
	return new HammingDistance();
    }
}