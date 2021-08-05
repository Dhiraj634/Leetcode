/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayDeque;
class Solution {
	List<List<Integer>> list = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		ArrayDeque<Integer> deque =  new ArrayDeque<>();
		getThePaths(root, targetSum, deque, 0);
		return this.list;

	}

	private void getThePaths(TreeNode root, int targetSum, ArrayDeque<Integer> deque, int sumSoFar){
		if(root == null)
		{
			return;
		}
		if(root.left == null && root.right == null){
			sumSoFar+=root.val;
			if(sumSoFar == targetSum){
				List<Integer> temp = new ArrayList<>();
				int len = deque.size();
				for(int i=0;i<len;i++){
					int num = deque.pollFirst();
					temp.add(num);
					deque.addLast(num);
				}
				temp.add(root.val);
				this.list.add(temp);
			}
			return;
		}
		deque.addLast(root.val);
		getThePaths(root.left,targetSum,deque, sumSoFar + root.val);
		getThePaths(root.right,targetSum,deque, sumSoFar + root.val);
		deque.pollLast();
		return;
	}
}