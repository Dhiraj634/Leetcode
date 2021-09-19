import java.util.ArrayList;
import java.util.HashMap;

class DetectSquares {

	class Pair {
		final int key;
		final int value;
		public Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	private final HashMap<Integer, ArrayList<Pair>> pairWithSameX;
	private final int[][] pairs ;
	public DetectSquares() {
		pairs = new int[1001][1001];
		pairWithSameX = new HashMap<>();
	}
	public void add(int[] point) {
		int x = point[0];
		int y = point[1];
		if(pairs[x][y]==0){
			Pair pair = new Pair(x,y);
			pairWithSameX.putIfAbsent(x, new ArrayList<>());
			pairWithSameX.get(x).add(pair);
		}
		pairs[x][y]++;
	}
	public int count(int[] point) {
		int x = point[0];
		int y = point[1];
		int count = 0;
		for (Pair pair : pairWithSameX.getOrDefault(x, new ArrayList<>())) {
			int tempX = pair.key;
			int tempY = pair.value;
			if (tempX == x && tempY == y) continue;
			int len = Math.abs(y - tempY);
			if(x+ len <=1000)count += pairs[x + len][y] * pairs[x + len][tempY] * pairs[x][tempY];
			if(x-len >= 0)count += pairs[x - len][y] * pairs[x - len][tempY] * pairs[x][tempY];

		}
		return count;
	}
}
