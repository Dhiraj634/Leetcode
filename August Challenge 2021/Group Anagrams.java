import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for(String str:strs){
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String temp = new String(chars);
			map.putIfAbsent(temp, new ArrayList<>());
			map.get(temp).add(str);
		}
		List<List<String>> answer = new ArrayList<>();
		for(List<String> str: map.values()){
			answer.add(str);
		}
		return answer;
	}
}