import java.util.Arrays;

class Solution {
	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		int N = (int)Math.pow(10,8);
		int len = obstacles.length;
		int[] dp = new int[len+1];
		int answer[] = new int[len];
		Arrays.fill(dp, N);
		dp[0] = -N;
		int m = 0;
		for(int num:obstacles){
			int index = UpperBound(dp, num);
			answer[m++] = index;
			if(dp[index] > num){
				dp[index] = num;
			}
		}
		return answer;
	}
	int UpperBound(int[] arr, int X) {
		int mid;
		int N = arr.length;

		int low = 1;
		int high = N;

		while (low < high) {

			mid = low + (high - low) / 2;
			if (X >= arr[mid]) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		if(low < N && arr[low] <= X) {
			low++;
		}

		return low;
	}
}