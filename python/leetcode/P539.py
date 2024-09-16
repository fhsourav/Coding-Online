class Solution:
	def findMinDifference(self, timePoints: list[str]) -> int:
		timeSlots = []
		for i in range(24 * 60):
			timeSlots.append(False)

		for i in range(len(timePoints)):
			timePoint = timePoints[i]
			hour = int(timePoint[0 : 2])
			minute = int(timePoint[3:])
			timeInMinutes = (hour * 60) + minute
			if timeSlots[timeInMinutes]:
				return 0
			timeSlots[timeInMinutes] = True

		minDifference = float('inf')
		currentDifference = float('inf')
		prevTime = -1

		firstTime = float('inf')
		lastTime = float('inf')

		for i in range(len(timeSlots)):
			if timeSlots[i]:
				if firstTime == float('inf'):
					firstTime = i

				lastTime = i

				if prevTime is not -1:
					currentDifference = i - prevTime
				
				prevTime = i
				minDifference = min(minDifference, currentDifference)
		
		currentDifference = (24 * 60) - (lastTime - firstTime)

		return min(minDifference, currentDifference)
