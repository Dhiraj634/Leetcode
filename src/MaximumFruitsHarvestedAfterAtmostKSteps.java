import java.util.ArrayList;

public class MaximumFruitsHarvestedAfterAtmostKSteps {
	public int maxTotalFruits(int[][] fruits, int startPos, int k) {
		int start = startPos-k;
		int end = startPos+k;
		ArrayList<Integer> fruitArray = new ArrayList<>(end - start + 1);
		for(int i=0;i<(end -start + 1);i++){
			fruitArray.add(0);
		}
		for(int[] arr: fruits){

			if(arr[0]>=start && arr[0]<=end){
				int insert = arr[0] - start;
				fruitArray.set(insert,arr[1]);
			}
		}
		int[] arr = fruitArray.stream().mapToInt(Integer::intValue).toArray();
		int[] cummArray=new int[arr.length];
		cummArray[0]=arr[0];
		for(int i=1;i<arr.length;i++){
			cummArray[i] = cummArray[i-1] + arr[i];
		}
		int max = -1;
		int mid = arr.length/2;
		for(int i=0;mid-i>=0;i++){
			int tempEnd = cummArray[mid+k-i*2];
			int tempStart = mid-i-1 < 0 ? 0 : cummArray[mid-i-1];
			max=Math.max(max,tempEnd-tempStart);
		}

		for(int i=0;mid+i<arr.length;i+=1){
			int tempEnd = cummArray[mid+i];
			int tempStart = mid-(k - i*2)-1 < 0 ? 0 : cummArray[mid- (k - i*2) -1];
			max=Math.max(max,tempEnd-tempStart);
		}
		return max;

	}
}
