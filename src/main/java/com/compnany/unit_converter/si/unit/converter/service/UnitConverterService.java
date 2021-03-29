package com.compnany.unit_converter.si.unit.converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compnany.unit_converter.si.unit.converter.operators.UnitConverter;

import java.util.HashMap;
import java.util.Map;

@Service
public class UnitConverterService {
	
	@Autowired
	private UnitConverter converter;
	
			
    public Map<String,Object> convert(final String units) throws Exception {
    	
    	Map<String, Object> result = new HashMap<>();

    	try {
    		String convertedString = converter.getConvertedString(units);
    		Float multiplicationFactor = converter.getConvertedMultiplicationFactor(units);
    		result.put("unit_name",convertedString);
    		result.put("multiplication_factor",multiplicationFactor);
    	} catch (NullPointerException np) {
    		System.out.println("error: fail to parse unit");
    		throw np;
    	} 
    	
    	return result;
    }
    
}


