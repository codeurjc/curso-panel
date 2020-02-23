package es.codeurjc.app.helloworld;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void sumaTest() {
		// Test implementation
		int result = 3 + 4;
		Assert.assertEquals(result, 8);
	}
	
}
