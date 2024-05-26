package smallestmissingposint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMissingPositive {

	MissingPositive test = new MissingPositive();

	@Test
	void test_Max() {
		assertEquals(4, test
				.firstMissingPositive(new int[] { 2147483647, 2147483646, 2147483645, 3, 2, 1, -1, 0, -2147483648 }));
	}

	@Test
	void test_Min1421910() {
		assertEquals(3, test.firstMissingPositive(new int[] { -1, 4, 2, 1, 9, 10 }));
	}

	@Test
	void test_126354() {
		assertEquals(7, test.firstMissingPositive(new int[] { 1, 2, 6, 3, 5, 4 }));
	}

	@Test
	void test_1() {
		assertEquals(2, test.firstMissingPositive(new int[] { 1 }));
	}

	@Test
	void test_11() {
		assertEquals(2, test.firstMissingPositive(new int[] { 1, 1 }));
	}

	@Test
	void test_110() {
		assertEquals(2, test.firstMissingPositive(new int[] { 1, 10 }));
	}

	@Test
	void test_21() {
		assertEquals(3, test.firstMissingPositive(new int[] { 2, 1 }));
	}

	@Test
	void test_212() {
		assertEquals(3, test.firstMissingPositive(new int[] { 2, 1, 2 }));
	}

	@Test
	void test_123() {
		assertEquals(4, test.firstMissingPositive(new int[] { 1, 2, 3 }));
	}

	@Test
	void test_234() {
		assertEquals(1, test.firstMissingPositive(new int[] { 2, 3, 4 }));
	}

	@Test
	void test_1235() {
		assertEquals(4, test.firstMissingPositive(new int[] { 1, 2, 3, 6 }));
	}

	@Test
	void test_120() {
		assertEquals(3, test.firstMissingPositive(new int[] { 1, 2, 0 }));
	}

	@Test
	void test_34Min11() {
		assertEquals(2, test.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
	}

	@Test
	void test_7To12() {
		assertEquals(1, test.firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	@Test
	void test_7891() {
		assertEquals(2, test.firstMissingPositive(new int[] { 7, 8, 9, 1 }));
	}

}
