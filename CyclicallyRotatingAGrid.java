import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int[][] rotateGrid(int[][] grid, int k) {
		int m = grid.length;;
		int n = grid[0].length;
		int x=0,y=0;
		while(m>0 && n>0){
			int[] array = createArray(grid,x,y,m,n);
			int temp = k%(2*(m+n-2));
			int[] rotateArray = rotate(array,temp);
			putInTheGrid(grid,x,y,m,n,rotateArray);


			m-=2;
			n-=2;
			x+=1;y+=1;
		}
		return grid;

	}
	public void putInTheGrid(int[][] grid,int x,int y,int m,int n,int[] arr){
		int len = 2 * (m + n - 2);
		int count = 0, startx= x, starty = y;
		for(;x<startx+m;x++){
			grid[x][y] = arr[count++];
		}
		x--;
		y++;
		for(;y<starty+n;y++){
			grid[x][y] = arr[count++];
		}
		y--;
		x--;
		for(;x>=startx;x--){
			grid[x][y] = arr[count++];
		}
		x++;
		y--;
		for(;y>starty;y--){
			grid[x][y] = arr[count++];
		}

	}
	public int[] rotate(int[] arr, int k){
		if(k<0)return arr;
		Queue<Integer> elements = new LinkedList<>();

		for(int i = arr.length - k;i<arr.length;i++){
			elements.add(arr[i]);
		}
		for(int i=arr.length - k -1;i>=0;i--){
			arr[i+k] = arr[i];
		}
		for(int i=0;i<=k-1;i++){
			arr[i] = elements.poll();
		}

		return arr;
	}
	public int[] createArray(int[][] grid,int x,int y,int m,int n){
		int len = 2 * (m + n - 2);
		int arr[] = new int[len];
		int count = 0, startx= x, starty = y;
		for(;x<startx+m;x++){
			arr[count++] = grid[x][y];
		}
		x--;
		y++;
		for(;y<starty+n;y++){
			arr[count++] = grid[x][y];
		}
		y--;
		x--;
		for(;x>=startx;x--){
			arr[count++] = grid[x][y];
		}
		x++;
		y--;
		for(;y>starty;y--){
			arr[count++] = grid[x][y];
		}
		return arr;
	}

}