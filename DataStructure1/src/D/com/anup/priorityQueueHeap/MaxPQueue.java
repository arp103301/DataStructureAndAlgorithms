package D.com.anup.priorityQueueHeap;
import java.util.PriorityQueue;
public class MaxPQueue {
	private Integer[] heap;
	private int n; // size of max heap
	
	public MaxPQueue(int capacity) {
		heap = new Integer[capacity + 1]; // index 0 is kept as empty
		n = 0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	public static void main(String[] args) {
		MaxPQueue pq = new MaxPQueue(3);
		System.out.println(pq.size());
		System.out.println(pq.isEmpty());
	}
	
	
	
}