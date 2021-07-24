class Solution {
	public int maxArea(int[] height) {
		int len = height.length;
		int left = 0;
		int right = len - 1;
		int maxWater = -1;
		while(left < right){
			int minHeight = Math.min(height[left], height[right]);
			maxWater = Math.max(maxWater, minHeight * (right - left));
			if(height[left] < height[right]){
				left++;
			}
			else
				right--;
		}
		return maxWater;

	}
}