package org.miguel.model;

import javax.annotation.Resource;

public abstract class Tool {
	
//	@Resource
	private String name;
	
	@Resource
	private Price price;
	
//	public Tool(String name,Price price){this.name=name;this.price=price;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	

	
	
}
