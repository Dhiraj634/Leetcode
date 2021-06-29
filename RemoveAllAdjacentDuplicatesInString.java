import java.util.Stack;

class Solution {
	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++){
			if(stack.isEmpty()){
				stack.push(s.charAt(i));
				continue;
			}
			char temp = stack.peek();
			if(temp == s.charAt(i)){
				stack.pop();
			}else{
				stack.push(s.charAt(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		stack.forEach(a->sb.append(a));
		return sb.toString();
	}
}