class Solution:
	def findTheLongestSubstring(self, s: str) -> int:
		maxlength = 0
		letters = []
		for i in range(26):
			if i is ord('a') - ord('a'):
				letters.append(1)
			elif i is ord('e') - ord('a'):
				letters.append(2)
			elif i is ord('i') - ord('a'):
				letters.append(4)
			elif i is ord('o') - ord('a'):
				letters.append(8)
			elif i is ord('u') - ord('a'):
				letters.append(16)
			else:
				letters.append(0)
		
		states = []
		for i in range(32):
			states.append(-1)

		xor = 0
		for idx, letter in enumerate(s):
			xor ^= letters[ord(letter) - ord('a')]
			if not xor == 0 and states[xor] == -1:
				states[xor] = idx
			maxlength = max(maxlength, (idx - states[xor]))
		
		return maxlength
