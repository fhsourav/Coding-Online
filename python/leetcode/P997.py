class Solution:
	def findJudge(self, n: int, trust: list[list[int]]) -> int:
		trusted_by = [-2]
		trust_dict = {}

		for i in range(n):
			trusted_by.append(0)
			trust_dict[i + 1] = []

		for i in trust:
			trust_dict[i[0]].append(i[1])
			trusted_by[i[1]] += 1

		judge = -1
		if n - 1 in trusted_by:
			judge = trusted_by.index(n - 1)

		if judge == -1:
			return -1
		
		if not trust_dict[judge]:
			return judge
		
		return -1
