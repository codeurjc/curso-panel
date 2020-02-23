package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest {
	
	@DataProvider(name = "numbers")
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
		assertEquals(opA + opB, result);
	}
}