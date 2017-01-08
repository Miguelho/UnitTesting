package org.miguel.mockvalues;

import org.junit.Before;
import org.junit.Test;
import org.miguel.WaterSource;
import org.miguel.WateringScheduler;
import org.miguel.model.PlantWaterer;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class SmartNullTest {

	@Mock
	WaterSource waterSourceMock;
	
	@Mock
	WateringScheduler waterSchedulerMock;
	
//	As MockitoConfiguration class can be found in org.mockito.configuration, this answer definition is not needed.
//	@Mock(answer=Answers.RETURNS_SMART_NULLS)
	@Mock
	PlantWaterer plantWatererMock; 
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
//		plantWatererMock  = new PlantWaterer(waterSourceMock,waterSchedulerMock);
	}
	
	@Test
	public void verifySmartNullsReturned(){
		assertNotNull(plantWatererMock);		

		
		plantWatererMock.getWaterSource().getWaterPressure();

//		assertNotNull(plantWatererMock.getWaterSource());
	}
}
