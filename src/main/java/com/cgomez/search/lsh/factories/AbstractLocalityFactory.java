/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh.factories;

/**
 * A factory for creating AbstractLocality objects.
 *
 * @param <T> the generic type
 */
public abstract class AbstractLocalityFactory<T> implements ILocalityFactory<T> {
    
    /** The number of hash tables. */
    protected int numberOfHashTables;
    
    /**
     * Gets the number of hash tables.
     *
     * @return the number of hash tables
     */
    public int getNumberOfHashTables() {
        return numberOfHashTables;
    }
}