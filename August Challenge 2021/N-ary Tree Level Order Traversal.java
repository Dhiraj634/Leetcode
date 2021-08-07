/**
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public List<Node> children;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, List<Node> _children) {
 *         val = _val;
 *         children = _children;
 *     }
 * };
 * */

class Solution {
	public List<List<Integer>> levelOrder(Node root) {

		List<List<Integer>> answer = new ArrayList<>();
		if(root == null)return answer;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		// Here count maintains the number of nodes in each level
		int count = q.size();
		while(!q.isEmpty()){
			int temp = count;
			count=0;
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0;i<temp;i++){
				Node n1 = q.poll();
				count += n1.children.size();
				q.addAll(n1.children);
				arr.add(n1.val);
			}
			answer.add(arr);
		}
		return answer;
	}
}