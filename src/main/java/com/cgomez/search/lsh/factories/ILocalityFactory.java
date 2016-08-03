/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh.factories;

import com.cgomez.ml.distance.IDistanceMeasure;
import com.cgomez.search.lsh.hash.IHashFunction;

/**
 * A factory for creating Locality objects.
 *
 * @param <T> the generic type
 */
public interface ILocalityFactory<T> {
    
    /**
     * Creates a new Locality object.
     *
     * @return the hash function< t>
     */
    IHashFunction<T> createHashFunction();
    
    /**
     * Creates a new Locality object.
     *
     * @return the distance measure< t>
     */
    IDistanceMeasure<T> createDistanceMeasure();
}