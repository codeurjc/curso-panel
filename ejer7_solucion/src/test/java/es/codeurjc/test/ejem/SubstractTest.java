package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class SubstractTest {
	
	@Test(groups="smoke")
	public void example1SubstractTest() {
		System.out.println("example1SubstractTest()");
		assertEquals(1-1, 0);
	}
	
	@Test(groups="UI")
	public void example2SubstractTest() {
		System.out.println("example2SubstractTest()");
		assertEquals(2-2, 0);
	}
	
	@Test(groups="regression")
	public void example3SubstractTest() {
		System.out.println("example3SubstractTest()");
		assertEquals(3-3, 0);
	}

}
