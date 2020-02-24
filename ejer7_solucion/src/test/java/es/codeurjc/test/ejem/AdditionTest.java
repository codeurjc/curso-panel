package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class AdditionTest {
	
	@Test(groups="smoke")
	public void example1AdditionTest() {
		System.out.println("example1AdditionTest()");
		assertEquals(1+1, 2);
	}
	
	@Test(groups="UI")
	public void example2AdditionTest() {
		System.out.println("example2AdditionTest()");
		assertEquals(2+2, 4);
	}
	
	@Test(groups="regression")
	public void example3AdditionTest() {
		System.out.println("example3AdditionTest()");
		assertEquals(3+3, 6);
	}

}
