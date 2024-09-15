public class P1371 {

	public int findTheLongestSubstring(String s) {
		int maxlength = 0;
		int[] letters = new int[26];
		letters['a' - 'a'] = 1;
		letters['e' - 'a'] = 2;
		letters['i' - 'a'] = 4;
		letters['o' - 'a'] = 8;
		letters['u' - 'a'] = 16;

		int[] states = new int[32];
		for (int i = 0; i < states.length; i++) {
			states[i] = -1;
		}

		int xor = 0;

		for (int i = 0; i < s.length(); i++) {
			xor ^= letters[s.charAt(i) - 'a'];
			if (xor != 0 && states[xor] == -1) {
				states[xor] = i;
			}
			int tempLength = i - states[xor];
			maxlength = maxlength > tempLength ? maxlength : tempLength;
		}

		return maxlength;
	}

}
