/*
 * Copyright (c) 2015 cgomez. All rights reserved.
 */
package com.cgomez.search.lsh;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.cgomez.search.lsh.factories.impl.HammingLocalityFactory;

/**
 * The Class LSHTest.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public class LSHTest {

    /**
     * Lsh.
     */
    @Test
    public void LSH() {
	String[] dataset = { "carlos", "marcos", "juan", "pedro", "teresa", "karlos", "maria", "juana", "elias", "tatiana", "karloos", "marcela",
		"ricardo", "pablo", "matilde", "andres", "monica", "gabriel", "pilar", "jose", "mica", "howley", "thresa", "juliana", "patricio",
		"ramon", "willmar", "marta", "abrams", "kayla", "augustin", "roberto", "teresita", "barta", "augustina", "christi", "antonio",
		"wanda", "audrey", "remona", "audrea", "moises", "wada", "myrta", "mirta", "alberto", "miguel", "clara", "roman", "luis" };
	LSH.getInstance().initiliaze(new HammingLocalityFactory(10, 3));
	
	for (int i = 0; i < dataset.length; i++) {
	    Entry<String> entry = new Entry<String>(dataset[i], String.valueOf(i));
	    LSH.getInstance().insert(entry);
	}

	Entry<String> query = new Entry<String>("carlos", "0");
	List<Entry<String>> neighbours = LSH.getInstance().search(query, 1);
	assertEquals(query.getKey(), neighbours.get(0).getKey());
    }
}