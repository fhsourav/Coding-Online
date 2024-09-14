public class P2419 {
	public int longestSubarray(int[] nums) {
		int maxval = 0;
		int ans = 0;
		int currentStreak = 0;

		for (int num : nums) {
			if (num > maxval) {
				maxval = num;
				ans = currentStreak = 0;
			}

			if (num == maxval) {
				currentStreak++;
			} else {
				currentStreak = 0;
			}

			ans = ans > currentStreak ? ans : currentStreak;
		}

		return ans;
	}
}
