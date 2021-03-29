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
	
			
    public Map<String,Object> convert(final String units) {
    	
    	Map<String, Object> result = new HashMap<>();
    	
    	String convertedString = converter.getConvertedString(units);
    	Float multiplicationFactor = converter.getConvertedMultiplicationFactor(units);
    	
        result.put("unit_name",convertedString);
        result.put("multiplication_factor",multiplicationFactor);

        return result;
    }
    
}


