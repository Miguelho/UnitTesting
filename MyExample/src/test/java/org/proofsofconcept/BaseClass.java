package org.proofsofconcept;

import javax.annotation.Resource;

/**
 * Production code
 * **/
public class BaseClass {
	
	@Resource
	protected BaseClassResource veryImportantResource;

	public void getResults(){
		veryImportantResource.invokeRestService();
	}
	
	
}
