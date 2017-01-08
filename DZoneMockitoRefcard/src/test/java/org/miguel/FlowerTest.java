package org.miguel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;
import org.miguel.model.FlowerSearcher;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.inOrder;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.mockito.internal.InOrderImpl;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.verification.VerificationMode;

/**
 * @author Mike
 * */
//@RunWith(value=MockitoJUnitRunner.class)
public class FlowerTest {
	
	private static final String WANTED_DATE = "07/01/2017";
	private static final Integer WANTED_VALUE = new Integer(10);

	private static int TEST_NUMBER_OF_LEAVES = 2;
	
	Flower flowerAux;
	
	@Mock
	Flower flower;
	
	Flower spiedFlower;
	
	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);
		
		flowerAux = new Flower();
		
		spiedFlower = Mockito.spy(flowerAux);
		
	}
	
	@Test
	public void shouldBeAbleToCreateAMock(){
		assertNotNull(flower);
	}


	/**
	 * {@link Description} The given method demonstrates how stubbing works.
	 * Even though the field value 2 for the numOfFlowers hasn't been set, the stubbed return verifies to be 2.
	 * */
	@Test
	public void shouldBeAbleToStubMethodReturn(){
		
		when(flower.getNumOfLeaves()).thenReturn(TEST_NUMBER_OF_LEAVES);
		
		assertNotNull("StubbedMethodReturn did not work.. maybe forgot to stubbed the behavior?", flower.getNumOfLeaves());
	}


	@Test
	public void shouldBeAbleToReturnStubbedAnswer(){
		when(flower.getNumOfLeaves()).thenAnswer(new Answer<Integer>() {

			public Integer answer(InvocationOnMock invocation) throws Throwable {
				System.out.println("Stubbing method by returning an Answer...");
				return new Integer(TEST_NUMBER_OF_LEAVES);
			}
		});
		
		assertNotNull(flower.getNumOfLeaves());
	
	}

	@Test(expected=NotEnoughLeafsException.class)
	public void shouldBeAbleToCatchExceptionWhenTearingLeaves() throws NotEnoughLeafsException{
		
		spiedFlower.tearLeaf();
		
	}

	@Test
	public void shouldBeAbleToTakeAnotherFlower() throws NotEnoughLeafsException{
		spiedFlower.setNumOfLeaves(TEST_NUMBER_OF_LEAVES);
		
		Mockito.doThrow(NotEnoughLeafsException.class).when(spiedFlower).tearLeaf();
		
		spiedFlower.lovesMeOrNot();
		
	}
	
	@Test
	public void shouldMatchSimpleGivenArgument(){
		WateringScheduler schedulerMock = Mockito.mock(WateringScheduler.class);
		
		when(schedulerMock.getNumberOfPlantsScheduledOnDate(WANTED_DATE)).thenReturn(WANTED_VALUE);
		
		Integer numberForWantedArgument = schedulerMock.getNumberOfPlantsScheduledOnDate(WANTED_DATE);
		Integer numberForAnyOtherArgument = schedulerMock.getNumberOfPlantsScheduledOnDate("blaaa");
		
		assertEquals(numberForWantedArgument,WANTED_VALUE);
		
	}
	
	@Test
	public void shouldMatchMatcherArgument(){
		WateringScheduler schedulerMock = Mockito.mock(WateringScheduler.class);
		
		when(schedulerMock.getNumberOfPlantsScheduledOnDate(anyString())).thenReturn(WANTED_VALUE);
		
		assertEquals(WANTED_VALUE, schedulerMock.getNumberOfPlantsScheduledOnDate(WANTED_DATE));
		
	}
	
	@Test
	
	public void shouldBeAbleToGetTotalNumberOfPlants(){
		WateringScheduler schedulerMock = Mockito.mock(WateringScheduler.class);
		
		Machine machine = anyObject();
		Place place = anyObject();
		
		when(
				schedulerMock.getTotalNumberOfPlants(machine, place)
				)
		.then(new Answer<Integer>() {

			public Integer answer(InvocationOnMock invocation) throws Throwable {
				System.out.println("Super mockeado");
				Object[] arguments = invocation.getArguments();
				if (arguments.length == 0)
					throw new MockitoException(null);
				return new Integer(1);
			}
		});
		
		
		
		Integer result = schedulerMock.getTotalNumberOfPlants(new Machine(), new Place());
		
	}

	@Test
	public void shouldBeAbleToVerifyIfInvoked(){
		WateringScheduler wateringScheduler = Mockito.mock(WateringScheduler.class);
		
//		wateringScheduler.getTotalNumberOfPlants((Machine)anyObject(), (Place)anyObject());
		wateringScheduler.getTotalNumberOfPlants(new Machine(), new Place());
		wateringScheduler.getNumberOfPlantsScheduledOnDate(anyString());
		
//		Mockito.verifyZeroInteractions(wateringScheduler);

		Mockito.verify(wateringScheduler).getTotalNumberOfPlants((Machine)anyObject(), (Place)anyObject());
//		Mockito.verify(wateringScheduler).getTotalNumberOfPlants(new Machine(), new Place());
	}
	
	/**
	 * Reference https://dzone.com/refcardz/mockito
	 * 
	 * Mockito no verifica las invocaciones automáticamente.
	 * */
	@Test
	public void shouldBeAbleToVerifyIfOnlyOneMethodFromClassInvoked(){
		WateringScheduler wateringScheduler = Mockito.mock(WateringScheduler.class);
		
		wateringScheduler.getNumberOfPlantsScheduledOnDate(anyString());
//		wateringScheduler.getTotalNumberOfPlants((Machine)anyObject(), (Place)anyObject());
		
		Mockito.verify(wateringScheduler,Mockito.only()).getNumberOfPlantsScheduledOnDate(anyString());
		
	}

	@Test
	public void shouldVerifyInOrderThroughDifferentMocks(){
		
		WaterSource waterSource1 = Mockito.mock(WaterSource.class);
		WaterSource waterSource2 = Mockito.mock(WaterSource.class);
		
		waterSource1.getWaterPressure();
		waterSource2.getWaterTemperature();
		waterSource1.getWaterPressure();
		
		
		InOrder inOrderApi = inOrder(waterSource1,waterSource2);
		
		
		inOrderApi.verify(waterSource1).getWaterPressure();
		inOrderApi.verify(waterSource2).getWaterTemperature();
		inOrderApi.verify(waterSource1).getWaterPressure();
	}
	
	/**
	 * Invocations that happen before the spy is created does not seem to be subject to verification tests.
	 * 
	 * static method getWateringScheduler() returns an already built WateringScheduler with its inner WaterSource.
	 * 
	 * In compilation time, this WaterSource waterPressure is set a value (1).
	 * */
	@Test(expected=WantedButNotInvoked.class)
	public void shouldVerifyCollateralInvocations(){
		WateringScheduler wateringScheduler = Mockito.spy(WateringScheduler.getWateringScheduler());
		
		WaterSource innerWaterSource = Mockito.spy(wateringScheduler.getWaterSource());
		
		Mockito.verify(innerWaterSource).setWaterPressure(anyDouble());;
		
		
		
	}
	
	/*
	 * ArgumentCaptor must be used only with verification, but not with stubbing due to the decrease in test readability.
	 * 
	 * When a SUT internally uses the same object reference for multiple calls on a mock, every time changing its internal state, 
	 * captor.getAllValues() returns the same object in a state for the last call.
	 * */
	@Test
	public void shouldVerifyWithArgumentMatching(){
		//config
		FlowerSearcher flowerSearcherMock = Mockito.mock(FlowerSearcher.class);
		
		Criteria searchCriteria = Criteria.getFakeCriteria();
		
		//when
		List<Flower> searchedFlower = flowerSearcherMock.findMatching(searchCriteria);
		
		//then
		ArgumentCaptor<Criteria> captor = ArgumentCaptor.forClass(Criteria.class);
		
		Mockito.verify(flowerSearcherMock).findMatching(captor.capture());
		
		Criteria usedSearchCriteria = captor.getValue();
		
		assertTrue(Criteria.validNumOfLeaves(captor.getValue().getNumOfLeaves()));
	}
	
	@Test
	public void shouldVerifyIllegalValueForNumOfLeaves(){
		//config
		FlowerSearcher flowerSearcherMock = Mockito.mock(FlowerSearcher.class);
		
		Criteria searchCriteria = Criteria.getFakeCriteria();
		
		Integer ILLEGAL_NUM_OF_LEAVES = new Integer(36);//Higher than what is to be the highest value (35)
		
		searchCriteria.setNumOfLeaves(ILLEGAL_NUM_OF_LEAVES);
		
		//when
		flowerSearcherMock.findMatching(searchCriteria);
		
		//then
		ArgumentCaptor<Criteria> captor = ArgumentCaptor.forClass(Criteria.class);
	
		Mockito.verify(flowerSearcherMock).findMatching(captor.capture());
		
		Criteria usedSearchCriteria = captor.getValue();
		
		Integer illegalArgumentForNumberOfLeaves = usedSearchCriteria.getNumOfLeaves();
		
		assertTrue(Criteria.validNumOfLeaves(illegalArgumentForNumberOfLeaves));
	}
}
