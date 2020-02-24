package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sum2Test {
	
	@Test
	@Parameters({ "opA", "opB", "result" })
	public void test(int opA, int opB, int result) {
		assertEquals(opA + opB, result);
	}
	
}
