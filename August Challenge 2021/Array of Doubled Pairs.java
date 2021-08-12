import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public boolean canReorderDoubled(int[] arr) {
		ArrayList<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
		Map<Integer, Integer> map = new HashMap<>();
		for(int num:arr){
			map.put(num, map.getOrDefault(num,0) + 1);
		}
		Collections.sort(list, Comparator.comparingInt(Math::abs));

		for(Integer num:list){
			if(map.get(num) <= 0)continue;
			int doubleNum = 2 * num;
			if(map.getOrDefault(doubleNum,0)<=0)return false;
			map.put(num, map.get(num)-1);
			map.put(doubleNum, map.get(doubleNum)-1);
		}
		return true;
	}
}