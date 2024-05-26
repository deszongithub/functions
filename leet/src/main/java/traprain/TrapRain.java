package traprain;

public class TrapRain {

	public int trap(int[] h) {

		int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;

		for (; l < r;) {

			lmax = h[l] > lmax ? h[l] : lmax;
			rmax = h[r] > rmax ? h[r] : rmax;
			ans += lmax < rmax ? lmax - h[l++] : rmax - h[r--];
		}

		return ans;

	}

}
