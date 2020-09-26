package leetcode.john.fb.array.medium;

public class SubArraySumEqualsK {
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,1};
		System.out.println(subarraySum(arr,2));
	}
	
    public static int subarraySum(int[] nums, int k) {
    	int count = 0;
		int N = nums.length;
		for(int i=0; i < N; i++) {
			int currentSum = 0;
			for(int j=i; j<N; j++) {
				currentSum = currentSum + nums[j];
				if(currentSum == k) {
					count++;
				}
			}
		}
		return count;
    }
}