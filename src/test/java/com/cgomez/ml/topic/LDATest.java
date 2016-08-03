/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.ml.topic;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class LDATest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public class LDATest {
    
    /** The Constant TXT_TERMS_BY_TOPICS. */
    private static final String TXT_TERMS_BY_TOPICS = "src/test/resources/topics/termsByTopics.txt";
    
    /** The Constant TXT_TOPICS_BY_DOCUMENTS. */
    private static final String TXT_TOPICS_BY_DOCUMENTS = "src/test/resources/topics/topicsByDocuments.txt";
    
    /** The Constant TXT_DATA. */
    private static final String TXT_DATA = "src/test/resources/dataset/documents.txt";
    
    /**
     * Before.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Before
    public void before() throws IOException {
	LDA.getInstance().load(new File(TXT_TERMS_BY_TOPICS), new File(TXT_TOPICS_BY_DOCUMENTS), new File(TXT_DATA));
    }
    
    /**
     * Find topics by document.
     */
    @Test
    public void findTopicsByDocument() {
//	List<Topic> topics = LDA.getInstance().findTopicsByDocument("15wew", 2, 2);
//        // Topics
//	assertEquals(2, topics.size());
//	
//        // Topic 1
//        Topic topic = topics.get(0);
//        assertEquals(2, topic.getNumber(), 0d);
//        assertEquals(0.545454545454545, topic.getProbability(), 0d);
//        assertEquals(2, topic.getTerms().size());
//        assertEquals("new", topic.getTerms().get(0).getWord());
//        assertEquals(0.0215789473684211, topic.getTerms().get(0).getProbability(), 0d);
//        assertEquals("labour", topic.getTerms().get(1).getWord());
//        assertEquals(0.0163157894736842, topic.getTerms().get(1).getProbability(), 0d);
//        
//        // Topic 2
//        topic = topics.get(1);
//     	assertEquals(1, topic.getNumber(), 0d);
//     	assertEquals(0.454545454545455, topic.getProbability(), 0d);
//        assertEquals(2, topic.getTerms().size());
//        assertEquals("email", topic.getTerms().get(0).getWord());
//        assertEquals(0.0205, topic.getTerms().get(0).getProbability(), 0d);
//        assertEquals("microsoft", topic.getTerms().get(1).getWord());
//        assertEquals(0.0205, topic.getTerms().get(1).getProbability(), 0d);
    }
    
    /**
     * Find topics of text.
     */
    @Test
    public void findTopicsOfText() {
//	List<Topic> topics = LDA.getInstance().findTopicsOfText("IBM is spending $100m (£52m) over the next three years beefing up its commitment to Linux software.", 1, 1);
//        assertEquals(1, topics.size());
//        assertEquals(1, topics.get(0).getTerms().size());
//        assertEquals(2, topics.get(0).getNumber(), 0d);
//        assertEquals(0.006315789473684214, topics.get(0).getProbability(), 0d);
    }
}