package D.com.anup.sort;

public class HeapSort {

	public void printArray(int[] arr) {

		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void heapSort(int[] arr) {

// One by one move boundary of unsorted subarray

		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		// begins from the last of the binaryHeap= MaxPQ Array
		
		for (int i = n - 1; i > 0; i--) {///////////////
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}

	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int k) {
		int largest = k; // Initialize largest as root
		int left = 2 * k + 1; // left = 2*i + 1
		int right = 2 * k + 2; // right = 2*i + 2

		// If left child is larger than root
		if (left < n && arr[left] > arr[largest])
			largest = left;

		// If right child is larger than largest so far
		if (right < n && arr[right] > arr[largest])
			largest = right;

		// If largest is not root
		if (largest != k) {
			int swap = arr[k];
			arr[k] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 2, 9, 10 };
		HeapSort hs = new HeapSort();
		hs.printArray(arr);
		hs.heapSort(arr);
		hs.printArray(arr);
	}

}