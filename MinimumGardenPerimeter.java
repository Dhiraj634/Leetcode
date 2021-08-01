class Solution {
	public long minimumPerimeter(long n) {
		long sum = 0;
		long level = 0;
		for(;level <= 100000;level++){
			sum = 2 * level * (level+1) * (2* level + 1);
			if(sum >= n)
				break;
		}
		return 8 * level;
	}
}