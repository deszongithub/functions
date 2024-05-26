package palindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static palindrome.Palindrome.bip;
import static palindrome.Palindrome.intFunc;
import static palindrome.Palindrome.isPalindrome;
import static palindrome.Palindrome.randomise;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class TestPalindrome {

	@Test
	void testXX() {
		assertTrue(() -> isPalindrome.test("XX"));
	}

	@Test
	void testXXXX() {
		assertTrue(isPalindrome.test("XXXX"));
	}

	@Test
	void testUnEvenAllX() {
		assertTrue(isPalindrome.test("XXXXX"));
	}

	@Test
	void testSentence() {
		assertTrue(isPalindrome.test("sir I demand I am a maid named Iris"));
	}

	@Test
	void testUnEvenNotAllX() {
		assertFalse(isPalindrome.test("XXXXd"));
	}

	@Test
	void testXYXY() {
		assertFalse(isPalindrome.test("XYXY"));
	}

	@Test
	void testracecar() {
		assertTrue(isPalindrome.test("racecar"));
	}

	@Test
	void testmadam() {
		assertTrue(isPalindrome.test("madam"));
	}

	@Test
	void testRandomise() {

		Set<String> strings = new HashSet<>();
		var v = "noon";// babad, ababadd, madam, noon, Saippuakivikauppias

		int num = v.length();
		var factorial = new AtomicInteger(1);

		IntStream.rangeClosed(1, num).forEach(c ->

		{
			factorial.set(BigInteger.valueOf(factorial.get()).multiply(BigInteger.valueOf(num)).intValue());
		});

		// add to Set and only proceed if novel.

		int k = 0;
		int sumPal = 0;
		for (; k < factorial.intValue(); ++k) {
			var perm = randomise.apply(v);

			sumPal = bip.test(strings, perm) ? sumPal += perm.length() / 2 : sumPal;

		}

		System.out.println(String.format("%d = max. palindrome", intFunc.applyAsInt(strings)));
		System.out.println(String.format("%d = palindromic permutations of %s", sumPal, v));

	}

}
