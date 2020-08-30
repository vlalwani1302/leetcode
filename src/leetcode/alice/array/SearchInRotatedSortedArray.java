package leetcode.alice.array;
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        boolean found = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                found = true;
                return i;
            }
        }
        if(!found)
            return -1;
        return -1;
    }
    
    public static void main(String[] args) {
    	int[] arr = new int[] {4,5,6,7,0,1,2};
    	System.out.println(search(arr, 0));
	}
}