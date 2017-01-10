package org.miguel;

import org.junit.Test;

public class AdvancedEnhancerTest {
	
	@Test
	public void shouldEnhanceClass(){
		IEcho echo = new Echo(); //funciones extra;
		IMixin mixin = AdvancedEnhancer.enhanceWithTargetInterface(Self.class, IMixin.class, echo);
		System.out.println("mixin.self (shows this is the proxy) = " + mixin.self());
	}
	
	interface ISelf{
		ISelf self();
	}
	
	interface IEcho{
		void echo();
	}
	
	interface IMixin extends ISelf,IEcho{}
	
	static class Self implements ISelf{

		public ISelf self() {
			// TODO Auto-generated method stub
			return this;
		}
		
	}
	
	static class Echo implements IEcho{

		public void echo() {
			System.out.println("Echo!");
		}
		
	}
}
