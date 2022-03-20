import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeTopmostElementAfterKMoves {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(n == 1){
            if(k%2 ==0) return nums[0];
            else return -1;
        }
        if(k > n){
            int max = -1;
            for(int i=0;i<n;i++){
                max = Math.max(nums[i], max);
            }
            return max;
        }else if(k < n){
            int max = -1;
            for(int i=0;i<k-1;i++){
                max = Math.max(nums[i], max);
            }
            max = Math.max(max, nums[k]);
            return max;

        }else{
            int max = -1;
            for(int i=0;i<k-1;i++){
                max = Math.max(nums[i], max);
            }
            return max;
        }
    }
}
