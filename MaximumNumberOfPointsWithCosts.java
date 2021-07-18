import java.util.Arrays;

class Solution {
	public long maxPoints(int[][] points) {
		int col = points[0].length;
		int row = points.length;
		long[] prev = new long[col];
		int i = 0;
		for(int num:points[0])
			prev[i++] = num;

		for( i=1;i<row;i++){
			long[] temp = prev.clone();
			long leftMax = 0;
			for(int j = 0;j<col;j++){
				long max = Math.max(temp[j],leftMax - 1);
				long res = points[i][j] + max;
				leftMax = max;
				temp[j] = res;
			}
			long rightMax = 0;
			for(int j = col-1;j>=0;j--){
				long max = Math.max(prev[j],rightMax - 1);
				long res = points[i][j] + max;
				rightMax = max;
				prev[j] = Math.max(temp[j],res);
			}
		}
		long answer = Arrays.stream(prev).max().getAsLong();
		return answer;
	}
}