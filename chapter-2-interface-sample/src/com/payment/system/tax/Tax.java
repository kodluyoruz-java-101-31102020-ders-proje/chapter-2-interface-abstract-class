package com.payment.system.tax;

public abstract class Tax {

	protected String name;
	protected double ratio;

	protected Tax() {
		this.ratio = 0.0;
		this.name = "";
	}
	
	protected Tax(String name, double ratio) {
		this.name = name;
		this.ratio = ratio;
	}
	
	public double getRatio() {
		return this.ratio;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract double calculate(double price);
}
