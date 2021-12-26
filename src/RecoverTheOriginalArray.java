import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecoverTheOriginalArray {
		public int[] recoverArray(int[] nums) {
			Arrays.sort(nums);
			ArrayList<Integer> diff = new ArrayList<>();
			for(int num: nums){
				int temp  = num - nums[0];
				if(temp >0 && temp%2==0) diff.add(temp);
			}
			for(int num: diff){
				ArrayList<Integer> arr = checkDiff(nums, num);
				if(arr.size()==nums.length/2){
					return arr.stream().mapToInt(Integer::intValue).toArray();
				}
			}
			return new int[]{};

		}
		private ArrayList<Integer> checkDiff(int[] nums, int diff){
			Map<Integer, Integer> fre = new HashMap<>();
			for(int num:nums){
				fre.put(num, fre.getOrDefault(num,0)+1);
			}
			ArrayList<Integer> ans = new ArrayList<>();
			for(int num:nums){
				if(fre.get(num) > 0 && fre.containsKey(num+diff) && fre.get(num+diff) > 0){
					ans.add(num + diff / 2);
					fre.put(num, fre.get(num)-1);
					fre.put(num+diff, fre.get(num+diff)-1);
				}
			}
			return ans;
		}
}
