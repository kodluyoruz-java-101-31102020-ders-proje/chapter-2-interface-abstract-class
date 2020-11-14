package com.payment.system.model;

import java.util.Date;

import com.payment.system.tax.Tax;

public class Order {

	private String id;
	private double total;
	private Tax[] appliedTaxes;
	private Date createdDate;
	
	public Order(String id, double total, Tax[] appliedTaxes, Date createdDate) {
	
		this.id = id;
		this.total = total;
		this.appliedTaxes = appliedTaxes;
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Tax[] getAppliedTaxes() {
		return appliedTaxes;
	}

	public void setAppliedTaxes(Tax[] appliedTaxes) {
		this.appliedTaxes = appliedTaxes;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
