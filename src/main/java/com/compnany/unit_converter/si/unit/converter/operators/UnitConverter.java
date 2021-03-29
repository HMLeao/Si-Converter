package com.compnany.unit_converter.si.unit.converter.operators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.compnany.unit_converter.si.unit.converter.constants.UnitConstants;
import com.compnany.unit_converter.si.unit.converter.model.SIUnit;

@Component
public class UnitConverter {

	private Map<String, SIUnit> conversionTable;
	
	public UnitConverter() {

		Map<String, SIUnit> conversionTable = new HashMap<>();
		
		conversionTable.put(UnitConstants.DEGREE, new SIUnit("rad", 0.1745329252F));
    	conversionTable.put(UnitConstants.MINUTE, new SIUnit("s", 60F));
    	conversionTable.put(UnitConstants.HOUR, new SIUnit("s", 3600F));
    	conversionTable.put(UnitConstants.DAY, new SIUnit("s", 86400F));
    	conversionTable.put(UnitConstants.ARCMINUTE, new SIUnit("rad", 0.0002988802087F));
    	conversionTable.put(UnitConstants.ARCSECOND, new SIUnit("rad", 0.0000048481368F));
    	conversionTable.put(UnitConstants.HECTARE, new SIUnit("m2", 10000F));
    	conversionTable.put(UnitConstants.LITRE, new SIUnit("m3", 0.001F));
    	conversionTable.put(UnitConstants.TONNE, new SIUnit("kg", 1000F));
    	conversionTable.put(UnitConstants.SQUARE_METER, new SIUnit("m2", 1F));
    	conversionTable.put(UnitConstants.CUBIC_METER, new SIUnit("m3", 1F));
    	conversionTable.put(UnitConstants.SECOND, new SIUnit("s", 1F));
    	conversionTable.put(UnitConstants.RAD, new SIUnit("rad", 1F));
		
		this.conversionTable = conversionTable;
	}
	
    
    
	
    public String getConvertedString(final String unitsString) throws NullPointerException{
    	
    	List<String> unitsToConvert = Arrays.asList(unitsString.replaceAll("[()]", "").split("[/*]"));
    	
    	String convertedString = unitsString;
    	
    	for(String unit: unitsToConvert) {
    		SIUnit siUnit = this.getSIUniMatching(unit);
    		if(siUnit != null) {
    			convertedString = convertedString.replaceAll(unit, siUnit.getUnitName());
    		} else {
    			throw new NullPointerException();
    		}
    	}
    	
    	return convertedString;
    }
    
    
    
    
    public SIUnit getSIUniMatching(final String unitOrSymbol) {
    	
    	SIUnit siUnit = null;
    	
    	for(String mapKey: this.conversionTable.keySet()) {
    		if(Pattern.matches("(_" + unitOrSymbol + "_.*)|(.*_" + unitOrSymbol + "_)", mapKey)) { // kind of magic!
    			siUnit = this.conversionTable.get(mapKey);
    			break;
    		}
    	}
    	
    	return siUnit;
    }




	public Float getConvertedMultiplicationFactor(final String units) {
		
		
		List<String> operands = Arrays.asList(units.split("[()/*]"))
				.stream().filter(s -> !s.isBlank())
				.map(s -> s.strip())
				.collect(Collectors.toList());
		
		
		
		List<String> operators = Arrays.asList(units.split("[^()/*]"))
				.stream().filter(s -> !s.isBlank())
				.collect(Collectors.toList());
		
//		IOperation<Float,?> operation;
		
		
		return 123456F;
	}
    
}





