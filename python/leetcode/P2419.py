class Solution:
	def longestSubarray(self, nums: list[int]) -> int:
		maxval = ans = currentStreak = 0;

		for num in nums:
			if num > maxval:
				maxval = num
				ans = currentStreak = 0

			if num == maxval:
				currentStreak += 1
			else:
				currentStreak = 0

			ans = max(ans, currentStreak)

		return ans
