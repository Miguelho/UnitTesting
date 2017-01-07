package org.proofsofconcept;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;


/**
 * Referencia: http://stackoverflow.com/questions/21310386/mocking-field-from-super-class-from-abstract-class
 * 
 * http://stackoverflow.com/questions/28295625/mockito-spy-vs-mock
 * */
@RunWith(value=MockitoJUnitRunner.class)
public class ServiceClassTest {

	@Spy
	ConcreteClass concreteClass = new ShuntedConcreteClass();
	
	@InjectMocks
	private ServiceClass serviceClass;
	
	@Before
	public void setUp(){
//		serviceClass = new ServiceClass();
		
		
//		concreteClass = Mockito.spy(concreteClass);
	}
	
	@Test
	public void shouldBeAbleToInjectBaseClassResource(){
		
		Mockito.doCallRealMethod().when(concreteClass.veryImportantResource).invokeRestService();
//		Mockito.doAnswer(new Answer<String>() {
//
//			public String answer(InvocationOnMock invocation) throws Throwable {
//				System.out.println("Answer invoked");
//				return null;
//			}
//		}).when(concreteClass.veryImportantResource).invokeRestService();

		concreteClass.getResults();
//		serviceClass.process();
		
	}
}

class ShuntedConcreteClass extends ConcreteClass{
		
	public ShuntedConcreteClass(){
		this.veryImportantResource = Mockito.mock(BaseClassResource.class);;
	}
	
	
	
}
