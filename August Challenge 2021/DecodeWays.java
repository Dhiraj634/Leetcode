class Solution {
	int[] dp ;
	public int numDecodings(String s) {
		dp = new int[s.length()+1];

		int len = s.length();
		dp[len] = 1;
		if(s.charAt(len-1)=='0')dp[len-1] = 0;
		else dp[len-1] = 1;
		for(int i=len-2;i>=0;i--){
			if(s.charAt(i) != '0'){
				int temp = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
				if(temp <=26){
					dp[i] =  dp[i+1]+dp[i+2];
				}else{
					dp[i] = dp[i+1];
				}
			}
		}
		return dp[0];

	}
}