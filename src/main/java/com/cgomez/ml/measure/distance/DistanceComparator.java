/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.measure.distance;

import java.util.Comparator;

import com.cgomez.search.lsh.Entry;

/**
 * The Class DistanceComparator.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @param <T> the generic type
 * @since ml-java-1.0
 */
public class DistanceComparator<T> implements Comparator<Entry<T>> {
    
    /** The base. */
    private final Entry<T> base;
    
    /** The distance measure. */
    private final IDistanceMeasure<T> distanceMeasure;

    /**
     * Instantiates a new distance comparator.
     *
     * @param base the base
     * @param distanceMeasure the distance measure
     */
    public DistanceComparator(Entry<T> base, IDistanceMeasure<T> distanceMeasure){
	this.base = base;
	this.distanceMeasure = distanceMeasure;
    }

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Entry<T> a, Entry<T> b) {
	Double aDistance = distanceMeasure.distance(base.getKey(), a.getKey());
	Double bDistance = distanceMeasure.distance(base.getKey(), b.getKey());
	return aDistance.compareTo(bDistance);
    }
}