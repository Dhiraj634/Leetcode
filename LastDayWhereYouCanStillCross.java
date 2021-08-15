class Solution {
	public int latestDayToCross(int row, int col, int[][] cells) {
		int[][] grid = new int[row][col];
		int[][] visited = new int[row][col];

		int l = 0, r = cells.length-1;
		int days = 0;
		while(l<=r){
			int mid = (l+r)/2;
			fillTheGrid(grid, cells, 0, mid);
			boolean isPossible = false;
			for(int i=0;i<col;i++){
				isPossible = isPossible || check(0,i,row,col,grid, visited);
				visited = new int[row][col];
				if(isPossible)break;
			}
			if(isPossible){
				days = Math.max(days, mid+1);
				l = mid+1;
			}else{
				unfillThegrid(grid,cells,0,mid);
				r = mid-1;
			}
		}
		return days;
	}

	private boolean check(int i, int j, int row, int col, int[][] grid, int[][] visited){
		if(i < 0 || i >= row || j<0 || j>=col || grid[i][j] == 1 || visited[i][j] == 1){
			return false;
		}
		if(i == row - 1){
			return true;
		}
		int[] x = new int[]{1,-1,0,0};
		int[] y = new int[]{0,0,1,-1};
		visited[i][j] = 1;
		boolean isPossible = false;
		for(int itr = 0;itr <4;itr++){
			int tempX = i + x[itr];
			int tempY = j + y[itr];
			if(!(tempX < 0 || tempX >= row || tempY<0 || tempY>=col)){
				isPossible = isPossible || check(tempX, tempY,row, col, grid, visited);
			}

			if(isPossible){
				return true;
			}
		}
		return false;


	}
	private void fillTheGrid(int[][] grid,int[][] cells, int start, int end){
		for(int i = start; i<=end;i++){
			grid[cells[i][0]-1][cells[i][1]-1] = 1;
		}
	}
	private void unfillThegrid(int[][] grid,int[][] cells, int start, int end){
		for(int i = start; i<=end;i++){
			grid[cells[i][0]-1][cells[i][1]-1] = 0;
		}
	}
}