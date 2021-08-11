class Solution {
	public int minFlipsMonoIncr(String s) {
		int len = s.length();
		int arr[][] = new int[2][len];
		if(s.charAt(len-1) == '1'){
			arr[0][len-1] = 1;
			arr[1][len-1] = 0;
		}else{
			arr[0][len-1] = 0;
			arr[1][len-1] = 1;
		}
		for(int i=len-2;i>=0;i--){
			if(s.charAt(i)=='1'){
				arr[0][i] = Math.min(arr[0][i+1],arr[1][i+1]) + 1;
				arr[1][i] = arr[1][i+1];
			}else{
				arr[1][i] = arr[1][i+1] + 1;
				arr[0][i] = Math.min(arr[0][i+1],arr[1][i+1]);
			}
		}

		return Math.min(arr[0][0], arr[1][0]);

	}
}