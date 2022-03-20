import java.util.Stack;

public class CountHillsAndValleysInArray {
    public int countHillValley(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int num : nums){
            while(stack.size() > 0 && stack.peek() == num)stack.pop();
            stack.push(num);
        }
        nums = stack.stream().mapToInt(Integer::intValue).toArray();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int left = i-1, right = i+1;

            if(left != -1 && right != nums.length){
                if(nums[left] > nums[i] && nums[right] > nums[i])count++;
                if(nums[left] < nums[i] && nums[right] < nums[i]) count++;
            }
        }
        return count;
    }
}
