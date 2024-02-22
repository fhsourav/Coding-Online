public class P997 {
	public int findJudge(int n, int[][] trust) {
		int trustedBy[] = new int[n + 1];
		int trusts[] = new int[n + 1];

		for (int i = 0; i < trust.length; i++) {
			int[] temp = trust[i];
			trustedBy[temp[1]]++;
			trusts[temp[0]]++;
		}

		int judge = -1;

		for (int i = 1; i < trustedBy.length; i++) {
			if (trustedBy[i] == n - 1) {
				judge = i;
			}
		}

		if (judge == -1 || trusts[judge] != 0)
			return -1;

		return judge;
	}
}
