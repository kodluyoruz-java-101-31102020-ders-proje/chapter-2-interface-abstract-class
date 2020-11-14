package com.payment.system.tax;

public class KDVTax extends Tax{

	public KDVTax(double ratio) {
		super("KDV Vergisi", ratio);
	}
	
	@Override
	public double calculate(double price) {
		
		return (price * super.getRatio()) + 100;
	}
}
