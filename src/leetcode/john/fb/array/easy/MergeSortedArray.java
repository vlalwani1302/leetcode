package leetcode.john.fb.array.easy;

/* Q 88
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * Example:

 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 */

public class MergeSortedArray {
    
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        for(int i=nums1.length-1; i >=0; i--) {
        	if(index2 <0) {
        		return;
        	}
        	if(index1>=0 && nums1[index1] > nums2[index2]) {
        		nums1[i] = nums1[index1]; // if nums2 > nums1 enter nums2 at end
        		index1--;
        	}else {
        		nums1[i] = nums2[index2]; // if nums1 > nums2 enter nums1 at end
        		index2--;
        	}
        }
    }
    
    public static void main(String[] args) {
    	int[] nums1 = new int[] {1,2,3,0,0,0};
    	int[] nums2 = new int[] {2,5,6};
    	merge(nums1, 3, nums2, 3);
	}
}