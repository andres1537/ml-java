/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh.hash;

import java.io.Serializable;

/**
 * The Interface HashFunction.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @param <T> the generic type
 * @since ml-java-1.0
 */
public interface IHashFunction<T> extends Serializable {
    
    /**
     * Hash.
     *
     * @param t the t
     * @return the integer
     */
    Integer hash(T t);
}