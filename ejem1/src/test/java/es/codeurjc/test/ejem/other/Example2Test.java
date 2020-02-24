package es.codeurjc.test.ejem.other;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Example2Test {
	@Test
	public void test2() {
		int sum = 1 + 1;
		assertTrue(sum == 2);
	}
}
