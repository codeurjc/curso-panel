package es.codeurjc.test.ejem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.testng.annotations.Test;

public class MockTest {

	@Test
	public void testList() {
		// mock creation
		List<Object> mockedList = mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

}
