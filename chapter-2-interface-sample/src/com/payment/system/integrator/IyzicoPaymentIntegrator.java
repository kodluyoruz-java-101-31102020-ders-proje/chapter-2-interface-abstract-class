package com.payment.system.integrator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import com.payment.system.model.Order;
import com.payment.system.tax.Tax;
import com.payment.system.tax.TaxCalculator;

public class IyzicoPaymentIntegrator implements PaymentIntegrator {

	private int orderCount = 0;
	private Order[] orders;
	
	public IyzicoPaymentIntegrator() {
		this.orders = new Order[1000];
	}
	
	@Override
	public Order makePayment(double totalPrice, Tax[] taxes) {
		
		double totalTaxValue = TaxCalculator.calculate(totalPrice, taxes);
		double totalValue = totalPrice + totalTaxValue;
		
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
				
				LocalDate now = LocalDate.now();
				
				// Sipariş tarihi 3 günü geçmişse iptal edemezsiniz!
				LocalDate orderDate = order.getCreatedDate()
					.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();
				
				orderDate = orderDate.plusDays(3);
				
				if(orderDate.isBefore(now)) {
					return false;
				}
				
				this.orders[counter] = null;
				return true;
			}
			counter++;
		}
		
		return false;
	}
}
