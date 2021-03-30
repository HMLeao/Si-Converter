package com.compnany.unit_converter.si.unit.converter.operators;


public class MixedOperation implements IOperation<Float, IOperation<Float,?>>{

	private Float op1;
	private String operator;
	private Float op2;
	private IOperation<Float,?> operation;
	
	public MixedOperation() {};
	
	public MixedOperation(Float op1, Float op2, String operator) {
		this.op1 = op1;
		this.op2 = op2;
		this.operator = operator;
	}
	
	public MixedOperation(Float op1, IOperation<Float,?> operation, String operator) {
		this.op1 = op1;
		this.operation = operation;
		this.operator = operator;
	}
	
	@Override
	public Float operate() {
		if (this.operator == null) {
			return this.op1;
		} else if(this.operator.matches("/")) {
			return this.divide();
		} else if (this.operator.matches("\\*")) {
			return this.multiply();
		}  
		return 0F;
	}
	
	private Float multiply() {
		if(this.op2 != null) {
			return this.op1 * this.op2;
		}
		return this.op1 * this.operation.operate();
	}
	
	private Float divide() {
		
		if(this.op2 != null && this.op2 != 0) {
			
			return this.op1 / this.op2;
			
		} else if (this.operation != null) {
			
			Float operationResult = this.operation.operate();
			if (operationResult != 0) {
				return this.op1 / operationResult;
			}
		}
		return 0F;
	}
	
	public Float getOp1() {
		return op1;
	}

	public void setOp1(Float op1) {
		this.op1 = op1;
	}
	
	public Float getOp2() {
		return this.op2;
	}
	
	public void setOp2(Float op2) {
		this.op2 = op2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public IOperation<Float, ?> getOperation() {
		return operation;
	}

	public void setOperation(IOperation<Float, ?> operation) {
		this.operation = operation;
	}
}
