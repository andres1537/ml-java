/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.util;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * The Class LinkedHashSetNoDuplicates.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @param <E> the element type
 * @since ml-java-1.0
 */
public class LinkedHashSetNoDuplicates<E> extends LinkedHashSet<E> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5498330316496039371L;

    /* (non-Javadoc)
     * @see java.util.HashSet#add(java.lang.Object)
     */
    @Override
    public boolean add(E e) {
	Iterator<E> it = super.iterator();
	while (it.hasNext()) {
	    E item = it.next();
	    if(item.equals(e)) {
		return false; 
	    } 
	}
	return super.add(e);
    }
    
    /**
     * First.
     *
     * @return the e
     */
    public E first() {
	Iterator<E> it = super.iterator();
	if (it.hasNext()) {
	    return it.next();
	}
	return null;
    }
}