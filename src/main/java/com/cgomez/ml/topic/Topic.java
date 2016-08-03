/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.ml.topic;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class Topic.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public class Topic implements Comparable<Topic> {
    
    /** The number. */
    private Integer number;
    
    /** The terms. */
    private List<Term> terms;
    
    /** The probability. */
    private Double probability;
    
    /**
     * Gets the number.
     *
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the number.
     *
     * @param number the new number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    /**
     * Gets the terms.
     *
     * @return the terms
     */
    public List<Term> getTerms() {
        return terms;
    }

    /**
     * Sets the terms.
     *
     * @param terms the new terms
     */
    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }

    /**
     * Gets the probability.
     *
     * @return the probability
     */
    public Double getProbability() {
        return probability;
    }

    /**
     * Sets the probability.
     *
     * @param probability the new probability
     */
    public void setProbability(Double probability) {
        this.probability = probability;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Topic o) {
	// Descending sorting
	return Double.compare(o.getProbability() == null ? 0d : o.getProbability(), this.probability == null ? 0d : this.probability);
    }
    
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}