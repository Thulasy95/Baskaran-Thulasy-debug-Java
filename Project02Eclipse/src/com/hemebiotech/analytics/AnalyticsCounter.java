package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int dialatedPupilsCount = 0;
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms() { 
		ISymptomReader symptomsFromFile = new ReadSymptomDataFromFile("Baskaran-Thulasy-debug-Java/resources/symptoms.txt");
		List<String> symptomsList = symptomsFromFile.getSymptoms();
		return symptomsList ;
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsMap = new HashMap<>();
	    for (String symptom : symptoms) {
	    	if(symptomsMap.containsKey(symptom)){
	    		int symptomCount = symptomsMap.get(symptom);
	    		symptomCount++;
	    		symptomsMap.put(symptom, symptomCount);
	    	} else {
	    		symptomsMap.put(symptom,1);
	    	}
	    }
		return symptomsMap ; 	
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		Map<String, Integer> newSortedSymptomsMap = new HashMap<>();
		newSortedSymptomsMap.putAll(sortedSymptoms);		
		return newSortedSymptomsMap; 
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		ISymptomWriter resultOut = new WriteSymptomDataToFile("Baskaran-Thulasy-debug-Java/resources/result.out");
		resultOut.writeSymptoms(symptoms);
	}
	
	public static void main(String[] args){
			
		//First read input :
		try (BufferedReader reader = new BufferedReader (new FileReader("Baskaran-Thulasy-debug-Java/resources/symptoms.txt"))){
		
			String line;
			
			while ((line=reader.readLine()) != null) {
				
				System.out.println("symptom from file: " + line);
				
				if (line.equals("headache")){
					headacheCount++;
					} else if (line.equals("rash")){
						rashCount++;
						}else if (line.equals("dialated pupils")){
							dialatedPupilsCount++;
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		}

		
		// next generate output :
		try (BufferedWriter writer = new BufferedWriter (new FileWriter("Baskaran-Thulasy-debug-Java/resources/result.out"))){
			
			writer.write("headache: " + headacheCount);
			writer.newLine();
			writer.write("rash: " + rashCount);
			writer.newLine();
			writer.write("dialated pupils: " + dialatedPupilsCount);
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
}
