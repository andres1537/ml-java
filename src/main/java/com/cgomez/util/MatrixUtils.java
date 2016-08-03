/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * The Class MatrixUtils.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public final class MatrixUtils {

    /**
     * Instantiates a new matrix utils.
     */
    private MatrixUtils() {
    }

    /**
     * Convert to matrix.
     *
     * @param actual the actual
     * @param predicted the predicted
     * @return the real matrix
     */
    public static RealMatrix convertToMatrix(SortedMap<String, List<String>> actual, SortedMap<String, List<String>> predicted) {
	RealMatrix m = org.apache.commons.math3.linear.MatrixUtils.createRealMatrix(actual.size(), predicted.size());
	int j = 0;
	for (Entry<String, List<String>> predictedCluster : predicted.entrySet()) {
	    int i = 0;
	    for (Entry<String, List<String>> actualCluster : actual.entrySet()) {
		for (String id : predictedCluster.getValue()) {
		    if (actualCluster.getValue().contains(id)) {
			m.addToEntry(i, j, 1);
		    }
		}
		i++;
	    }
	    j++;
	}

	return m;
    }

    /**
     * Gets the matrix dimension.
     *
     * @param file the file
     * @param separator the separator
     * @return the matrix dimension
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static int[] getMatrixDimension(final File file, String separator) throws IOException {
	int i = 0;
	int j = 0;
	LineIterator it = null;

	try {

	    it = FileUtils.lineIterator(file, CharEncoding.UTF_8);
	    int count = 0;

	    while (it.hasNext()) {
		i++;
		count = it.nextLine().split(separator).length;
		if (j < count) {
		    j = count;
		}
	    }

	} catch (IOException e) {
	    throw new IOException("Can't be loaded the file: " + file.getAbsolutePath());

	} finally {
	    LineIterator.closeQuietly(it);
	}

	return new int[] { i, j };
    }
}