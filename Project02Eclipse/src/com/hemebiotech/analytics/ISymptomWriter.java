/*
 * Class Name    : ISymptomWriter
 *
 * Description   : Interface
 *
 * Version       : 1.0
 *
 * Date          : 04/10/2024
 * 
 * Copyright     : Thulasy BASKARAN
 */
package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	void writeSymptoms(Map<String, Integer> symptoms);
}
