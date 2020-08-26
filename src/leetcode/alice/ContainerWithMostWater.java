package leetcode.alice;

public class ContainerWithMostWater {

	    public static int maxArea(int[] height) {
	        
	        int maxArea = 0;
	        for(int i=0; i<height.length; i++){
	            for(int j=1; j<height.length; j++){
	                int verticalLineLength = Math.min(height[i], height[j]);
	                int area = verticalLineLength * (j-i);
	                maxArea = Math.max(maxArea, area);

	            }
	        }
	        return maxArea;
	    }

	    public static void main(String[] args) {
			int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
			System.out.println(maxArea(arr));
		}
}
