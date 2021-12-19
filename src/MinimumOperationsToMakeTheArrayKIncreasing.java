import java.util.ArrayList;
import java.util.Arrays;

public class MinimumOperationsToMakeTheArrayKIncreasing {
	public int kIncreasing(int[] arr, int k) {
		int ans = 0;
		for(int i=0;i<=k-1;i++){
			ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr[i]));
			int index = i+k;
			while(index < arr.length){
				list.add(arr[index]);
				index+=k;
			}
			ans+= this.calculateMin(list.stream().mapToInt(Integer::intValue).toArray());
		}
		return ans;
	}
	private int calculateMin(int[] arr){
		int len = this.lengthOfLIS(arr);
		return arr.length - len;
	}
	private int lengthOfLIS(int[] nums) {
		int N = 1000000;
		int len = nums.length;
		int[] dp = new int[len+1];
		Arrays.fill(dp, N);
		dp[0] = -N;
		for(int num:nums){
			int index = this.upper_bound(dp,num);
			if(dp[index] > num)
				dp[index]=num;
		}
		int lis = 0;
		for(int i=len;i>=0;i--){
			if(dp[i]!=N){
				lis = i;
				break;
			}
		}
		return lis;
	}
	private int upper_bound(int[] arr, int key){
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
}
