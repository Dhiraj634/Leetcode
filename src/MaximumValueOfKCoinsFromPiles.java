package src;

import java.util.List;

public class MaximumValueOfKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for (List<Integer> pile : piles) {
            for (int j = 1; j < pile.size(); j++) {
                pile.set(j, pile.get(j - 1) + pile.get(j));
            }
        }
        int n = piles.size();
        int[][] dp = new int[k+1][n];

        for(int i = 0;i<=k;i++){
            int len = piles.get(n-1).size();
            if(i == 0)dp[i][n-1] = 0;
            else if(i > piles.get(n-1).size()) {
                dp[i][n-1] = Integer.MIN_VALUE;
            }
            else{
                dp[i][n-1] = piles.get(n-1).get(i-1);
            }
        }

        for(int i=n-2;i>=0;i--){
            int len = piles.get(i).size();
            for(int coinsToSelect=0;coinsToSelect<=k;coinsToSelect++){
                for(int selectedCoins = 0; selectedCoins<=Math.min(coinsToSelect,len);selectedCoins++){
                    if( selectedCoins == 0){
                        dp[coinsToSelect][i] = dp[coinsToSelect][i+1];
                    }else{
                        dp[coinsToSelect][i] = Math.max(dp[coinsToSelect][i],piles.get(i).get(selectedCoins-1) + dp[coinsToSelect-selectedCoins][i+1]);
                    }
                }
            }
        }
        return dp[k][0];
    }
}
