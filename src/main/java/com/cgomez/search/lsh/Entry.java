/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class Entry.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @param <T> the generic type
 * @since ml-java-1.0
 */
public class Entry<T> {
    
    /** The key. */
    private T key;
    
    /** The value. */
    private String value;
    
    /**
     * Instantiates a new entry.
     *
     * @param key the key
     * @param value the value
     */
    public Entry(T key, String value) {
	this.setKey(key);
	this.setValue(value);
    }
    
    /**
     * Gets the key.
     *
     * @return the key
     */
    public T getKey() {
        return key;
    }
    
    /**
     * Sets the key.
     *
     * @param key the new key
     */
    public void setKey(T key) {
        this.key = key;
    }
    
    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
    
    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}