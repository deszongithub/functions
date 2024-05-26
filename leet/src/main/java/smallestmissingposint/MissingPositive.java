package smallestmissingposint;

import java.util.HashMap;
import java.util.Map;

public class MissingPositive {

	public int firstMissingPositive(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 1;
		}
		var len = nums.length;

		for (int i = 0; i < len; i++) {
			var num = nums[i];

			// Swap numbers until they are in the right position.

			while (num >= 1 && num <= len && num != nums[num - 1]) {
				int temp = nums[num - 1];

				nums[num - 1] = num;
				num = temp;

			}

		}

		for (int i = 0; i < len; i++) {

			var num = nums[i];

			if (num != i + 1) {
				return ++i;
			}
		}
		return ++len;
	}

	public int longestArithSeqLength(int[] A) {
		// dp的键值对代表含义：key -> 等差数列的数值之差； value -> map
		// map的键值对代表含义：key -> 以 A[i] 作为结尾的等差数列； value -> 该等差数列最长的长度
		Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
		int ans = 2;
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				Map<Integer, Integer> map = dp.computeIfAbsent(A[j] - A[i], diff -> new HashMap<>());
				map.put(j, map.getOrDefault(i, 1) + 1);
				ans = Math.max(ans, map.get(j));
			}
		}
		return ans;
	}

}
