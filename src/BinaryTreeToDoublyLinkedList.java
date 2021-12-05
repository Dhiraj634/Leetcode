

public class BinaryTreeToDoublyLinkedList {
	//Function to convert binary tree to doubly linked list and return it.
	Node ans = new Node(-1);
	Node bToDLL(Node root)
	{

		inOrderTraversal(root);
		while(ans.left!=null){
			ans = ans.left;
		}
		ans = ans.right;
		ans.left = null;
		return ans;
	}

	private Node inOrderTraversal(Node root){
		if(root == null)
			return ans;
		Node currNode = new Node(root.data);
		inOrderTraversal(root.left);
		ans.right = currNode;
		currNode.left = ans;
		ans = ans.right;
		inOrderTraversal(root.right);
		return ans;

	}
}

class Node {
	int data;
	Node left,right;
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
