package org.miguel;

public class Flower {
	private Integer numOfLeaves;

	@SuppressWarnings("unused")
	private boolean isAnyFlowerLeft = true;
	
	public int getNumOfLeaves() {
		return numOfLeaves;
	}

	public void setNumOfLeaves(int numOfLeaves) {
		this.numOfLeaves = numOfLeaves;
	}
	
	public void tearLeaf() throws NotEnoughLeafsException{
		
		if( numOfLeaves == null || numOfLeaves.intValue() <= 0 ){
			throw new NotEnoughLeafsException();
		}
		
		this.setNumOfLeaves(--numOfLeaves);
		System.out.println("One leaf is torn off.. but it is still " + numOfLeaves + " leaves left");
	}
	
	public void lovesMeOrNot(){
		for(int i = numOfLeaves; i > 0; i--){
			try {
				tearLeaf();
			} catch (NotEnoughLeafsException e) {
				System.out.println("I will pick another..");
			}
		}
	}
}
