package maps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestLongestCommonSequence {

	LongestCommonSequence test = new LongestCommonSequence();

	@Test
	@DisplayName("[flow, flowerpot, float] -> flo")
	void t1() {
		assertEquals("flo", test.exec(new String[] { "flow", "flowerpot", "float" }).get());
	}

	@Test
	@DisplayName("[fleu, flowerpot, flew] -> fl")
	void t2() {
		assertEquals("fl", test.exec(new String[] { "flue", "flowerpot", "flew" }).get());
	}

	@Test
	@DisplayName("[flow, flowerpot, flood] -> flo")
	void t3() {
		assertEquals("flo", test.exec(new String[] { "flow", "flowerpot", "flood" }).get());
	}

	@Test
	@DisplayName("[codex, decode, coder] -> code")
	void t4() {
		assertEquals("code", test.exec(new String[] { "codex", "decode", "coder" }).get());
	}

	@Test
	@DisplayName("[full, wishful, hopeful, successful] -> ful")
	void t5() {
		assertEquals("ful", test.exec(new String[] { "full", "wishful", "hopeful", "successful" }).get());
	}

	@Test
	@DisplayName("Assert no matching common sequence -> empty")
	void t6() {
		assertEquals(Optional.empty(), test.exec(new String[] { "wish", "scope", "smoke" }));
	}

	@Test
	@DisplayName("Single String fixture -> empty")
	void t7() {
		assertEquals(Optional.empty(), test.exec(new String[] { "smoke" }));
	}

	@Test
	@DisplayName("Null input -> empty")
	void t8() {
		assertEquals(Optional.empty(), test.exec(null));
	}

	@Test
	@DisplayName("new String[] { null,..,. } -> nulls filtered")
	void t9() {
		assertEquals("her", test.exec(new String[] { null, "her", "heron" }).orElseThrow());
	}

	@Test
	@DisplayName("new String[] { null, .. } -> empty")
	void t10() {
		assertEquals(Optional.empty(), test.exec(new String[] { null, "heron" }));
	}

	@Test
	@DisplayName("Empty strings -> empty")
	void t11() {
		assertEquals(Optional.empty(), test.exec(new String[] { "", "", " " }));
	}
	
	@Test
	@DisplayName("3 empty strings -> empty")
	void t12() {
		assertEquals(Optional.empty(), test.exec(new String[] { "  ", "  ", " " }));
	}

	/*
	 * @Test
	 * 
	 * @DisplayName("factorial operation 4 -> 24") void t11() { assertEquals(24,
	 * strings.findFact(4)); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("factorial operation 20 -> 2432902008176640000") void t12() {
	 * assertEquals(2432902008176640000L, strings.findFact(20)); }
	 */

}
