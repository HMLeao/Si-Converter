package com.compnany.unit_converter.si.unit.converter.model;

public class SIUnit {

	private String unitName;
	private Float multiplicationFactor;
	

	public SIUnit(String unitName, Float multiplicationFactor) {
		this.unitName = unitName;
		this.multiplicationFactor = multiplicationFactor;
	}
	

	public String getUnitName() {
		return unitName;
	}


	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}


	public Float getMultiplicationFactor() {
		return multiplicationFactor;
	}


	public void setMultiplicationFactor(Float multiplicationFactor) {
		this.multiplicationFactor = multiplicationFactor;
	}
}
