package com.cgomez.ml.clustering.evaluation;

import java.util.ArrayList;
import java.util.Collection;

import com.cgomez.util.Instance;

/**
 * The Class AbstractMetricTest.
 * 
 * @author <a href="mailto:andres1537@gmail.com">Carlos Gomez</a>
 * @since ml-java-1.0
 */
public abstract class AbstractMetricTest {
    /**
     * Data.
     *
     * @return the collection
     */
    protected Collection<Instance> data() {
	Collection<Instance> instances = new ArrayList<Instance>();
	instances.add(new Instance("1", "agupta_1", "agupta_1"));
	instances.add(new Instance("2", "agupta_1", "agupta_1"));
	instances.add(new Instance("3", "agupta_1", "agupta_1"));
	instances.add(new Instance("4", "agupta_1", "agupta_20"));
	instances.add(new Instance("5", "agupta_10", "agupta_20"));
	instances.add(new Instance("6", "agupta_11", "agupta_13"));
	instances.add(new Instance("7", "agupta_13", "agupta_13"));
	instances.add(new Instance("8", "agupta_15", "agupta_15"));
	instances.add(new Instance("9", "agupta_15", "agupta_15"));

	return instances;
    }
}