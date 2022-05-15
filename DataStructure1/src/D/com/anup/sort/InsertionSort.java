package D.com.anup.sort;
//card game


public class InsertionSort {
	 
    public void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
 
    public void sort(int[] arr) {// for each for loop iteration both j and i changes opp direction
        int n = arr.length;
 // from unsorted part, we take the """first element"""" and place it inside the sorted array 
        //at its correct position. This is done by shifting all the elements which are
        //larger than the first elemnet by one position.
        
        for(int i = 1; i < n; i++) { // unsorted part
            int temp = arr[i];
            int j = i - 1; // sorted part//////////////////////////
 
            while(j >= 0 && arr[j] > temp) {// comparing first element of the unsorted part to the each 
            	//and every element of the sorted path 
                arr[j + 1] = arr[j]; // shifting larger elements to temp by 1 pos to create space 
                j = j - 1;// pointer moving in the leftside to check with all the elements
            }
            arr[j + 1] = temp;
        }
    }
 
    public static void main(String[] args) {
        int[] arr = new int[] {5, 1, 2, 9, 10};
        InsertionSort is = new InsertionSort();
        is.printArray(arr);
        is.sort(arr);
        is.printArray(arr);
    }
 
}