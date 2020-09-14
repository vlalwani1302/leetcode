package leetcode.john.medium;

class NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		numIslands(grid);
	}
    public static int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    numIslands(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public static void numIslands(char[][] grid, int m, int n){
        if(m <0 || n <0 || m >= grid.length || n >= grid[m].length || grid[m][n] != '1'){
            return;
        }
        grid[m][n] = '*';
        numIslands(grid, m+1, n);
        numIslands(grid, m, n+1);
        numIslands(grid, m-1, n);
        numIslands(grid, m, n-1);
    }
}