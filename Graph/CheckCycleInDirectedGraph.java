package Graph;

import java.util.ArrayList;

class CheckCycleInDirectedGraph {
	// Function to detect cycle in a directed graph.
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		// code here
		// System.err.println(adj);
		int[] visited = new int[V]; // to check what are all the nodes visited so that we do not repeat those again
		int[] recStack = new int[V]; // to track the node that are present in the current node traversal
		for(int i=0;i<V;i++){
			if(visited[i] == 1) continue;
			if(dfs(i,adj, visited, recStack)) return true;
		}
		return false;
	}
	private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] recStack){
		if(recStack[node] == 1) return true;
		if(visited[node]==1)return false;
		recStack[node]  =1;
		visited[node] = 1;
		for(int child: adj.get(node)){
			boolean tempResult = dfs(child, adj, visited, recStack);
			if(tempResult)return true;
		}
		recStack[node] = 0; // putting it zero to indicate that we are returning from this node and it is remove from recursion stack
		return false;
	}
}