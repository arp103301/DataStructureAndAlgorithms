package D.com.anup.sort;
// sort using the index
public class MergeSort {

	MergeSort() {

	}

	void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}

	void mergesort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); // Sort left half
			mergesort(array, helper, middle + 1, high); // Sort right half
			merge(array, helper, low, middle, high); // Merge them
		}
	}

	void merge(int[] array, int[] helper, int low, int middle, int high) {
		// Copy both halves into a helper array
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		// Iterate through helper array. Compare the left and right
		// half of helperaray, copying back the "smaller" element from the two halves
		// into the original array.

		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If helperRight element is smaller than helperLeft element
				array[current] = helper[helperRight];
				helperRight++;// both pointer moves right since the main while is checking
			}
			current++;
		}

		// Copy the rest of the left side of the array into the
		// target array

		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}

	// display
	public void display(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	
	
	////
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 2, 9, 10 };
		MergeSort ms = new MergeSort();
		ms.display(arr);
		ms.mergesort(arr);
		ms.display(arr);
	}
}
