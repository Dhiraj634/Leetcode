class Solution {
	public long gridGame(int[][] grid) {
		int n = grid[0].length;
		long upper[] = new long[n+2];
		long lower[] = new long[n+2];
		for(int i=n;i>=1;i--){
			upper[i] = upper[i+1] + grid[0][i-1];
		}
		for(int i = 1 ;i<=n ; i++){
			lower[i] = lower[i-1] + grid[1][i-1];
		}
		long ans = (long)Math.pow(10,12);
		for(int i=1;i<=n;i++){
			ans = Math.min(Math.max(upper[i+1], lower[i-1]), ans);
		}
		return ans;
	}
}