package org.miguel.annotations;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.miguel.WaterSource;
import org.miguel.WateringScheduler;
import org.miguel.model.PlantWaterer;
import org.miguel.model.PlantWatererShunted;
import org.miguel.model.Price;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;



public class MockInjectingTest {

	private static final String nameMock = "MockName";
	
	@Mock
	private WaterSource waterSourceMock;
	
	@Spy
	private WateringScheduler wateringSchedulerSpy;
	
	@Mock
	private Price plantWatererPrice;
	
	/*
	 * Mockito uses reflection to inject a private field. 
	 * Useful when in production code, dependencies are injected directly to private fields (IoC Framework)
	 * */
//	@InjectMocks
//	private PlantWatererShunted plantWaterer;
	
	/*
	 * Create a shunted class and construct the SUT with dependencies Mock. 
	 * */
	private PlantWatererShunted plantWaterer;
	private PlantWatererShunted plantWatererSpy;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		plantWaterer = new PlantWatererShunted(waterSourceMock, wateringSchedulerSpy, plantWatererPrice, nameMock);
		plantWatererSpy = spy(plantWaterer);
	}
	
	@Test
	public void shouldInjectMocks(){
		assertNotNull(plantWaterer.getWateringScheduler());
		assertNotNull(plantWaterer.getWaterSource());
		assertNotNull(plantWaterer.getPrice());

	}
	
	@Test
	public void shouldBeAbleToLogSuperFieldMock(){
		Price stubbedPrice = new Price(10,"€");
		
		when(plantWatererSpy.getPrice()).thenReturn(stubbedPrice);
		
		System.out.println(plantWatererSpy.getPrice().toString());
	}
	
	
}
