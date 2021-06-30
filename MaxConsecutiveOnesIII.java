public class MaxConsecutiveOnesIII {
	public int longestOnes(int[] nums, int k) {
		int left = 0, right = 0;
		int answer = 0;
		for(int num:nums){
			if(num == 0){
				k--;
			}
			while(k < 0){
				if(nums[left++] == 0){
					k++;
				}
			}
			answer = Math.max(answer, right - left + 1);
			right++;

		}
		return answer;
	}
}
