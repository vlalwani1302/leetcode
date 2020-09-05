package leetcode.alice.array;

import java.util.HashSet;
import java.util.Set;

import leetcode.alice.Utility;

class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix);
		Utility.printMatrix(matrix);

		int[][] matrix1 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes1(matrix1);
		Utility.printMatrix(matrix1);

	}

	public static void setZeroes(int[][] matrix) {
		if (matrix.length > 0) {

			Set<Integer> rowSet = new HashSet<Integer>();
			Set<Integer> colSet = new HashSet<Integer>();

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == 0) {
						// mark entire row as zero
						rowSet.add(i);
						colSet.add(j);
					}
				}
			}

			for (int i = 0; i < matrix.length; i++) {
				int col = -1;
				for (int j = 0; j < matrix[i].length; j++) {
					if (rowSet.contains(i)) {
						matrix[i][j] = 0;
					}
					if (colSet.contains(j)) {
						col = j;
					}
					if (col > -1) {
						matrix[i][col] = 0;
						col = -1;
					}
				}
			}
		}
	}

	// Space complexity - O(1)
	public static void setZeroes1(int[][] matrix) {
		int newValue = -2147483647;
		if (matrix.length > 0) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == 0) {
						// mark entire row as something else
						for (int r = 0; r < matrix.length; r++) {
							if(matrix[r][j] != 0)
								matrix[r][j] = newValue;
						}
						// mark entire column as something else
						for (int c = 0; c < matrix[i].length; c++) {
							if(matrix[i][c] != 0)
								matrix[i][c] = newValue;
						}
					}
				}
			}

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == newValue) {
						matrix[i][j] = 0;
					}
				}
			}
		}
	}

}