package com.hemebiotech.analytics.counter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Simply count symptoms
 */
public class AnalyticsCounter implements ISymptomCounter {

    final private List<String> listOfSymptoms;

    /**
     * @param listOfSymptoms a raw list of symptoms
     */
    public AnalyticsCounter(List<String> listOfSymptoms) {
        this.listOfSymptoms = listOfSymptoms;
    }

    @Override
    public Map<String, Long>/*List<String>*/ symptomCounter() {

        // IMPERATIVE APPROACH

        /*Map<String, Integer> result = new HashMap<>();*/
        Map<String, Long> result = new LinkedHashMap<>();
        /*int counter = 0;
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
        }*/

        // DECLARATIVE APPROACH

        List<String> orderedListOfSymptoms = listOfSymptoms.stream().sorted().collect(Collectors.toList());
        Map<String, Long> symptomCountMap = orderedListOfSymptoms.stream()
                .collect(Collectors.groupingBy(/*symptom -> symptom*/Function.identity(), Collectors.counting()));
        return result = symptomCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        /*return result;*/

    }

}
