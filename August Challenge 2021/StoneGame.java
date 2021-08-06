class Solution {
	public boolean stoneGame(int[] piles) {
		int len = piles.length;
		int totalSum = Arrays.stream(piles).sum();
		int arr[][] = new int[len][len];
		for(int i=0;i<len;i++){
			arr[i][i] = 1;
		}
		int x = 0, y = 1;
		while((x == 0 && y<= len-1)){
			int i = x, j = y;
			while(i<len && j < len){
				arr[i][j] = Math.max(piles[i] + arr[i+1][j],piles[j] + arr[i][j-1]);
				i++;
				j++;
			}
			y++;
		}
		int alexScore =  arr[0][len-1];
		int leeScore = totalSum - alexScore;
		return alexScore > leeScore;
	}
}
/**
 * Memoization
 *
 * class Solution {
 *     HashMap<String,Integer> map = new HashMap<>();
 *     public boolean stoneGame(int[] piles) {
 *         int len = piles.length;
 *         int aliceScore =  getTheAnswer(piles, 0,len-1);
 *         int totalSum = Arrays.stream(piles).sum();
 *         int bobScore = totalSum - aliceScore;
 *         if(aliceScore > bobScore)
 *             return true;
 *         return false;
 *     }
 *     private int getTheAnswer(int[] piles, int first, int last){
 *         if(first>last){
 *             return 0;
 *         }
 *         if(this.map.containsKey(first+"-"+last))
 *         {
 *             return this.map.get(first+"-"+last);
 *         }
 *         int case1 = piles[first] + getTheAnswer(piles,first+1, last);
 *         int case2 = piles[last] + getTheAnswer(piles,first, last-1);
 *         this.map.put(first+"-"+last, Math.max(case1, case2));
 *         return  Math.max(case1, case2);
 *     }
 * }
 * */