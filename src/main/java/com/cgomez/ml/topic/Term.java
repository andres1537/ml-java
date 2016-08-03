/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.ml.topic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class Term.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public class Term implements Comparable<Term> {
    
    /** The word. */
    private String word;
    
    /** The probability. */
    private Double probability;
    
    /**
     * Gets the word.
     *
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word.
     *
     * @param word the new word
     */
    public void setWord(String word) {
        this.word = word;
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
    public int compareTo(Term o) {
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