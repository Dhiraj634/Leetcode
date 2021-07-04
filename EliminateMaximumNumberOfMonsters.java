import java.util.Arrays;

class Solution {
	public int eliminateMaximum(int[] dist, int[] speed) {
		int len = dist.length;
		double[] d = new double[len];
		for(int i=0;i<len;i++){
			double time = dist[i]* 1.0/speed[i];
			d[i] = time;
		}
		Arrays.sort(d);
		int count = 0;
		int time=0;
		for(double temp : d){
			if(temp > time){
				count++;
			}else{
				break;
			}
			time++;
		}
		return count;
	}
}
//class Solution {
//	public int eliminateMaximum(int[] dist, int[] speed) {
//		int len = dist.length;
//		double[] d = new double[len];
//		for(int i=0;i<len;i++){
//			double time = dist[i]* 1.0/speed[i];
//			d[i] = time;
//		}
//		Arrays.sort(d);
//		int count = 0;
//		int time=0;
//		for(double temp : d){
//			if(temp > time){
//				count++;
//			}else{
//				break;
//			}
//			time++;
//		}
//		return count;
//	}
//}