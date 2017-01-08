package org.miguel.spy;

import org.junit.Assert;
import org.junit.Test;
import org.miguel.Flower;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;


public class SpyFlowerTest {

	private final static Integer NUM_LEAVES_ORIGINAL= new Integer(10);
	
	@Test
	public void shouldStubMethodAndCallRealNotStubbedMethod(){
		//config
		Flower realFlower = new Flower();
		
		realFlower.setNumOfLeaves(NUM_LEAVES_ORIGINAL);
		
		Flower spyFlower = spy(realFlower);
		
		//stubbing
		doNothing().when(spyFlower).setNumOfLeaves(anyInt()); //Prevents unnecesary calls to a real method during stubbing
		
		//when
		spyFlower.setNumOfLeaves(123456); //stubbed invocation.
		
		//then
		verify(spyFlower).setNumOfLeaves(123456);
		
		assertEquals(NUM_LEAVES_ORIGINAL.intValue(), spyFlower.getNumOfLeaves());
		
		
		
	}
	
}
