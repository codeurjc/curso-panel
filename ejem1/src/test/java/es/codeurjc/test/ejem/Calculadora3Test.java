package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class Calculadora3Test {

	@Test
	public void testSuma() {

		Calculadora calculadora = new Calculadora();
		int res = calculadora.suma(1, 1);
		assertEquals(2, res, "1+1 should be equal to 2");
	}

	@Test
	public void testResta() {

		Calculadora calculadora = new Calculadora();
		int res = calculadora.resta(1, 1);
		assertEquals(0, res, "1-1 should be equal to 0");
	}
}