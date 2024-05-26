package maps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestMockedLongestCommonSequence {

	@Mock
	Map<String, Integer> map = new HashMap<>();

	LongestCommonSequence lcs = new LongestCommonSequence();

	
	@Test
	void test() {

		map.put("ff", 1);
		when(map.keySet()).thenReturn(Set.of());
		var in = new String[] { "won", "on" };
		var actual = lcs.exec(in).orElseThrow();
		verify(map).keySet();
		assertEquals("on", actual);
	}

}
