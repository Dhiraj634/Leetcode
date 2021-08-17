import java.util.HashMap;

class Solution {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> tMap = new HashMap<>();
		HashMap<Character, Integer> sMap = new HashMap<>();
		for(char ch: t.toCharArray()){
			tMap.put(ch, tMap.getOrDefault(ch,0) + 1);
		}
		int start = -1, end = -1, ansStart = -1, ansEnd = -1 , len = 1000000;
		int count = t.length();
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(count!=0 && tMap.containsKey(ch)){
				if(sMap.containsKey(ch)  ){
					if(sMap.get(ch) < tMap.get(ch)){
						if(start == -1 )start = i;
						count--;
					}
					sMap.put(ch, sMap.get(ch)+1);
				}else{
					if(start == -1 )start = i;
					sMap.put(ch,1);
					count--;
				}
			}

			if(count == 0){
				end = i;
				while(count == 0){
					int tempLen = end - start + 1;
					if(tempLen < len){
						ansStart = start;
						ansEnd = end;
						len = tempLen;
					}
					char ch1 = s.charAt(start);
					if(tMap.containsKey(ch1)){
						sMap.put(ch1, sMap.get(ch1) - 1);
						if(sMap.get(ch1) < tMap.get(ch1)){
							count++;
						}
					}
					start++;
				}
			}

		}

		return (ansStart >= 0 && ansEnd >= ansStart) ?  s.substring(ansStart, ansEnd + 1) : "";
	}
}