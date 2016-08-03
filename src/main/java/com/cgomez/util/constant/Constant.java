/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.util.constant;

import java.util.regex.Pattern;

/**
 * The Class Constant.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public final class Constant {

    /**
     * Instantiates a new constant.
     */
    private Constant() {
    }

    /** The Constant QUOTE. */
    public static final String QUOTE = "\"";

    /** The Constant WHITE_SPACE. */
    public static final String WHITE_SPACE = " ";

    /** The Constant EMPTY. */
    public static final String EMPTY = "";

    /** The Constant SEMICOLON. */
    public static final String SEMICOLON = ";";

    /** The Constant COLON. */
    public static final String COLON = ",";
    
    /** The Constant PERIOD. */
    public static final String PERIOD = ".";

    /** The Constant UNDER_LINE. */
    public static final String UNDER_LINE = "_";
    
    /** The Constant DASH. */
    public static final String DASH = "-";
    
    /** The Constant NEW_LINE. */
    public static final String NEW_LINE = System.getProperty("line.separator");
    
    /** The Constant PATTERN_WHITE_SPACES. */
    public static final Pattern PATTERN_WHITE_SPACES = Pattern.compile("\\s+");
    
    /** The Constant PATTERN_NON_LETTER_CHARACTERS. */
    public static final Pattern PATTERN_NON_LETTER_CHARACTERS = Pattern.compile("[\\]\\[(){},.;:!?_\\-<>%]");
}