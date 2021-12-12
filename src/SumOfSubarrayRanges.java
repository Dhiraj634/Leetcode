class SumOfSubarrayRanges {
	public long subArrayRanges(int[] nums) {
		int n = nums.length;
		long sum = 0;
		for(int i=0;i<n;i++){
			int min = nums[i];
			int max = nums[i];
			for(int j = i+1;j<n;j++){
				min = Math.min(min, nums[j]);
				max = Math.max(max, nums[j]);
				sum = sum + (max - min);
			}
		}
		return sum;
	}
}