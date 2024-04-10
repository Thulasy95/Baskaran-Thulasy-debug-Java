/*
 * Class Name    : WriteSymptomDataToFile
 *
 * Description   : write symptoms in the file
 *
 * Version       : 1.0
 *
 * Date          : 04/10/2024
 * 
 * Copyright     : Thulasy BASKARAN
 */
package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{
	
	private String tofilepath;
	
	public WriteSymptomDataToFile (String tofilepath) {
		this.tofilepath = tofilepath;
	}
	
	/** 
	 * Write the symptoms and their quantity in the file result.out 
	 *  
	 * @param        symptoms : a map of symptoms with his number of occurrence
	 * @exception    IOException e : the file is not found
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (BufferedWriter writer = new BufferedWriter (new FileWriter(tofilepath))){
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + " : " + entry.getValue());
				writer.newLine();	
			}			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
