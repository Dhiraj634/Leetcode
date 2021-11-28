class Solution {
	public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
		int cost = 0;
		/**
		 * For traversing the row
		 * */
		if(startPos[0] > homePos[0]){
			for(int i=homePos[0];i<startPos[0];i++){
				cost+=rowCosts[i];
			}
		}else if(startPos[0] < homePos[0]){
			for(int i=startPos[0]+1;i<=homePos[0];i++){
				cost+=rowCosts[i];
			}
		}
		/**
		 * For traversing the column
		 * */
		if(startPos[1] > homePos[1]){
			for(int i=homePos[1];i<startPos[1];i++){
				cost+=colCosts[i];
			}
		}else if(startPos[1] < homePos[1]){
			for(int i=startPos[1]+1;i<=homePos[1];i++){
				cost+=colCosts[i];
			}
		}
		/**
		 * Minimum cost
		 * */
		return cost;
	}
}