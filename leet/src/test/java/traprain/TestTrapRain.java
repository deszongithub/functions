package traprain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTrapRain {

	TrapRain test = new TrapRain();
	
	@Test
	void test() {
		assertNotNull( test.trap(new int[]{4}));
	}
	
	@Test
	void test_420325() {
		assertEquals(9, test.trap(new int[]{4,2,0,3,2,5}));
	}
	
	@Test
	void test_5555() {
		assertEquals(0, test.trap(new int[]{5,5,5,5}));
	}
	
	@Test
	void test_5554() {
		assertEquals(0, test.trap(new int[]{5,3,1,4}));
	}

}
