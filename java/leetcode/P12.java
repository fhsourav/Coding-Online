public class P12 {
	public String intToRoman(int num) {
		int[] keys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder roman = new StringBuilder();
		for (int i = 0; i < keys.length && num > 0; i++) {
			int count = num / keys[i];
			num %= keys[i];
			for (int j = 0; j < count; j++) {
				roman.append(values[i]);
			}
		}
		return roman.toString();
	}
}
