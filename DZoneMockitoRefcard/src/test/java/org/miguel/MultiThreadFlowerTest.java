package org.miguel;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MultiThreadFlowerTest {

	@Before
	public void setUp() {

	}

	/**
	 * Not deterministic
	 * */
	@Test
	public void shouldFailForLateCall() {
		final WaterSource waterSourceMock = mock(WaterSource.class);

		Thread t = waitAndCallSelfCheck(1000L, waterSourceMock);

		t.start();

		verify(waterSourceMock, never()).doSelfCheck();
		verify(waterSourceMock, timeout(1000)).doSelfCheck();

	}

	private Thread waitAndCallSelfCheck(final long duration, final WaterSource waterSource) {
		Thread theThread = null;

		theThread = new Thread(new Runnable() {
			public void run() {
				// this.wait(duration);
				try {
					Thread.sleep(duration);
					
					waterSource.doSelfCheck();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
		});


		return theThread;
	}

}
