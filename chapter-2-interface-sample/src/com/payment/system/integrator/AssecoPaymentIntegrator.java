package com.payment.system.integrator;

import java.util.Date;
import java.util.UUID;

import com.payment.system.model.Order;
import com.payment.system.tax.Tax;
import com.payment.system.tax.TaxCalculator;

public class AssecoPaymentIntegrator implements PaymentIntegrator {

	private int orderCount = 0;
	private Order[] orders;
	
	public AssecoPaymentIntegrator() {
		this.orders = new Order[1000];
	}
	
	@Override
	public Order makePayment(double totalPrice, Tax[] taxes) {
		
		double totalTaxValue = TaxCalculator.calculate(totalPrice, taxes);
		double totalValue = totalPrice + totalTaxValue;
		
		totalValue += (totalValue * 0.01);
		
		String orderId = UUID.randomUUID().toString();
		Order order = new Order(orderId, totalValue, taxes, new Date());
		
		this.orders[orderCount] = order;
		orderCount++;
		
		return order;
	}

	@Override
	public boolean cancelPayment(String orderId) {
		
		int counter = 0;
		for(Order order : this.orders) {
			
			if(order == null)
				continue;
			
			if(orderId.equals(order.getId())) {
				this.orders[counter] = null;
				return true;
			}
			counter++;
		}
		
		return false;
	}

}
