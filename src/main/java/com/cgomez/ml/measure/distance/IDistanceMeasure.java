/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.ml.measure.distance;

import java.io.Serializable;

/**
 * The Interface IDistanceMeasure.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @param <T> the generic type
 * @since ml-java-1.0
 */
public interface IDistanceMeasure<T> extends Serializable {
    
    /**
     * Distance.
     *
     * @param a the a
     * @param b the b
     * @return the double
     */
    Double distance(T a, T b);
    
    /**
     * Similarity.
     *
     * @param a the a
     * @param b the b
     * @return the double
     */
    Double similarity(T a, T b);
}