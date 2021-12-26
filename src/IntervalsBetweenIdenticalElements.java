import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IntervalsBetweenIdenticalElements {
	public long[] getDistances(int[] arr) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int i=0;
		for(int num: arr){
			map.putIfAbsent(num, new ArrayList<>());
			map.get(num).add(i);
			i++;
		}
		Map<Integer, Queue<Long>> ansMap = new HashMap<>();
		for(int num: map.keySet()){
			ansMap.put(num,getDistance(map.get(num)));
		}
		long[] ans = new long[arr.length];
		for(i=0;i<arr.length;i++){
			ans[i] = ansMap.get(arr[i]).poll();
		}
		return ans;
	}
	private Queue<Long> getDistance(ArrayList<Integer> arr){
		Queue<Long> queue = new LinkedList<>();
		if(arr.size() == 1){
			queue.add(0L);
			return queue;
		}
		long[] forward = new long[arr.size()];
		long[] backWard = new long[arr.size()];
		for(int i=1;i<arr.size();i++){
			int len = arr.get(i) - arr.get(i-1);
			forward[i] = (long) len *(i) + forward[i-1];
		}
		for(int i=arr.size()-2;i>=0;i--){
			int len = arr.get(i+1) - arr.get(i);
			backWard[i] = (long) len * (arr.size()-1-i) + backWard[i+1];
		}
		for(int i=0;i<arr.size();i++){
			queue.add(forward[i]+backWard[i]);
		}

		return queue;
	}
}
