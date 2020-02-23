package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calculadora4Test {

	Calculadora calc;

	@BeforeMethod
	public void setUp() {
		this.calc = new Calculadora();
	}

	@Test
	public void testSuma() {

		int res = calc.suma(1, 1);
		assertEquals(2, res, "1+1 should be equal to 2");
	}

	@Test
	public void testResta() {

		int res = calc.resta(1, 1);
		assertEquals(0, res, "1-1 should be equal to 0");
	}
}