class WateringPlantsII {
	public int minimumRefill(int[] plants, int capacityA, int capacityB) {
		int left = 0, right = plants.length-1;
		int capA = capacityA, capB = capacityB;
		int refill = 0;
		while(left < right){
			if(capacityA < plants[left]){
				refill++;
				capacityA = capA;
			}
			if(capacityB < plants[right]){
				refill++;
				capacityB = capB;
			}
			capacityA -= plants[left];
			capacityB -= plants[right];
			left++;right--;
		}
		if(left == right){
			if(capacityA < plants[left] && capacityB < plants[left]){
				refill++;
			}
		}
		return refill;
	}
}