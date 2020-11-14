package com.payment.system.provider;

import com.payment.system.integrator.PaymentIntegrator;
import com.payment.system.model.Order;
import com.payment.system.tax.Tax;

public class ReportPaymentProvider implements PaymentProvider {

	private PaymentIntegrator paymentIntegrator;
	private Tax[] taxes;
	
	public ReportPaymentProvider(PaymentIntegrator paymentIntegrator, Tax[] taxes) {
		this.paymentIntegrator = paymentIntegrator;
		this.taxes = taxes;
	}
	
	
	@Override
	public Order makePayment(double price) {
		
		return paymentIntegrator.makePayment(price, taxes);
	}

	@Override
	public boolean cancelOrder(String orderId) {
		
		return paymentIntegrator.cancelPayment(orderId);
	}

}
