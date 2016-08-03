/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.util;

/**
 * The Class NumberUtils.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public final class NumberUtils {

    /**
     * Instantiates a new number utils.
     */
    private NumberUtils() {
    }

    /**
     * Round.
     *
     * @param value the value
     * @param places the places
     * @return the double
     */
    public static double round(double value, int places) {
	if (places < 0) {
	    throw new IllegalArgumentException();
	}

	long factor = (long) Math.pow(10, places);
	value = value * factor;
	long tmp = Math.round(value);
	return (double) tmp / factor;
    }
}