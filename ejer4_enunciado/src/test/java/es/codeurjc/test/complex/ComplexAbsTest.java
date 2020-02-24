package es.codeurjc.test.complex;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ComplexAbsTest {
	
	@DataProvider(name = "complexNumbers")
	public static Object[][] data() {
		
		Object[][] values = {
		    	{ new Complex(0,0),0 },
		        { new Complex(1,1),1.41421},
				{ new Complex(2,2),2.82843},
				{ new Complex(5,5),7.07107},
				{ new Complex(10,10),14.1421},
				{ new Complex(0,0),0},
				{ new Complex(10,1),10.0498},
				{ new Complex(20,2),20.099}
		    };
		return values;
	}

	@Test(dataProvider = "complexNumbers")
	public void absoluteTest(Complex complex, double absolute) {
		assertEquals(complex.abs(), absolute, 0.001);
	}
}
