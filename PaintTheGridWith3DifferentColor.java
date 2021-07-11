import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	ArrayList<String> allString = new ArrayList<>();
	int[][] dp;
	int N = (int)Math.pow(10,9)+7;
	public int colorTheGrid(int m, int n) {

		//Generating all the possible string
		this.generateAllPossibleString(m,'$',"");
		dp = new int[this.allString.size()][n];
		for(int[] arr:dp)
		{
			Arrays.fill(arr,-1);
		}
		ArrayList<Integer>[] graph = new ArrayList[this.allString.size()];
		for(int i=0;i<this.allString.size();i++){
			graph[i] = new ArrayList<>();
		}

		//for each string we are storing in the graph , what other string we can put in adjacent to it
		for(int i = 0;i<this.allString.size();i++){
			for(int j=0;j<this.allString.size();j++){
				boolean flag = true;
				for(int k =0 ;k<m;k++){
					if(this.allString.get(i).charAt(k) == this.allString.get(j).charAt(k)){
						flag =false;
						break;
					}
				}
				if(flag && i!=j){
					graph[i].add(j);
				}
			}
		}

		//Collecting the answer by traversing the graph
		long ans = 0;
		for(int i=0;i<this.allString.size();i++)
			ans = (ans % this.N + getTheAnswer(graph,i,n-1)% this.N)%this.N;
		return (int)ans;

	}
	private void generateAllPossibleString(int m, char prev, String sb){
		if(m==0){
			this.allString.add(sb);
			return;
		}
		char colors[] = new char[]{'R','G','B'};
		for(char ch:colors){
			if(ch != prev){
				generateAllPossibleString(m-1,ch, sb+ch);
			}
		}
	}
	private long getTheAnswer(ArrayList<Integer>[] graph, int i,int col){
		if(col==0)
			return 1;
		if(dp[i][col]!=-1)return dp[i][col];
		long ans = 0;
		for(int temp:graph[i]){
			ans = (ans % this.N + getTheAnswer(graph,temp,col-1)% this.N)%this.N;
		}
		dp[i][col] = (int)ans;
		return dp[i][col];
	}
}