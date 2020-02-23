package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class AppTest {
	
	@Test
	public void testSuma() {
		assertEquals("Text", "Text");
	}
	
	@Test
	public void testSuma2() {
		int sum = 1 + 1;
		assertTrue(sum == 2);
	}
}
