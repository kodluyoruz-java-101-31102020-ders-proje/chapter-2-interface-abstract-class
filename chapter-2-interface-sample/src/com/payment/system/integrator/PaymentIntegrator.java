package com.payment.system.integrator;

import com.payment.system.model.Order;
import com.payment.system.tax.Tax;

public interface PaymentIntegrator {

	public Order makePayment(double totalPrice, Tax[] taxes);
	public boolean cancelPayment(String orderId);
	
}
