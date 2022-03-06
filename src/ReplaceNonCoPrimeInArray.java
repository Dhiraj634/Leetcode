import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReplaceNonCoPrimeInArray {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for(int i=1;i<nums.length;i++){
            long lcm = nums[i];
            while(stack.size() > 0){
                int top = stack.peek();
                int gcd = getGCD(top,(int)lcm);
                if(gcd != 1) {
                    stack.pop();
                    lcm = (top * lcm) / gcd;
                }else{
                    break;
                }

            }
            stack.push((int)lcm);

        }
        List<Integer> ans = new ArrayList<>();
        for(int arr: stack){
            ans.add(arr);
        }
        return ans;

    }
    private int getGCD(int a, int b){
        if(a==0)return b;
        return getGCD(b%a,a);
    }
}
