package src;

import java.util.Stack;

public class MinimumDeletionToMakeArrayBeautiful {

    public int minDeletion(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int len = nums.length;
        int count = 0;
        for(int i=1;i<len;i++){
            if(count%2==0){
                if(nums[i] != stack.peek()){
                    stack.push(nums[i]);
                    count++;
                }
            }else{
                stack.push(nums[i]);
                count++;
            }
        }
        if(stack.size()%2 == 0){
            return len - stack.size();
        }else{
            return len - stack.size() + 1;
        }
    }
}
