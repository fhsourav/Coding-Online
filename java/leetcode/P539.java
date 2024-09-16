import java.util.List;

public class P539 {
	public int findMinDifference(List<String> timePoints) {
		boolean[] timeSlots = new boolean[24*60];
		for (int i = 0; i < timePoints.size(); i++){
			String timePoint = timePoints.get(i);
			int hour = Integer.parseInt(timePoint.substring(0, 2));
			int min = Integer.parseInt(timePoint.substring(3));
			int timeInMinutes = (hour * 60) + min;
			if (timeSlots[timeInMinutes]) {
				return 0;
			}
			timeSlots[timeInMinutes] = true;
		}

		int minDifference = Integer.MAX_VALUE;
		int currentDifference = Integer.MAX_VALUE;
		int prevTime = -1;

		int firstTime = Integer.MAX_VALUE;
		int lastTime = Integer.MAX_VALUE;

		for (int i = 0; i < timeSlots.length; i++) { // here i represents timeInMinutes
			if (timeSlots[i]) {
				if (firstTime == Integer.MAX_VALUE) {
					firstTime = i;
				}

				lastTime = i;

				if (prevTime != -1) {
					currentDifference = i - prevTime;
				}
				prevTime = i;
				minDifference = currentDifference < minDifference ? currentDifference : minDifference;
			}
		}

		currentDifference = (24 * 60) - (lastTime - firstTime);
		
		return currentDifference < minDifference ? currentDifference : minDifference;
	}
}
