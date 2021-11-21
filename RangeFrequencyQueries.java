import java.util.ArrayList;
import java.util.Collections;

class RangeFreqQuery {
	int N = 10001;
	// Map<Integer,List<Integer>> can also be used here
	ArrayList<Integer>[] ans = new ArrayList[N];
	public RangeFreqQuery(int[] arr) {
		int len = arr.length;
		for(int i=0;i<N;i++){
			ans[i] = new ArrayList<>();
		}
		/**
		 * Creating an array of indices where a particular number is repeated
		 * */
		for(int i=0;i<arr.length;i++){
			ans[arr[i]].add(i);
		}
	}

	public int query(int left, int right, int value) {
		/**
		 * Do a binary search to get the lower bound and upper bound and then subtract them to get the answer
		 * */
		int leftIndex = insertionToIndex(Collections.binarySearch(ans[value],left));
		int rightIndex = insertionToIndex(Collections.binarySearch(ans[value],right+1));
		System.out.println(rightIndex - leftIndex);
		return rightIndex - leftIndex;
	}

	private int insertionToIndex(int insertion){
		if(insertion >= 0) return insertion;
		else{
			return -1*insertion - 1;
		}
	}

}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */