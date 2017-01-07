package org.proofsofconcept;

import javax.annotation.Resource;

public class ServiceClass {
	
	@Resource
	ConcreteClass theConcreteClass;
	
	public ServiceClass() {
		System.out.println("ServiceClass instantiated");
	}
	
	public void process(){
		theConcreteClass.getResults();
	}
	
	
}
