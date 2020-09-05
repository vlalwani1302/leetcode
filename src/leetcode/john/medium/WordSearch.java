package leetcode.john.medium;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(board[i][j] == word.charAt(0) && floodFill(board, i, j, 0, word)) {
        			return true;
        		}
        	}
        }
        return false;
        
    }
	
	private static boolean floodFill(char[][] board, int i, int j, int count, String word) {
		if(count == word.length())
			return true;
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(count))
			return false;
		
		//since same letter cell cannot be used more than once replace it with blank temporarily
		char temp = board[i][j];
		board[i][j] = ' ';
		boolean exists = floodFill(board, i+1, j, count+1, word)
				|| floodFill(board, i-1, j, count+1, word)
				|| floodFill(board, i, j+1, count+1, word)
				|| floodFill(board, i, j-1, count+1, word);
		board[i][j] = temp;
		return exists;
	}


	public static void main(String[] args) {
		char[][] board = { 
 				{'A', 'B', 'C', 'E'},
 				{'S', 'F', 'C', 'S'},
 				{'A', 'D', 'E', 'E'}
				};
        	System.out.println(exist(board, "ABCCED"));
	}
}
