package es.codeurjc.test.ejem;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

public class ParallelTest {

  @Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
  public void testSuma() {
	  
	int randomInt = new Random().nextInt();
	
    // Arrange / Given
    Calculadora calculadora = new Calculadora();

    // Act / When
    int res = calculadora.suma(randomInt, randomInt);

    // Assert / Then
    assertEquals(2*randomInt, res, 0);
  }
  
}