package usefulFunctions;

public class BinarySearch {
	// Give you the count of how many are less than equal to the key
	public static int upper_bound(int[] arr, int key){
		int start = 0, end = arr.length-1;
		while(start<=end){
			int mid = (start + end) / 2;
			if(key >= arr[mid]){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		return end+1;
	}
	//Gives you the count of how many are greater than equal to the key
	public static int lower_bound(int[] arr, int key){
		int start = 0, end = arr.length-1;
		while(start<=end){
			int mid = (start + end) / 2;
			if(key > arr[mid]){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		return arr.length - (end+1);
	}

	// Gives the count of the elements strictly less than the key
	public static int strictly_less(int[] arr, int key){
		return arr.length - lower_bound(arr,key);
	}

	// Gives the count of the elements strictly greater than the key
	public static int strictly_greater(int[] arr, int key){
		return arr.length - upper_bound(arr,key);
	}
}
