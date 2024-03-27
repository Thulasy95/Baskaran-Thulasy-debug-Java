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
	
	public List<String> getSymptoms() {
		List<String> symptomsList = reader.getSymptoms();
		return symptomsList ;
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsMap = new HashMap<>();
		//try catch ? si la liste est vide collections.emptyList() ?
	    for (String symptom : symptoms) {
	    	symptomsMap.put(symptom,(symptomsMap.containsKey(symptom) ? symptomsMap.get(symptom)+1 : 1));
	    }
		return symptomsMap ; 	
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		//try catch ? si la map est vide car liste = collections.emptyList() ?
		TreeMap<String, Integer> sortedSymptomsTreeMap = new TreeMap<>(symptoms);
		return sortedSymptomsTreeMap;
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		//try catch ? si la map est vide renvoie ?
		writer.writeSymptoms(symptoms);
	}
}
