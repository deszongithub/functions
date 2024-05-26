package mediantwosortedarrays;

public class MedianSolution {

	int length = -1;
	int m;
	int n;

	private double calcArrayMedian(int[] arr) {
		var m = arr.length;
		if (m == 1)
			return arr[0];
		--m;
		return arr.length % 2 == 1 ? arr[(m / 2)] : (arr[m / 2] + arr[(m / 2) + 1]) / 2d;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		m = nums1.length;
		n = nums2.length;

		if (m > 10E3 || n > 10E3 || m + n < 1 || length > 10E3 * 2)
			return Double.NaN;
		else
			length = m + n;

		if (m == length) {
			return calcArrayMedian(nums1);
		}
		if (n == length) {

			return calcArrayMedian(nums2);
		}
		var len = length / 2;
		if (length % 2 == 0) {
			
			for (int i = 0; i < len - 1; ++i) {
				getMin(nums1, nums2);
			}
			return  (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2d;
		} else {
			for (int i = 0; i < len; ++i) {
				getMin(nums1, nums2);
			}
			return getMin(nums1, nums2);
		}

	}

	int p1 = 0, p2 = 0;

	private int getMin(int[] nums1, int[] nums2) {

		if (p1 < m & p2 < n) {
			return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];

		} else if (p1 < m) {
			return nums1[p1++];
		} else if (p2 < n) {
			return nums2[p2++];
		}

		return -1;

	}

}
