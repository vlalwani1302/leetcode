package leetcode.alice.array;

class WordSearch {

	static boolean visited[][];

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCCED"));
		
		char[][] board1 = new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
		System.out.println(exist(board1, "AAB"));

	}

	public static boolean exist(char[][] board, String word) {
		if (board.length > 0) {
			visited = new boolean[board.length][board[0].length];
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0) && wordSearch(board, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;

	}

	private static boolean wordSearch(char[][] board, int i, int j, int index, String word) {
		if (index == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
				|| board[i][j] != word.charAt(index)) {
			return false;
		}
		visited[i][j] = true;
		if (wordSearch(board, i + 1, j, index + 1, word) || wordSearch(board, i, j + 1, index + 1, word)
				|| wordSearch(board, i - 1, j, index + 1, word) || wordSearch(board, i, j - 1, index + 1, word)) {
			return true;
		}
		visited[i][j] = false;

		return false;

	}
}