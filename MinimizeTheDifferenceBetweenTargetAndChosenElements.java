class Solution {
	int visited[][] ;
	int minDiff = 10000;
	public int minimizeTheDifference(int[][] mat, int target) {
		int row = mat.length;
		int col = mat[0].length;
		visited = new int[row][5000];
		findTheDiff(mat,target,0,0);
		return this.minDiff;
	}
	private void findTheDiff(int[][] mat, int target, int sum,int row){
		if(row >= mat.length)
		{
			this.minDiff = Math.min(this.minDiff, Math.abs(target - sum));
			return ;
		}

		if(this.visited[row][sum] !=0) return;
		int col = mat[0].length;
		for(int i=0;i<col;i++){
			if(row+1<mat.length && this.visited[row+1][sum+mat[row][i]]!=0)continue; // This line can be omitted , it is present just for performance improvement
			findTheDiff(mat,target, sum+mat[row][i],row+1);

		}
		this.visited[row][sum] = 1;
	}
}