package com.compnany.unit_converter.si.unit.converter.operators;

class FloatOperation implements IOperation<Float,Float>{

	private Float op1;
	private Float op2;
	private String operator; 
	
	public FloatOperation(Float op1, Float op2, String operator) {
		this.op1 = op1;
		this.op2 = op2;
		this.operator = operator;
	}
	
	@Override
	public Float operate() {
		if (operator.matches("/")) {
			return this.divide();
		} else if (operator.matches("*")) {
			return this.multiply();
		}
		return 0F;
	}
	
	private Float multiply() {
		return this.op1 * this.op2;
	}

	private Float divide() {
		if(this.op2 != 0F) {
			return this.op1 / this.op2;
		}
		return 0F;
	}
}
