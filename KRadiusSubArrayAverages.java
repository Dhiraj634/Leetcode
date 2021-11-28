class Solution {
	/**
	 * Solving the question with segment tree approach
	 * */
	public int[] getAverages(int[] nums, int k) {
		int len = nums.length;
		long[] segTree = new long[4*len+1];
		createSegemntTree(segTree, nums,0,len-1,0);
		int[] ans = new int[len];
		for(int i=0;i<len;i++){
			int qs = Math.max((i - k), 0);
			int qe = Math.min((i + k), len - 1);
			if(qe - qs  < 2 * k ) {ans[i] = -1; continue;}
			long sum = getTheValue(segTree,qs,qe,0,len-1,0);
			ans[i] = (int)(sum / (qe-qs+1));
		}
		return ans;
	}
	private long createSegemntTree(long [] segTree, int[] nums,int start, int end, int treeIndex){
		if(start == end){
			segTree[treeIndex] = nums[start];
			return nums[start];
		}
		int mid = (start + end)/2;
		long left = createSegemntTree(segTree,nums,start, mid, treeIndex * 2 +1);
		long right = createSegemntTree(segTree,nums,mid+1, end, treeIndex * 2 +2);
		segTree[treeIndex] = left + right;
		return segTree[treeIndex];
	}

	private long getTheValue(long[] segTree, int qs, int qe, int numStart, int numEnd, int treeIndex){
		if(numStart >= qs && numEnd <=qe){
			return segTree[treeIndex];
		}
		if(numEnd<qs || numStart > qe){
			return 0;
		}
		int mid = (numStart + numEnd) / 2;

		return getTheValue(segTree,qs,qe,numStart,mid,treeIndex*2 +1) + getTheValue(segTree,qs,qe,mid+1,numEnd,treeIndex*2 + 2);
	}
}