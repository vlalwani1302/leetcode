package leetcode.alice.array;

class UniquePaths {

	public static void main(String[] args) {

		Integer result1 = uniquePaths(51, 9);
		System.out.println(result1);
		
		System.out.println(uniquePathsDP(51, 9));
	}

	public static int uniquePaths(int m, int n) {

		if (m == 1 || n == 1) {
			return 1;
		}
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	public static int uniquePathsDP(int m, int n) {

		int[][] count = new int[m][n];

		for (int i = 0; i < m; i++) {
			count[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			count[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				count[i][j] = count[i-1][j] + count[i][j-1];
			}
		}
		
		return count[m-1][n-1];
	}

}