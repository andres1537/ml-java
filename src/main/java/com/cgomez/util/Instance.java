/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.util;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class Instance.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public class Instance {
    
    /** The _id. */
    protected String _id;
    
    /** The actual class. */
    private String actualClass;
    
    /** The predicted class. */
    private String predictedClass;
    
    /**
     * Instantiates a new instance.
     */
    public Instance() {
    }
    
    /**
     * Instantiates a new instance.
     *
     * @param _id the _id
     * @param actualClass the actual class
     * @param predictedClass the predicted class
     */
    public Instance(String _id, String actualClass, String predictedClass) {
	this._id = _id;
	this.actualClass = actualClass;
	this.predictedClass = predictedClass;
    }
    
    /**
     * Gets the _id.
     *
     * @return the _id
     */
    public String get_id() {
        return _id;
    }
    
    /**
     * Sets the _id.
     *
     * @param _id the new _id
     */
    public void set_id(String _id) {
        this._id = _id;
    }
    
    /**
     * Gets the actual class.
     *
     * @return the actual class
     */
    public String getActualClass() {
        return actualClass;
    }
    
    /**
     * Sets the actual class.
     *
     * @param actualClass the new actual class
     */
    public void setActualClass(String actualClass) {
        this.actualClass = actualClass;
    }
    
    /**
     * Gets the predicted class.
     *
     * @return the predicted class
     */
    public String getPredictedClass() {
        return predictedClass;
    }
    
    /**
     * Sets the predicted class.
     *
     * @param predictedClass the new predicted class
     */
    public void setPredictedClass(String predictedClass) {
        this.predictedClass = predictedClass;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}