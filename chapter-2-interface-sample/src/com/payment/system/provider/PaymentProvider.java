package com.payment.system.provider;

import com.payment.system.model.Order;

public interface PaymentProvider {

	public Order makePayment(double price);
	public boolean cancelOrder(String orderId);
	
}
