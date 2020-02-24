package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parallel2Test {

	@DataProvider(name = "numbers", parallel = true)
	public static Object[][] data() {
		
		Object[][] values = {
			{ 0, 0, 0 }, 
			{ 1, 1, 2 },
			{ 2, 3, 5 },
			{ 5, 4, 9 }
		};
		return values;
	}

	@Test(dataProvider = "numbers")
	public void test(int opA, int opB, int result) {
		System.out.println("Current Thread: "+Thread.currentThread().getId());
		assertEquals(opA + opB, result);
	}
  
}