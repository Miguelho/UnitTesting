package org.miguel.model;

public class Price {
	private double value;
	private String currency;
	
	
	public Price() {
		super();
	}

	
	public Price(double value, String currency) {
		super();
		this.value = value;
		this.currency = currency;
	}


	@Override
	public String toString() {
		return "Price [value=" + value + ", currency=" + currency + "]";
	}
	
	
}
