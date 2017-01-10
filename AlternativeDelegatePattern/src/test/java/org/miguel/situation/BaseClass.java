package org.miguel.situation;

public class BaseClass implements Delegateable{

	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
	
}
