/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.util.constant;

import java.util.Arrays;
import java.util.List;

/**
 * The Class StopWordsSet.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public final class StopWordsSet {

    /**
     * Instantiates a new stop words set.
     */
    private StopWordsSet() {
    }

    /** The Constant ENGLISH. */
    public static final List<String> ENGLISH = Arrays.asList(
	    "i"         , "me"       , "my"     , "myself"   , "we"        , "our"     ,  
	    "ours"      , "ourselves", "you"    , "your"     , "yours"     , "yourself",  
	    "yourselves", "he"       , "him"    , "his"      , "himself"   , "she"     ,  
	    "her"       , "hers"     , "herself", "it"       , "its"       , "itself"  ,  
	    "they"      , "them"     , "their"  , "theirs"   , "themselves", "what"    ,  
	    "which"     , "who"      , "whom"   , "this"     , "that"      , "these"   ,  
	    "those"     , "am"       , "is"     , "are"      , "was"       , "were"    ,  
	    "be"        , "been"     , "being"  , "have"     , "has"       , "had"     ,  
	    "having"    , "do"       , "does"   , "did"      , "doing"     , "would"   ,  
	    "should"    , "could"    , "ought"  , "i'm"      , "you're"    , "he's"    ,  
	    "she's"     , "it's"     , "we're"  , "they're"  , "i've"      , "you've"  ,  
	    "we've"     , "they've"  , "i'd"    , "you'd"    , "he'd"      , "she'd"   ,  
	    "we'd"      , "they'd"   , "i'll"   , "you'll"   , "he'll"     , "she'll"  ,  
	    "we'll"     , "they'll"  , "isn't"  , "aren't"   , "wasn't"    , "weren't" ,  
	    "hasn't"    , "haven't"  , "hadn't" , "doesn't"  , "don't"     , "didn't"  ,  
	    "won't"     , "wouldn't" , "shan't" , "shouldn't", "can't"     , "cannot"  ,  
	    "couldn't"  , "mustn't"  , "let's"  , "that's"   , "who's"     , "what's"  ,  
	    "here's"    , "there's"  , "when's" , "where's"  , "why's"     , "how's"   ,  
	    "a"         , "an"       , "the"    , "and"      , "but"       , "if"      ,  
	    "or"        , "because"  , "as"     , "until"    , "while"     , "of"      ,  
	    "at"        , "by"       , "for"    , "with"     , "about"     , "against" ,  
	    "between"   , "into"     , "through", "during"   , "before"    , "after"   ,  
	    "above"     , "below"    , "to"     , "from"     , "up"        , "down"    ,  
	    "in"        , "out"      , "on"     , "off"      , "over"      , "under"   ,  
	    "again"     , "further"  , "then"   , "once"     , "here"      , "there"   ,  
	    "when"      , "where"    , "why"    , "how"      , "all"       , "any"     ,  
	    "both"      , "each"     , "few"    , "more"     , "most"      , "other"   ,  
	    "some"      , "such"     , "no"     , "nor"      , "not"       , "only"    ,  
	    "own"       , "same"     , "so"     , "than"     , "too"       , "very");
}