package mediantwosortedarrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMedianSolution {

	MedianSolution test = new MedianSolution();

	@Test
	void test333AndNeg333() {
		assertEquals(3.0, test.findMedianSortedArrays(new int[] { 3, 3, 3 }, new int[] { -3, 3, 3 }));
	}

	@Test
	void testBothEmpty() {
		assertEquals(Double.NaN, test.findMedianSortedArrays(new int[] {}, new int[] {}));
	}

	@Test
	void testEmptyAndSingle() {
		assertEquals(1, test.findMedianSortedArrays(new int[] {}, new int[] { 1 }));
	}

	@Test
	void test12AndNeg13() {
		assertEquals(1.5, test.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { -1, 3 }));
	}

	@Test
	void test13And24() {
		assertEquals(2.5, test.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2, 4 }));
	}

	@Test
	void test1And1() {
		assertEquals(1, test.findMedianSortedArrays(new int[] { 1 }, new int[] { 1 }));
	}

	@Test
	void test1And2() {
		assertEquals(1.5, test.findMedianSortedArrays(new int[] { 1 }, new int[] { 2 }));
	}

	@Test
	void test12And34() {
		assertEquals(2.5, test.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
	}

	@Test
	void test3AndNeg21() {
		assertEquals(-1.0, test.findMedianSortedArrays(new int[] { 3 }, new int[] { -2, -1 }));
	}

	@Test
	void testBoth1To5Elements() {
		assertEquals(3, test.findMedianSortedArrays(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	void testEmptyAnd1to5() {
		assertEquals(3, test.findMedianSortedArrays(new int[] {}, new int[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	void testEmptyAnd1To6() {
		assertEquals(3.5, test.findMedianSortedArrays(new int[] {}, new int[] { 1, 2, 3, 4, 5, 6 }));
	}

	@Test
	void testEmptyAnd1To6WithNegative3() {
		assertEquals(3, test.findMedianSortedArrays(new int[] {}, new int[] { -3, 1, 2, 4, 5, 6 }));
	}

	@Test
	void test123AndMinusPairTo6() {
		assertEquals(2, test.findMedianSortedArrays(new int[] { 1, 2, 3 }, new int[] { -100, -3, 1, 2, 4, 5, 6 }));
	}

	@Test
	void testEmptyAnd23() {
		assertEquals(2.5, test.findMedianSortedArrays(new int[] {}, new int[] { 2, 3 }));
	}

	@Test
	void testEmptyAnd13() {
		assertEquals(2, test.findMedianSortedArrays(new int[] {}, new int[] { 1, 3 }));
	}

	@Test
	void testEven31And42() {
		assertEquals(2.5, test.findMedianSortedArrays(new int[] { 3, 1 }, new int[] { 4, 2 }));
	}

	@Test
	void test123And12() {
		assertEquals(2, test.findMedianSortedArrays(new int[] { 1, 2, 3 }, new int[] { 1, 2 }));
	}

	@Test
	void test11And11() {
		assertEquals(1, test.findMedianSortedArrays(new int[] { 1, 1 }, new int[] { 1, 1 }));
	}

	@Test
	void test12And12() {
		assertEquals(1.5, test.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2 }));
	}

	@Test
	void test1And23() {
		assertEquals(2, test.findMedianSortedArrays(new int[] { 1 }, new int[] { 2, 3 }));
	}

	@Test
	void test12And123() {
		assertEquals(2, test.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
	}

	@Test
	void test12And124() {
		assertEquals(2, test.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2, 4 }));
	}

	@Test
	void test13And2() {
		assertEquals(2, test.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
	}

	@Test
	void testEmptyAnd1To4() {
		assertEquals(2.5, test.findMedianSortedArrays(new int[] {}, new int[] { 1, 2, 3, 4 }));
	}

	@Test
	void testZerosAndZerosAndNeg() {
		assertEquals(0, test.findMedianSortedArrays(new int[] { 0, 0, 0, 0, 0 }, new int[] { -1, 0, 0, 0, 0, 0, 1 }));
	}

	@Test
	void testEvenLarge() {
		assertEquals(6, test.findMedianSortedArrays(new int[] { 1, 1, 2, 3, 5, 8, 13, 21 },
				new int[] { 2, 3, 5, 7, 11, 13, 17, 19 }));
	}
}
