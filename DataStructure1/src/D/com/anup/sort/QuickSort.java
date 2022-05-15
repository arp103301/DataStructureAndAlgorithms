package D.com.anup.sort;
//sort using value

public class QuickSort {
    
	  public static void quickSort(int arr[], int left, int right) {
	        int index = partition(arr, left, right);
	        if (left < index - 1) { // Sort left half
	            quickSort(arr, left, index - 1);
	        }
	        if (index < right) { // Sort right half
	            quickSort(arr, index, right);
	        }
	    }
	
	  public static int partition(int arr[], int left, int right) {
	        int pivotValue = arr[(left + right) / 2]; // Pick a pivot point. Can be an element.

	        while (left <= right) { // Until we've gone through the whole array
	            // Find element on left that should be on right
	            while (arr[left] < pivotValue) {
	                left++;
	            }

	            // Find element on right that should be on left
	            while (arr[right] > pivotValue) {
	                right--;
	            }
	            	// Now the elements are in wrong position coming from either direction
	            // Swap elements, and move left and right indices
	            if (left <= right) {
	                swap(arr, left, right);
	                left++;
	                right--;
	            }
	        }
	        return left;
	    }

	
	public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

   
    
    //display 
 // display
 	public void display(int[] arr) {
 		int n = arr.length;
 		for (int i = 0; i < n; i++) {
 			System.out.print(arr[i] + " ");
 		}
 		System.out.println();
 	}
    
  

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 1, 2, 19, 10,49, 57,81, 77, 99};
        QuickSort qs = new QuickSort();
        qs.display(arr);
        quickSort(arr, 0, arr.length - 1);
        qs.display(arr);
    }
}