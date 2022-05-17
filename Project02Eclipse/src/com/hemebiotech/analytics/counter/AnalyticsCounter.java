package com.hemebiotech.analytics.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simply count symptoms
 */
public class AnalyticsCounter implements ISymptomCounter {

    private List<String> listOfSymptoms;

    /**
     * @param listOfSymptoms a raw list of symptoms
     */
    public AnalyticsCounter(List<String> listOfSymptoms) {
        this.listOfSymptoms = listOfSymptoms;
    }

    @Override
    public Map<String, Integer> symptomCounter() {
        Map<String, Integer> result = new HashMap<String, Integer>();
        int counter = 0;
        for (String symptom : listOfSymptoms) {
            for (String listOfSymptom : listOfSymptoms) {
                if (symptom.equals(listOfSymptom)) {
                    counter++;
                }
            }
            if (!result.containsKey(symptom)) {
                result.put(symptom, counter);
            }
            counter = 0;
        }
        return result;

    }

}
