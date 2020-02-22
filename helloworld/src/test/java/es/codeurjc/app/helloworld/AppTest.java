package es.codeurjc.app.helloworld;

import org.testng.annotations.*;
import org.testng.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void pruebaSuma() {
		int result = 3 + 4;
		Assert.assertEquals(result, 8);
	}
	
}
