package leet;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int[] cache = new int[128];
		int i = 0;
		int j = 0;

		for (char ch : s.toCharArray()) {
			if (cache[ch] > j)
				j = cache[ch];
			cache[ch] = i + 1;
			int len = i - j + 1;
			if (len > result)
				result = len;
			i++;
		}

		return result;
	}
}
