package es.codeurjc.test.ejem;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class GroupsTest {
	
	@Test(groups = { "suma" })
	public void testSuma() {
		int sum = 1 + 1;
		assertTrue(sum == 2);
	}
	
	@Test(groups = { "resta", "suma" })
	public void testSumaYResta() {
		int sum = 1 + 1;
		assertTrue(sum == 2);
		int res = 1 - 1;
		assertTrue(res == 0);
	}
	
	@Test(groups = { "resta" })
	public void testResta() {
		int res = 1 - 1;
		assertTrue(res == 0);
	}

}
