package com.payment.system.tax;

public class TaxCalculator {

	public static double calculate(double price, Tax[] taxes) {
		
		double totalTax = 0;
		
		if(taxes == null) {
			return totalTax;
		}
		
		for(Tax tax : taxes) {
			totalTax += tax.calculate(price);
		}
		return totalTax;
	}
	
}
