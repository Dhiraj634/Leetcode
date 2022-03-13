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
            return Arrays.stream(nums).max().getAsInt();
        }else if(k < n){
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
            for(int i=0;i<k-1;i++){
                pq.add(nums[i]);
            }
            int max = pq.size() ==0 ? -1 : pq.peek();
            max = Math.max(max, nums[k]);
            return max;

        }else{
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
            for(int i=0;i<k-1;i++){
                pq.add(nums[i]);
            }
            return pq.peek();
        }
    }
}
