/*
 * Class Name    : AnalyticsCounter
 *
 * Description   : actions carried out by AnalyticsCounter into several independent methods 
 *
 * Version       : 1.0
 *
 * Date          : 04/10/2024
 * 
 * Copyright     : Thulasy BASKARAN
 */
package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}
	
	/** 
	 * Read symptoms and add in a list 
	 * 
	 * @return       symptomsList : list of symptoms 
	 */
	public List<String> getSymptoms() {
		List<String> symptomsList = reader.getSymptoms();
		return symptomsList ;
	}
	
	/** 
	 * Count the symptoms and add in a map the symptoms with his number of occurrence 
	 * 
	 * @param        symptoms : list of symptoms
	 * @return       symptomsMap : map of symptoms with his number of occurrence 
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsMap = new HashMap<>();
			for (String symptom : symptoms) {
				symptomsMap.put(symptom,(symptomsMap.containsKey(symptom) ? symptomsMap.get(symptom)+1 : 1));
			}
			return symptomsMap ;		
	}
	
	/** 
	 * Sort alphabetically the symptoms in the map
	 * 
	 * @param        symptoms : a map of symptoms with his number of occurrence
	 * @return       sortedSymptomsTreeMap : a map of sorted symptoms with his number of occurrence 
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sortedSymptomsTreeMap = new TreeMap<>(symptoms);
		return sortedSymptomsTreeMap;
	}
	
	/** 
	 * Write the symptoms in the file 
	 * 
	 * @param        symptoms : a map of symptoms with his number of occurrence 
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
