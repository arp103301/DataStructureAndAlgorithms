package D.com.anup.priorityQueueHeap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxPQ {
	private Integer[] heap;
	private int n; // size of max heap

	public MaxPQ(int capacity) {
		heap = new Integer[capacity + 1]; // index 0 is kept as empty
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	// insert with value
	public void insert(int x) {
		if (n == heap.length - 1) {// heap size equals array size (heap is array and n is heap size)
			resize(2 * heap.length);//double the length of array
		}
		n++;
		heap[n] = x;
		swimUp(n);
	}

	////// swim the index
	private void swimUp(int k) {

		int childIndx =k;
		int parentIndx =k/2;

		//  while( k>1) for swimup

		while (childIndx > 1 && heap[childIndx/2] < heap[childIndx]) {// parentValue should be greater than childValue for maxheap
			swap (childIndx/2,childIndx);
			// continue shifting "UP" till ..###############parentindex swim
			childIndx = parentIndx;// move up<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Iterator

		}
	}

	/**
	 * This will delete element at index x Complexity: O(log N)
	 *
	 */
	public int delete(int k) {// delete index and return Value
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty, No element to delete");
		int value = heap[k];
		heap[k] = heap[n ];// bring last element to the deleted nodeIndex>> ZeroIndx is not used 
		n--;
		sinkDown(k);
		return value;
	}

	/**
	 * This method used to maintain the heap property while deleting an element.
	 * 
	 */
	public void sinkDown(int k) {////// sinkdown the index

		int parent = heap[k];
		int maxChildIndx ;
		int rightMostChild = 2*k+1;
		while (rightMostChild < n) {///otherwise we get ArrayIndexException
			int leftChildIdx = 2 * k;
			int rightChildIdx = 2 * k + 1;
			
			
			 maxChildIndx = heap[leftChildIdx] > heap[rightChildIdx] ? leftChildIdx :rightChildIdx ;
			 
			if (parent < heap[maxChildIndx]) {
				heap[k] = heap[maxChildIndx];
			} else
				break;//no need to do anything since maxChild takes care of both scenarios

			k = maxChildIndx;//>>>>>>>>>>>>>>>Move the iterator DOWN>>>>>>>>>>>
		}
		heap[k] = parent;
		
	}

	public void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	 
	private void resize(int capacity) {
		Integer[] temp = new Integer[capacity];
		for (int i = 0; i < heap.length; i++) {
			temp[i] = heap[i];
		}
		heap = temp;
	}

	public void printMaxHeap() {
		for (int i = 1; i <= n; i++) {
			System.out.print(heap[i] + " ");
		}
	}

	public static void main(String[] args) {
		MaxPQ pq = new MaxPQ(1);
		pq.insert(41);
		pq.insert(15);
		pq.insert(112);
		pq.insert(634);
		pq.insert(90);
		pq.insert(37);
		System.out.println("Size of Initial MaxPQ is: " + pq.size());
		pq.printMaxHeap();
		pq.delete(2);// Values in Array starts with position 1 
		//
		System.out.println("\n" + "Size of Final MaxPQ is: " + pq.size());
		pq.printMaxHeap();
	}
}