import java.util.Stack;

class Solution {
	public int minSwaps(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++){
			if(stack.isEmpty()){
				stack.push(s.charAt(i));
			}else{
				if(s.charAt(i) == ']'){
					if(stack.peek() == '[')
						stack.pop();
					else{
						stack.push(s.charAt(i));
					}

				}else{
					stack.push(s.charAt(i));
				}
			}
		}
		// Each time you remove 4 brackets if you swap once example : ]]][[[ -> []][[] -> ][
		int n = stack.size() / 4 + (stack.size()%4==0? 0:1);
		return n;
	}
}