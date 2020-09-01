package leetcode.alice.array;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		spiralOrder(matrix);
	}
	
    public static List<Integer> spiralOrder(int[][] matrix) {
     
    	int row;
        int col;
        if(matrix.length > 0){
            row = matrix.length;
            col = matrix[0].length;

        }else{
            return new ArrayList<Integer>();
        }
        
        int left = 0, right = col, up = 0, down = row;
        List<Integer> l = new ArrayList<Integer>();
        
        int i;
        
        while (up < down && left < right) { 
            // Print the first row from the remaining rows 
            for (i = left; i < right; ++i) { 
            	l.add(matrix[up][i]);
                System.out.print(matrix[up][i] + " "); 
            } 
            up++; 
  
            // Print the leftast coleftumn from the remaining coleftumns 
            for (i = up; i < down; ++i) { 
            	l.add(matrix[i][right -1]);

                System.out.print(matrix[i][right - 1] + " "); 
            } 
            right--; 
  
            // Print the last row from the remaining rows */ 
            if (up < down) { 
                for (i = right - 1; i >= left; --i) { 
                	l.add(matrix[down-1][i]);

                    System.out.print(matrix[down - 1][i] + " "); 
                } 
                down--; 
            } 
  
            // Print the first column from the remaining columns */ 
            if (left < right) { 
                for (i = down - 1; i >= up; --i) { 
                	l.add(matrix[i][left]);

                    System.out.print(matrix[i][left] + " "); 
                } 
                left++; 
            } 
        } 
        return l;
    }
}