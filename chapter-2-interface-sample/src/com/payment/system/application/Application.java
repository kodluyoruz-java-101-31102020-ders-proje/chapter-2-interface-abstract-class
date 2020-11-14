package com.payment.system.application;

import com.payment.system.integrator.AssecoPaymentIntegrator;
import com.payment.system.integrator.IyzicoPaymentIntegrator;
import com.payment.system.integrator.PaymentIntegrator;
import com.payment.system.model.Order;
import com.payment.system.provider.ClassifiedPaymentProvider;
import com.payment.system.provider.PaymentProvider;
import com.payment.system.provider.ReportPaymentProvider;
import com.payment.system.tax.KDVTax;
import com.payment.system.tax.OTVTax;
import com.payment.system.tax.Tax;

public class Application {

	public static void main(String[] args) {
		
		PaymentIntegrator iyzico = new IyzicoPaymentIntegrator();
		PaymentIntegrator asseco = new AssecoPaymentIntegrator();
		
		Tax[] classifiedTaxes = { new KDVTax(0.18), new OTVTax(0.40) };
		
		PaymentProvider classifiedProvider = new ClassifiedPaymentProvider(asseco, classifiedTaxes);
		
		Order order = classifiedProvider.makePayment(200);
		System.out.println("Classified Order ID : " + order.getId());
		
		boolean cancelResult = classifiedProvider.cancelOrder(order.getId());
		System.out.println("Order cancel status: " + cancelResult); 
		
		
		Tax[] reportTaxes = { new KDVTax(0.18) };
		PaymentProvider reportProvider = new ReportPaymentProvider(iyzico, reportTaxes);
		
		order = reportProvider.makePayment(200);
		System.out.println("Report Order ID : " + order.getId());
		
		cancelResult = reportProvider.cancelOrder(order.getId());
		System.out.println("Report cancel status: " + cancelResult); 
	}

}
