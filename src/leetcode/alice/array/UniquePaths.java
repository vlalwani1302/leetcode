package leetcode.alice.array;

class UniquePaths {

	public static void main(String[] args) {

		Integer result1 = uniquePaths(51, 9);
		System.out.println(result1);
	}

	public static int uniquePaths(int m, int n) {

		if (m == 1 || n == 1) {
			return 1;
		}
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

}