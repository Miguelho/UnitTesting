package org.miguel;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AdvancedEnhancer {

	/**
	 * Crea una nueva instancia del objeto delegante
	 * 
	 * @param aSuperclass super class of the generated object
	 * @param someInterfaces interfaces generated object will implement.
	 * @param delegates delegates which implements the "missing methods"
	 * 
	 * */
	public static Object enhanceWithInterfaces(Class<?> aSuperclass, Class[] someInterfaces, Object[] delegates){
		Enhancer enhancer = new Enhancer();
		
		enhancer.setSuperclass(aSuperclass);
		enhancer.setInterfaces(someInterfaces);
		enhancer.setCallback(new InterfaceMethodInterceptor(delegates));
		
		return enhancer.create();
	}
	
	/**
	 * Un instanciador/creador que asume una única interfaz	a implementar por una lista de delegates.
	 * 
	 * Permite eliminar class casting con Generics
	 * 
	 * @param aSuperclass super class de los objetos generados.
	 * 
	 * @param aTargetInterface targetInterface
	 * 
	 * @param delegates delegates which implements the missing methods
	 * 
	 * 
	 * @return delegating object implementing the T interface
	 * */
	public static <T> T enhanceWithTargetInterface(Class aSuperclass, Class aTargetInterface, Object ... delegates){
		return (T) enhanceWithInterfaces(aSuperclass, new Class[] {aTargetInterface}, delegates);
		
	}
	
	private static class InterfaceMethodInterceptor implements MethodInterceptor{
		
		private Object[] theDelegates;
		
		

		private InterfaceMethodInterceptor(Object[] theDelegates) {
			super();
			this.theDelegates = theDelegates;
		}



		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			for (Object oneDelegate : theDelegates){
				Class<?>[] interfaces = oneDelegate.getClass().getInterfaces();
				for( Class<?> oneInterface : interfaces){
					Method[] methods = oneInterface.getMethods();
					for( Method oneMethod : methods){
						if(oneMethod.equals(method))
							return oneMethod.invoke(oneDelegate, args);	
						
					}
				}
			}
			return proxy.invokeSuper(obj,args);
		}
		
	}
}
