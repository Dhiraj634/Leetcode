class Solution {
	int currentArea;
	int maxArea;
	public int largestIsland(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		this.maxArea = -1;
		int visited[][] = new int[row][col];
		int parent = 1;
		int[] parentValue = new int[250001];

		// DFS the grid and set all the cell that are reachable the same parent and count how many cells are reachable
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j] == 1 && visited[i][j] == 0){
					this.currentArea = 0;
					dfs(grid, i,j, visited, parent);
					parentValue[parent] = this.currentArea;
					this.maxArea = Math.max(this.currentArea, this.maxArea);
					parent++;

				}
			}
		}

		//Go through the grid and for each call that has value zero we chaeck is we change that waht is the maximum value we will get
		for(int k=0;k<row;k++){
			for(int j=0;j<col;j++){
				if(grid[k][j] == 0){
					int []x = new int[]{1,-1,0,0};
					int []y = new int[]{0,0,1,-1};
					int count = 0;
					int temp[] = new int[4];

					//Storing the parent value as it will be modified while adding unique parent's value only
					for(int i = 0;i<4;i++){
						int tempX = k + x[i];
						int tempy = j + y[i];
						if(tempX >= 0 && tempX < grid.length && tempy >= 0 && tempy < grid[0].length){
							temp[i] = parentValue[grid[tempX][tempy]];
						}
					}
					for(int i = 0;i<4;i++){
						int tempX = k + x[i];
						int tempy = j + y[i];
						if(tempX >= 0 && tempX < grid.length && tempy >= 0 && tempy < grid[0].length){
							if(grid[tempX][tempy]!=0){
								count+=parentValue[grid[tempX][tempy]];
								parentValue[grid[tempX][tempy]] = 0;
							}
						}
					}

					// putting back the values of the parent which we have stored in the temp array
					for(int i = 0;i<4;i++){
						int tempX = k + x[i];
						int tempy = j + y[i];
						if(tempX >= 0 && tempX < grid.length && tempy >= 0 && tempy < grid[0].length){
							parentValue[grid[tempX][tempy]] = temp[i];
						}
					}
					this.maxArea = Math.max(this.maxArea, count+1); // count+1 for converting 0 to 1
				}
			}
		}
		return this.maxArea;


	}
	private void dfs(int[][] grid, int x, int y, int[][] visited, int parent){
		if(x< 0 || y<0 || x >= grid.length || y>= grid[0].length){
			return ;
		}
		this.currentArea++;
		visited[x][y] = 1;
		int []x1 = new int[]{1,-1,0,0};
		int []y1 = new int[]{0,0,1,-1};
		for(int i = 0;i<4;i++){
			if(x+x1[i] >= 0 && x+x1[i] < grid.length && y+y1[i] >= 0 && y+y1[i] < grid[0].length && grid[x+x1[i]][y+y1[i]] ==1 && visited[x+x1[i]][y+y1[i]] == 0){
				dfs(grid,x+x1[i],y+y1[i],visited, parent);
			}
		}
		grid[x][y] = parent;
		return;
	}
}