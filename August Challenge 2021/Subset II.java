import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		// Get all the values including the duplicates
		List<List<Integer>> answer = getTheAnswer(nums, 0);

		//Removing the duplicates
		HashMap<String, List<Integer>> map= new HashMap<>();
		for(List<Integer> list : answer){
			String s = list.toString();
			if(!map.containsKey(s)){
				map.put(s, list);
			}
		}

		//Collecting the duplicates
		List<List<Integer>> subset = new ArrayList<>();
		for(List<Integer> list : map.values())
		{
			subset.add(list);
		}
		return subset;
	}
	private List<List<Integer>> getTheAnswer(int[] nums, int index){
		if(index == nums.length){
			List<List<Integer>> answer = new ArrayList<>();
			answer.add(new ArrayList<>());
			return answer;
		}
		List<List<Integer>> answer= getTheAnswer(nums, index + 1);
		List<List<Integer>> extendedList = new ArrayList<>();
		for(int i=0;i< answer.size();i++){
			List<Integer> temp = (List<Integer>) ((ArrayList<Integer>)answer.get(i)).clone();
			temp.add(nums[index]);
			Collections.sort(temp);
			extendedList.add(temp);
		}
		answer.addAll(extendedList);
		return answer;
	}
}