package com.ecommerceapplication;

public class Product {
	
	private int prId;
	private String prName;
	private String prDescription;
	private int prQuantity;
	private int prPrice;
	
	public Product(int prId, String prName, String prDescription, int prQuantity, int prPrice) {
		super();
		this.prId = prId;
		this.prName = prName;
		this.prDescription = prDescription;
		this.prQuantity = prQuantity;
		this.prPrice = prPrice;
	}

	public int getPrId() {
		return prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getPrDescription() {
		return prDescription;
	}

	public void setPrDescription(String prDescription) {
		this.prDescription = prDescription;
	}

	public int getPrQuantity() {
		return prQuantity;
	}

	public void setPrQuantity(int prQuantity) {
		this.prQuantity = prQuantity;
	}

	public int getPrPrice() {
		return prPrice;
	}

	public void setPrPrice(int prPrice) {
		this.prPrice = prPrice;
	}

}
