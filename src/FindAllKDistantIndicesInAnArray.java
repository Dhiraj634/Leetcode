import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int[] fre = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(nums[i] == key){
                int left = Math.max(0,i-k);
                int right = Math.min(nums.length, i+k+1);
                fre[left]++;
                fre[right]--;
            }
        }
        int cumm = 0;
        for(int i=0;i<nums.length;i++){
            cumm+=fre[i];
            if(cumm > 0)ans.add(i);
        }
        return ans;
    }
}
