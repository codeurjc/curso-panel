package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calculadora5Test {

	Calculadora calc;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Before all tests");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Before test");
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
	
	@AfterMethod
	public void teardown() {
		System.out.println("After test");
	}
	
	@AfterClass
	public static void teardownClass() {
		System.out.println("After all tests");
	}
}