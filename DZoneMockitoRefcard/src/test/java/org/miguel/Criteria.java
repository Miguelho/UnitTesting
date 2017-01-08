package org.miguel;

import java.util.Random;

public class Criteria {
	private Integer numOfLeaves;
	
	public final static int MAX_NUM_LEAVES = 35;

	public Integer getNumOfLeaves() {
		return numOfLeaves;
	}

	public void setNumOfLeaves(Integer numOfLeaves) {
		this.numOfLeaves = numOfLeaves;
	}
	
	public static Criteria getFakeCriteria(){
		Criteria aCriteria = new Criteria();
		aCriteria.setNumOfLeaves(new Random().nextInt(MAX_NUM_LEAVES));
		
		return aCriteria;		
	}

	public static boolean validNumOfLeaves(int numFlowers) {
		return numFlowers > MAX_NUM_LEAVES ? false : true;
	}
	
}
