package org.miguel.situation;

public class Visitor {
	
	public void visit(Delegateable delegate){
		System.out.println("Visitor.accept()");
	}

}
