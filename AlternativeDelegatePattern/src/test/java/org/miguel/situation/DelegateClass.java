package org.miguel.situation;

public class DelegateClass extends BaseClass{
	
	Delegateable delegate;
	/*// ok, assume you can't do visitor.visit(this), that would be too easy. 
	 * Imagine the delegate does more stuff or imagine another method like doSomething() { something.call(this); 
	 */
	public void visit (Visitor visitor){
		visitor.visit(this);
	}

}
