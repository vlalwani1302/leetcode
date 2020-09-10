package leetcode.alice.array;

public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
		boolean found = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				found = true;
				return i;
			}
		}
		if (!found)
			return -1;
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(arr, 0));
		System.out.println(searchBS(new int[] {1,3}, 1));
		System.out.println(searchBS(new int[] {5,1,3}, 3));
		System.out.println(searchBS(new int[] {4,5,6,7,8,1,2,3}, 8));


	}

	public static int searchBS(int[] nums, int target) {
        int n = nums.length;
       int pivot = findPivot(nums, 0, n - 1); 
  
        // If we didn't find a pivot, then 
        // array is not rotated at all 
        if (pivot == -1) 
            return binarySearch(nums, 0, n - 1, target); 
  
        // If we found a pivot, then first 
        // compare with pivot and then 
        // search in two subarrays around pivot 
        if (nums[pivot] == target) 
            return pivot; 
        if (nums[0] <= target) 
            return binarySearch(nums, 0, pivot - 1, target); 
        return binarySearch(nums, pivot + 1, n - 1, target); 
    }
    
    public static int findPivot(int arr[], int low, int high) 
    { 
        // base cases 
        if (high < low) 
            return -1; 
        if (high == low) 
            return low; 
  
        /* low + (high - low)/2; */
        int mid = (low + high) / 2; 
        if (mid < high && arr[mid] > arr[mid + 1]) 
            return mid; 
        if (mid > low && arr[mid] < arr[mid - 1]) 
            return (mid - 1); 
        if (arr[low] >= arr[mid]) 
            return findPivot(arr, low, mid - 1); 
        return findPivot(arr, mid + 1, high); 
    } 
    
   static int binarySearch(int arr[], int low, int high, int key) 
    { 
        if (high < low) 
            return -1; 
  
        /* low + (high - low)/2; */
        int mid = (low + high) / 2; 
        if (key == arr[mid]) 
            return mid; 
        if (key > arr[mid]) 
            return binarySearch(arr, (mid + 1), high, key); 
        return binarySearch(arr, low, (mid - 1), key); 
    }
}
