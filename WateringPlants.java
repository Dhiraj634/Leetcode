class Solution {
	public int wateringPlants(int[] plants, int capacity) {
		int len = plants.length;
		int water = 0;
		int i = 0;
		int steps = 0;
		while(i<len){

			if(water+plants[i] <=capacity){
				steps++;
				water+=plants[i];
				i++;
			}
			else{
				/**
				 * Going back to the river and coming back to the same position hence twice the step
				 * */
				steps+= 2*i;
				water = 0;
			}
		}
		return steps;
	}
}