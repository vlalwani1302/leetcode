package leetcode.alice.array;

import java.util.HashSet;
import java.util.Set;

import leetcode.alice.Utility;

class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix);
		Utility.printMatrix(matrix);
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
}