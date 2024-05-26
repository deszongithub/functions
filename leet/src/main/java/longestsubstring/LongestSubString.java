package longestsubstring;

public class LongestSubString {

	final int[] charsArray = new int[128];

	public int lengthOfLongestSubstring(final String s) {
		int len = 0, res = 0;
		char c;
		char j = 0;
		for (int i = 0; i < s.length(); i++) {

			c = s.charAt(i);
			j = (char) (charsArray[c] > j ? charsArray[c] : j);

			charsArray[c] = i + 1;

			len = i - j + 1;
			res = len > res ? len : res;

		}

		return res;
	}

}
