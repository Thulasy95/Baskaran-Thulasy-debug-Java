package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int dialatedPupilsCount = 0;		
	
	public static void main(String[] args){
		
		//First read input :
		try (BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"))){
		
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
		try (BufferedWriter writer = new BufferedWriter (new FileWriter("result.out"))){
			
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
