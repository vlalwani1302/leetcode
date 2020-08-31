package leetcode.alice.array;

public class RotateImage {
	public static void rotate(int[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = r; c < rows; c++) {
				int temp = matrix[r][c];
				matrix[r][c] = matrix[c][r];
				matrix[c][r] = temp;
			}
		}

		for (int i = 0; i < rows; i++) {
			int l = 0;
			int r = rows - 1;
			while (l < r) {
				int temp = matrix[i][l];
				matrix[i][l] = matrix[i][r];
				matrix[i][r] = temp;
				l++;
				r--;
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		System.out.println("\nRotated matrix1:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}