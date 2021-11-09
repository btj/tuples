package tuples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TupleTest {

	@Test
	void test() {
		Object[] elements = {10, true, "Hello"};
		Tuple tuple = new Tuple(elements);
		assertEquals(3, tuple.getLength());
		assertEquals(true, tuple.getElementAt(1));
		assertArrayEquals(elements, tuple.getElements());
		assertTrue(tuple.equals(new Tuple(elements)));
		assertEquals(tuple, new Tuple(elements));
		assertNotEquals(tuple, new Tuple(new Object[] {20, false}));
	}

}
