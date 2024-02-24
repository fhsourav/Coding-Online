class Solution:
	def maxArea(self, height: list[int]) -> int:
		areaMax = 0
		leftmax_X = 0
		leftmax_Y = height[0]
		endpoints = {}

		for x in range(1, len(height)):
			y = height[x]
			y_reach = min(y, leftmax_Y)
			if y_reach not in endpoints.keys():
				endpoints[y_reach] = []
			endpoints[y_reach].append(leftmax_X)
			endpoints[y_reach].append(x)
			if y > leftmax_Y:
				leftmax_X = x
				leftmax_Y = y

		height_sorted = sorted(endpoints.keys(), reverse=True)

		leftmax = len(height) + 1
		rightmax = -1
		areaMax = 0

		for key in height_sorted:
			leftmax = min(endpoints[key][0], leftmax)
			rightmax = max(endpoints[key][-1], rightmax)

			area = key * (rightmax - leftmax)
			areaMax = max(area, areaMax)

		return areaMax
