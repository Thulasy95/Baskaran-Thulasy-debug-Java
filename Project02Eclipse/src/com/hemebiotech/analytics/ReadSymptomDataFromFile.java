/*
 * Class Name    : ReadSymptomDataFromFile
 *
 * Description   : read symptoms from the file
 *
 * Version       : 1.0
 *
 * Date          : 04/10/2024
 * 
 * Copyright     : Thulasy BASKARAN
 */
package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/** 
	 * Add symptoms in the list getSymptoms 
	 * 
	 * @return       result : list of symptoms or empty list if no data 
	 * @exception    IOException e : the file is not found
	 * @exception	 NullPointerException e : there is no data in the file
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))){
			String line;
			try{
				while ((line=reader.readLine()) != null) {
					result.add(line);
				}
			} catch (NullPointerException e) {
				result = Collections.emptyList();
			}			
		} catch (IOException e){
			e.printStackTrace();
		}
		return result;
	}
}
