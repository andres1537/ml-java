/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cgomez.ml.measure.distance.DistanceComparator;
import com.cgomez.ml.measure.distance.IDistanceMeasure;
import com.cgomez.search.lsh.factories.AbstractLocalityFactory;

/**
 * The Class Index.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @param <T> the generic type
 * @since ml-java-1.0
 */
public class Index<T> implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4738895850408646044L;
    
    /** The hash tables. */
    public List<HashTable<T>> hashTables;

    /**
     * Instantiates a new index.
     *
     * @param localityFactory the locality factory
     */
    public Index(AbstractLocalityFactory<T> localityFactory) {
	hashTables = new ArrayList<HashTable<T>>();
	int i = 0;
	while (i++ < localityFactory.getNumberOfHashTables()) {
	    hashTables.add(new HashTable<T>(localityFactory.createHashFunction()));
	}
    }

    /**
     * Insert.
     *
     * @param entry the entry
     */
    public void insert(Entry<T> entry) {
	for (HashTable<T> hashTable : hashTables) {
	    hashTable.insert(entry);
	}
    }
    
    /**
     * Removes the.
     *
     * @param entry the entry
     */
    public void remove(Entry<T> entry) {
	for (HashTable<T> hashTable : hashTables) {
	    hashTable.remove(entry);
	}
    }

    /**
     * Search.
     *
     * @param distanceMeasure the distance measure
     * @param t the t
     * @param numberOfNeighbors the number of neighbors
     * @return the list
     */
    public List<Entry<T>> search(IDistanceMeasure<T> distanceMeasure, Entry<T> entry, int numberOfNeighbors) {
	List<Entry<T>> mostSimilarObjects = null;
	Set<Entry<T>> buckets = new HashSet<Entry<T>>();
	for (HashTable<T> hashTable : hashTables) {
	    List<Entry<T>> bucket = hashTable.search(entry);
	    buckets.addAll(bucket);
	}
	
	if (!buckets.isEmpty()) {
	    mostSimilarObjects = new ArrayList<Entry<T>>(buckets);
	    Collections.sort(mostSimilarObjects, new DistanceComparator<T>(entry, distanceMeasure));
	    if (mostSimilarObjects.size() > numberOfNeighbors) {
		mostSimilarObjects = new ArrayList<Entry<T>>(mostSimilarObjects.subList(0, numberOfNeighbors));
	    } 
	}
	
	return mostSimilarObjects;
    }
}