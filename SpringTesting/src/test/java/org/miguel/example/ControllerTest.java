package org.miguel.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-context.xml")
public class ControllerTest {

	@Autowired
	SomeDepedency someDependency;
	
	@Test
	public void shouldResolveDependencyWithAMockAndSpringAutowired(){
		assertNotNull(someDependency);
	}
	
}
