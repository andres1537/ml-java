/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.cgomez.search.lsh.hash.IHashFunction;

/**
 * The Class HashTable.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @param <T> the generic type
 * @since ml-java-1.0
 */
class HashTable<T> implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8808839165188311708L;
    
    /** The data. */
    private HashMap<Integer, List<Entry<T>>> data;
    
    /** The hash function. */
    private IHashFunction<T> hashFunction;

    /**
     * Instantiates a new hash table.
     *
     * @param hashFunction the hash function
     */
    public HashTable(IHashFunction<T> hashFunction) {
        data = new HashMap<Integer, List<Entry<T>>>();
        this.hashFunction = hashFunction;
    }
    
    /**
     * Insert.
     *
     * @param entry the entry
     */
    public void insert(Entry<T> entry) {
	Integer hash = hashFunction.hash(entry.getKey());
	if (data.get(hash) == null) {
	    data.put(hash, new ArrayList<Entry<T>>());
	}
	data.get(hash).add(entry);
    }
    
    /**
     * Removes the.
     *
     * @param entry the entry
     */
    public void remove(Entry<T> entry) {
	Integer hash = hashFunction.hash(entry.getKey());
	Iterator<Entry<T>> iterator = data.get(hash).iterator();
	while (iterator.hasNext()) {
	    Entry<T> e = iterator.next();
	    if (e.getValue().equals(entry.getValue())) {
		iterator.remove();
		break;
	    }
	}
    }
    
    /**
     * Search.
     *
     * @param entry the entry
     * @return the list
     */
    public List<Entry<T>> search(Entry<T> entry) {
	Integer hash = hashFunction.hash(entry.getKey());
	if (data.get(hash) == null) {
	    return new ArrayList<Entry<T>>();
	}
	return data.get(hash);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}