package D.com.anup.sort;


//find the minimum index in the unsorted array>> select the minm index and swap with outer loop index


public class SelectionSort {

	public void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void selectionSort(int[] arr) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum elementIndex in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)//j=i+1
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 2, 9, 10 };
		SelectionSort ss = new SelectionSort();
		ss.printArray(arr);
		ss.selectionSort(arr);
		ss.printArray(arr);
	}

}