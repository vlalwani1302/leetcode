package leetcode.alice.array;
class MoveZeroes {
	
	public static void main(String[] args) {
		moveZeroes(new int[] {4,2,4,0,0,3,0,5,1,0});
	}
    public static void moveZeroes(int[] nums) {
        
        int i=0; int j=i+1;
        
        while(i < nums.length && j < nums.length){
            
            if(nums[i] == 0){
                while(j < nums.length && nums[j] == 0){
                    j++;
                }
                
                if(j < nums.length){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }else {
            	i++;j++;
            }
        }
    }
}