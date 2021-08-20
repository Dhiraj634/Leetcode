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
	int minDiff = (int)Math.pow(10,9);
	int minValue = (int)Math.pow(10,9);
	public int maxProduct(TreeNode root) {
		int totalSum = dfs(root);
		// System.out.println("TotalSum = " + totalSum);
		calculate(root, totalSum);
		int N = (int)Math.pow(10,9) + 7;
		long otherHalf = totalSum - minValue;
		long ans = ((minValue % N) * (otherHalf % N)) % N;
		return (int)ans;


	}
	private int dfs(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		root.val += (left + right);
		return root.val;
	}
	private void calculate(TreeNode root, int totalSum){
		if(root == null){
			return;
		}
		calculate(root.left, totalSum);
		calculate(root.right, totalSum);
		if(root.left != null){
			int firstHalf = root.left.val;
			int otherHalf = totalSum - firstHalf;
			int diff = Math.abs(firstHalf - otherHalf);
			if(diff < this.minDiff)
			{
				this.minValue = root.left.val;
				this.minDiff = diff;

			}

		}
		// System.out.println(String.format("root = %d maxDiff = %d minValue = %d", root.val,this.minDiff,this.minValue));
		if(root.right != null){
			int firstHalf = root.right.val;
			int otherHalf = totalSum - firstHalf;
			int diff = Math.abs(firstHalf - otherHalf);
			if(diff < this.minDiff)
			{
				this.minValue = root.right.val;
				this.minDiff = diff;

			}

		}
		// System.out.println(String.format("root = %d maxDiff = %d minValue = %d", root.val,this.minDiff,this.minValue));
	}
}