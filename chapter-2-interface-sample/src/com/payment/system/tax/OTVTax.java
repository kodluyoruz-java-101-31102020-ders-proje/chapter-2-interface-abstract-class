package com.payment.system.tax;

public class OTVTax extends Tax{

	public OTVTax(double ratio) {
		super("ÖTV Vergisi", ratio);
	}
	
	@Override
	public double calculate(double price) {
		
		return (price * super.getRatio()) + 100 + (price * super.getRatio() * 0.1);
	}
}
