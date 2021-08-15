class Solution {
	public int minNonZeroProduct(int p) {
		long N = (long)Math.pow(10,9) + 7;
		long max = (long)Math.pow(2,p) - 1;
		long power = pow(max -1 , (max -1)/2);
		power = ((power %N) * ( max%N)) %N;
		return (int)power;
	}
	private long pow(long num,long p){
		if(p == 0)
			return 1l;

		long N = (long)Math.pow(10,9) + 7;
		long temp = pow(num, p/2);
		temp = temp % N;
		if(p%2 == 0){
			return (temp * temp)%N;
		}else{
			return (((temp * temp)%N) * (num%N))%N;
		}
	}
}