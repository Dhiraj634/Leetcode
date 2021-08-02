class Solution {
	public long numberOfWeeks(int[] milestones) {
		int i,j,max=-1,n=milestones.length;
		long sum=0;
		for(i=0;i<n;i++)
		{
			max=Math.max(max, milestones[i]);
			sum+=milestones[i];
		}
		long remainingSum=sum-max;

		if(remainingSum<=max - 1)
			return 2 * remainingSum + 1;
		return sum;
	}
}

/**
 * Another Approach
 * import java.util.stream.IntStream;
 *
 * class Solution {
 * 	public long numberOfWeeks(int[] milestones) {
 * 		// Based on the concept of filling up the gaps
 * 		long sum = IntStream.of(milestones).mapToLong(i -> i).sum();
 * 		long max = IntStream.of(milestones).mapToLong(i->i).max().getAsLong();
 * 		long remainingSum=sum-max;
 * 		if(remainingSum<=max - 1)
 * 			return 2 * remainingSum + 1;
 * 		return sum;
 *
 *        }
 * }
 *
 * */