package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		final String FROM_FILE = "Baskaran-Thulasy-debug-Java/resources/symptoms.txt";
		final String TO_FILE = "Baskaran-Thulasy-debug-Java/resources/result.out";
		
		ISymptomReader readFromFile = new ReadSymptomDataFromFile(FROM_FILE);
		ISymptomWriter writeIntoFile = new WriteSymptomDataToFile(TO_FILE);
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(readFromFile,writeIntoFile);
		
		List<String> fileToList = analyticsCounter.getSymptoms();
		Map<String, Integer> ListToMap = analyticsCounter.countSymptoms(fileToList);
		Map<String, Integer> mapToSortedMap = analyticsCounter.sortSymptoms(ListToMap);
		analyticsCounter.writeSymptoms(mapToSortedMap);

	}

}
