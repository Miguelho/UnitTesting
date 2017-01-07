package org.proofsofconcept;

public class BaseClassResource {
	
	public void invokeRestService(){
		
			System.out.println("Starting service..");
			Thread helper = new Thread(new Runnable() {
				
				public void run() {
				try{
					Thread.currentThread().wait(1000);
				
				}catch(InterruptedException interruptedException){
					interruptedException.printStackTrace();
				
				}
			}});
			
			helper.start();
			
			System.out.println("Result : aa");
		
		
	}

}
