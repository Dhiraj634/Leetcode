class Solution
{
	//Function to return list containing vertices in Topological order.
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
	{
		// add your code here
		int[] visited = new int[V];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<V;i++){
			if(visited[i] == 1) continue;
			dfs(i,adj,stack, visited);

		}
// 		System.out.println(stack.size());
		int[] ans = new int[stack.size()];
		int m=0;
		while(!stack.isEmpty()){
			ans[m++] = stack.pop();
		}
		return ans;
	}
	private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, int[] visited){
		if(visited[node] == 1) return;
		visited[node] =  1;
		for(int childNode: adj.get(node)){
			dfs(childNode, adj, stack, visited);
		}
		stack.push(node);
	}
}