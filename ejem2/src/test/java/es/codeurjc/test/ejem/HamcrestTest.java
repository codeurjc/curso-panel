package es.codeurjc.test.ejem;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

public class HamcrestTest {
	
	@Test
	public void testAssertThatEquals() {
		assertThat("pepe", equalTo("juan"));
	}	
	
	@Test
	public void testAssertStartsWith() {
		assertThat("pepe", startsWith("ju"));
	}
}
