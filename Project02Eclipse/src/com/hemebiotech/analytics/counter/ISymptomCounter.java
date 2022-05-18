package com.hemebiotech.analytics.counter;

import java.util.List;
import java.util.Map;

/**
 * Anything that will count symptom's instance from a source
 * The important part is, the return value from the operation, which is a map of strings as keys and number of instances as values,
 * that don't contain any duplications
 * <p>
 * The implementation does not need an order's map
 */
public interface ISymptomCounter {
    /**
     * If no data is available, return an empty Map
     *
     * @return a raw mapping of all symptoms with their instance's number from the data source, without any duplicates
     */
    Map<String, Long>/*List<String>*/ symptomCounter();

}
