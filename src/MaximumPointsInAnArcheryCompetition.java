public class MaximumPointsInAnArcheryCompetition {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int N = (1 << 12)-1;
        int maxPoint  =-1;
        int mask = 0;
        for(int i=1;i<=N;i++){
            if(isMaskPossible(numArrows, aliceArrows,i)){
                int point = calculatePoint(i);
                if(point > maxPoint){
                    mask = i;
                    maxPoint = point;
                }
            }
        }
        int[] bobArrows = new int[12];
        int score = 11;
        int sum = 0;
        while(mask > 0){
            if((mask & 1) == 1){
                bobArrows[score]=aliceArrows[score]+1;
                sum+=bobArrows[score];
            }
            score--;
            mask>>=1;
        }
        bobArrows[0] = numArrows - sum;
        return bobArrows;
    }
    public int calculatePoint(int num){
        int score = 11;
        int point = 0;
        while(num > 0){
            point+= (score * (num & 1));
            score--;
            num>>=1;
        }
        return point;
    }
    public boolean isMaskPossible(int numArrows, int[] aliceArrows,  int mask){
        int score = 11;
        int arrowsUsed = 0;
        while(mask>0){
            if((mask & 1) == 1){
                arrowsUsed+=aliceArrows[score]+1;
            }
            mask>>=1;
            score--;
        }
        return arrowsUsed <= numArrows;
    }
}
