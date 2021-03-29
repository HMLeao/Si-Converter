package com.compnany.unit_converter.si.unit.converter.operators;

public class MixedOperation implements IOperation<Float, IOperation<Float,?>>{

	private Float op1;
	private String operator;
	private IOperation<Float,?> operation;
	
	public MixedOperation(Float op1, IOperation<Float,?> operation, String operator) {
		this.op1 = op1;
		this.operation = operation;
		this.operator = operator;
	}
	
	@Override
	public Float operate() {
		if(this.operator.matches("/")) {
			return this.divide();
		} else if (this.operator.matches("*")) {
			return this.multiply();
		}
		return 0F;
	}
	
	private Float multiply() {
		return this.op1 * this.operation.operate();
	}
	
	private Float divide() {
		Float operationResult = this.operation.operate();
		if (operationResult != 0) {
			return this.op1 / operationResult;
		}
		return 0F;
	}
}
