/*
 * Copyright (c) 2016 cgomez. All rights reserved.
 */
package com.cgomez.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The Class InstanceUtils.
 *
 * @author <a href="mailto:andres1537@gmail.com">Carlos A. Gómez</a>
 * @since ml-java-1.0
 */
public final class InstanceUtils {

    /**
     * Instantiates a new instance utils.
     */
    private InstanceUtils() {
    }

    /**
     * Convert to map.
     *
     * @param instances the instances
     * @param isPredicted the is predicted
     * @return the sorted map
     */
    public static SortedMap<String, List<String>> convertToMap(Collection<? extends Instance> instances, boolean isPredicted) {
        SortedMap<String, List<String>> map = new TreeMap<String, List<String>>();
        for (Instance instance : instances) {
            String classId = isPredicted ? instance.getPredictedClass() : instance.getActualClass();
            if (!map.containsKey(classId)) {
                map.put(classId, new ArrayList<String>());
            }

            map.get(classId).add(instance.get_id());
        }

        return map;
    }
}