public class P11 {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int areaMax = 0;
		while (left < right) {
			int h1 = height[left], h2 = height[right];
			int area = (h1 < h2 ? h1 : h2) * (right - left);
			areaMax = area > areaMax ? area : areaMax;
			if (h1 < h2) {
				left++;
			} else {
				right--;
			}
		}
		return areaMax;
	}
}
