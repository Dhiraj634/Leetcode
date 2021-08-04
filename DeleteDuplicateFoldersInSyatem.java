import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


class Solution {
	public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
		Node root = new Node("/");
		for(List<String> str:paths){
			this.createStructure(root, str);
		}
		HashMap<String, Boolean> duplicateStructure = new HashMap<>();
		this.searchDuplicateStructure(root,duplicateStructure);
		removeDuplicates(root,duplicateStructure);
		List<List<String>> ans = new ArrayList<>();
		getAnswer(root, new LinkedList<>(), ans);
		return ans;
	}
	void getAnswer(Node node, LinkedList<String> res, List<List<String>> ans) {
		for (Node val : node.next.values()) {
			if (val != null) {
				res.add(val.val + "");
				ans.add(new ArrayList<>(res));
				getAnswer(val, res, ans);
				res.removeLast();
			}
		}
	}
	private void removeDuplicates(Node root, HashMap<String, Boolean> duplicateStructure){
		for (HashMap.Entry<String,Node> val : root.next.entrySet() ) {
			if (val.getValue().dirStructure != null && duplicateStructure.get(val.getValue().dirStructure)) {
				root.next.put(val.getKey(), null);
			}
			if (root.next.get(val.getKey()) != null) {
				removeDuplicates(root.next.get(val.getKey()), duplicateStructure);
			}
		}
	}
	private String searchDuplicateStructure(Node root, HashMap<String, Boolean> duplicateStructure){

		List<Node> children = new ArrayList<>();
		for(Node node: root.next.values()){
			children.add(node);
		}
		Collections.sort(children, Comparator.comparing(a -> a.val));
		ArrayList<String> str = new ArrayList<>();
		for(Node node: children){
			String subStructure = searchDuplicateStructure(node, duplicateStructure);
			if(subStructure.length() > 0 && duplicateStructure.containsKey(subStructure)){
				duplicateStructure.put(subStructure, true);
			}else{
				duplicateStructure.put(subStructure, false);
			}
			str.add(subStructure + node.val);
		}
		root.dirStructure = str.stream().collect(Collectors.joining("-"));
		return root.dirStructure;
	}
	private void createStructure(Node root, List<String> str){
		for(String st:str){
			if(!root.next.containsKey(st)){
				root.next.put(st, new Node(st));
			}
			root = root.next.get(st);
		}
	}
	class Node{
		String val;
		HashMap<String, Node> next;
		String dirStructure;

		public Node(String val){
			this.val = val;
			this.next = new HashMap<>();
			this.dirStructure = null;
		}
	}
}