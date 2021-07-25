class Solution {
	public String maximumNumber(String num, int[] change) {
		boolean start = false;
		StringBuilder sb = new StringBuilder();
		for(char ch: num.toCharArray()){
			int number = ch - '0';
			if(change[number] == number){
				sb.append(number);
			}
			else if(change[number] > number){
				sb.append(change[number]);
				start = true;
			}else{
				if(start == true)
					break;
				sb.append(number);
			}
		}
		int len = sb.length();
		if(len != num.length()){
			sb.append(num.substring(len));
		}
		return sb.toString();
	}
}