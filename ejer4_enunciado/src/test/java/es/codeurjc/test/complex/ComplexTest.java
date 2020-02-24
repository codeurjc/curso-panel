package es.codeurjc.test.complex;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComplexTest {

	private Complex zero;

	@BeforeMethod
	public void setUp() {
		zero = new Complex(0, 0);
	}

	@Test
	public void givenZero_thenRealPartIsZero_And_ImagPartIsZero() {
		
		assertEquals(0, zero.getRealPart(), 0.001);
		assertEquals(0, zero.getImaginaryPart(), 0.001);
	}

	@Test
	public void givenZeroAndOne_whenZeroAddToOne_thenOneIsObtained() {

		//Given
		Complex one = new Complex(1, 1);
		
		//When
		Complex result = zero.add(one);
		
		//Then		
		assertEquals(new Complex(1, 1), result);
	}

	@Test
	public void givenZeroAndOne_whenOneAddZero_thenOneIsObtained() {

		//Given
		Complex one = new Complex(1, 1);
		
		//When
		Complex result = one.add(zero);
		
		//Then		
		assertEquals(new Complex(1, 1), result);
	}
	
	@Test
	public void GivenComplex0_0_whenReciprocal_thenExceptionIsThrown() {
		fail("Not implemented yet");
		// TODO
	}
}
