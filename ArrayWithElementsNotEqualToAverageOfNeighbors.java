import java.util.ArrayList;
import java.util.Arrays;
class Solution {
	public int[] rearrangeArray(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int mid = len / 2;
		int i = 0,j=mid + 1;
		ArrayList<Integer> arr = new ArrayList<>();
		while(i<=mid && j < len){
			arr.add(nums[i++]);
			arr.add(nums[j++]);
		}
		while(i<=mid){
			arr.add(nums[i++]);
		}
		while(j<len){
			arr.add(nums[j++]);
		}
		nums = arr.stream().mapToInt(num->num).toArray();
		return nums;
	}
}