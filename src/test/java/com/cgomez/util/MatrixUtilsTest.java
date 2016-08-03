/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.cgomez.util.constant.Constant;

/**
 * The Class MatrixUtilsTest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public class MatrixUtilsTest {
    
    /** The Constant TXT_TERMS_BY_TOPICS. */
    private static final String TXT_TERMS_BY_TOPICS = "src/test/resources/topics/termsByTopics.txt";
    
    /**
     * Gets the matrix dimension.
     *
     * @return the matrix dimension
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void getMatrixDimension() throws IOException {
	int[] dim = MatrixUtils.getMatrixDimension(new File(TXT_TERMS_BY_TOPICS), Constant.SEMICOLON);
        assertEquals(270, dim[0]);
        assertEquals(3, dim[1]);
    }
}