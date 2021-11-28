class Solution {
	public int minimumDeletions(int[] nums) {
		int maxIndex = -1, minIndex = -1;
		int max = -1000000, min = 1000000;
		int len = nums.length;
		for(int i=0;i<len;i++){
			if(nums[i] > max){
				max= nums[i];
				maxIndex = i;
			}
			if(nums[i] < min){
				min = nums[i];
				minIndex = i;
			}
		}
		minIndex++;
		maxIndex++;
		int ans = 1000000;
		/**
		 * Below if else can be replace by this also
		 * ans= Math.min(ans,len - Math.min(maxIndex,minIndex) + 1);
		 * ans = Math.min(ans, Math.max(maxIndex,minIndex));
		 * ans = Math.min(ans, Math.min(maxIndex,minIndex) + len - Math.max(maxIndex,minIndex) + 1);
		 *
		 * */
		if(minIndex <= maxIndex){
			ans= Math.min(ans,len - minIndex + 1);
			ans = Math.min(ans, maxIndex);
			ans = Math.min(ans, minIndex + len - maxIndex + 1);
		}else{
			ans= Math.min(ans,len - maxIndex + 1);
			ans = Math.min(ans, minIndex);
			ans = Math.min(ans, maxIndex + len - minIndex + 1);
		}
		return ans;

	}
}