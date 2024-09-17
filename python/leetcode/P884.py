class Solution:
	def uncommonFromSentences(self, s1: str, s2: str) -> list[str]:
		wordCounts = {}

		for word in s1.split():
			wordCounts[word] = wordCounts.get(word, 0) + 1

		for word in s2.split():
			wordCounts[word] = wordCounts.get(word, 0) + 1

		return [word for word in wordCounts if wordCounts[word] == 1]
