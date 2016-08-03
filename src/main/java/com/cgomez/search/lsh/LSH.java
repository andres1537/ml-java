/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh;

import java.util.List;

import com.cgomez.search.lsh.factories.AbstractLocalityFactory;

/**
 * LSH - Locality Sensitive Hashing.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class LSH {
    
    /** The Constant instance. */
    private static final LSH instance = new LSH();
    
    /** The locality factory. */
    private AbstractLocalityFactory<String> localityFactory;
    
    /** The index. */
    private Index<String> index;
    
    /**
     * Instantiates a new lsh.
     */
    private LSH() {
    }

    /**
     * Gets the single instance of LSH.
     *
     * @return single instance of LSH
     */
    public static LSH getInstance() {
	return instance;
    }

    /**
     * Initiliaze.
     *
     * @param localityFactory the locality factory
     */
    public void initiliaze(AbstractLocalityFactory<String> localityFactory) {
	this.localityFactory = localityFactory;
	this.index = new Index<String>(localityFactory);
    }

    /**
     * Insert.
     *
     * @param entry the entry
     */
    public void insert(Entry<String> entry) {
	index.insert(entry);
    }
    
    /**
     * Removes the.
     *
     * @param entry the entry
     */
    public void remove(Entry<String> entry) {
	index.remove(entry);
    }

    /**
     * Search.
     *
     * @param entry the entry
     * @param numberOfNeighbors the number of neighbors
     * @return the list
     */
    public List<Entry<String>> search(Entry<String> entry, int numberOfNeighbors) {
	return index.search(localityFactory.createDistanceMeasure(), entry, numberOfNeighbors);
    }
}