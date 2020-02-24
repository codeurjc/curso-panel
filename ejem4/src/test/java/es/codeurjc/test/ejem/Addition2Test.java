package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ MyListener.class })
public class Addition2Test {
	
	@Test(priority=1, groups="smoke")
	public void example1Test() {
		System.out.println("example1Test()");
		assertEquals(1+1, 2);
	}
	
	@Test(priority=2, groups="UI")
	public void example2Test() {
		System.out.println("example2Test()");
		assertEquals(2+2, 4);
	}
	
	@Test(priority=3, groups="regression")
	public void example3Test() {
		System.out.println("example3Test()");
		assertEquals(3+3, 6);
	}

}
