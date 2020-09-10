package leetcode.alice.array;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,4,6,8,9,11,12,15};
		System.out.println(findElementUsingBinarySearch(arr, 1));
	}

	private static boolean findElementUsingBinarySearch(int[] arr, int value) {

		if(arr.length == 0) {
			return false;
		}
		
		int low=0;
		int high=arr.length;

		return binarySearch(arr, value, low, high-1);
		
	}
	
	private static boolean binarySearch(int[] arr, int value, int low, int high) {
		if(high >= low) {
			int mid = (low + high)/2;
			if(mid >= arr.length || mid < 0) {
				return false;
			}
			if(arr[mid] == value)
				return true;
			
			if(value > arr[mid]) {
				//search in right array
				return binarySearch(arr, value, mid+1, high);
			}else {
				// search in left array
				return binarySearch(arr, value, low, mid-1);
			}
			
		}
		return false;
	}
}
