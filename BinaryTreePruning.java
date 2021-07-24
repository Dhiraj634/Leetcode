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
class Solution {
	public TreeNode pruneTree(TreeNode root) {
		boolean removeRoot = dfs(root);
		if(removeRoot)return null;
		return root;
	}
	private boolean dfs(TreeNode root){
		if(root == null)
			return false;
		if(root.left == null && root.right == null){
			if(root.val == 0)
				return true;
			else return false;
		}
		boolean left = dfs(root.left);
		boolean right = dfs(root.right);
		if(left){
			root.left = null;
		}
		if(right){
			root.right = null;
		}
		if(root.right == null && root.left == null && root.val == 0)
		{
			return true;
		}
		return false;

	}
}