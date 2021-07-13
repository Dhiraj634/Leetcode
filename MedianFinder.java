import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

	/** initialize your data structure here. */
	PriorityQueue<Integer> maxPq;
	PriorityQueue<Integer> minPq;
	int len;
	public MedianFinder() {
		this.maxPq = new PriorityQueue<>(Collections.reverseOrder());
		this.minPq = new PriorityQueue<>();
		this.len = 0;
	}

	public void addNum(int num) {
		this.len++;
		if(len%2==0){
			// actually there should be addition on the right side but check if the num coming is
			// less than the max of the left half if yes take the max from left and put in right and push the
			// coming number in the left half
			if(maxPq.size() > 0 && num<maxPq.peek()){
				int temp = maxPq.poll();
				maxPq.add(num);
				minPq.add(temp);
			}else{
				minPq.add(num);
			}
		}else{
			// actually there should be addition on the left side but check if the num coming is
			// more than the min of the right half if yes take the min from right and put in left and push the
			// coming number in the right half
			if(minPq.size() > 0 && num>minPq.peek()){
				int temp = minPq.poll();
				maxPq.add(temp);
				minPq.add(num);
			}else{
				maxPq.add(num);
			}
		}
	}

	public double findMedian() {
		if(this.len%2==0){
			int val1 = maxPq.peek();
			int val2 = minPq.peek();
			return (val1 + val2) * 1.0 / 2;
		}else{
			return maxPq.peek();
		}
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */