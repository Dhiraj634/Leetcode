import java.util.HashMap;
class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Queue<Integer>> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				map.get(nums[i]).add(i);
			}else{
				Queue<Integer> q = new LinkedList<>(Arrays.asList(i));
				map.put(nums[i],q);
			}
		}
		int index1 = -1 ,index2 = -1;
		for(int num:nums){
			index1++;
			index1 = map.get(num).poll();
			if(map.containsKey(target - num) && map.get(target-num).size() > 0){
				index2 = map.get(target - num).poll();
				break;
			}
		}

		return new int[]{index1, index2};
	}
}