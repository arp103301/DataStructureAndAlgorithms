package D.com.anup.sort;

public class BubbleSort {
	 
    public void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
 
    public void sort(int[] arr) {
        int n = arr.length;
        boolean isSwapped;
 
        for(int i = 0; i < n - 1; i++) {
            isSwapped = false;// outer loop control as it will be unnecessary if no swap happens to j
            
            for(int j = 0; j < n - 1 - i; j++) {//j=n-1-i//removing the largest as it sinks
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false) {// no need to do the further 
                break;
            }
 
        }
 
    }
 
    public static void main(String[] args) {
        int[] arr = new int[] {5, 1, 2, 9, 10};
        BubbleSort bs = new BubbleSort();
        bs.printArray(arr);
        bs.sort(arr);
        bs.printArray(arr);
 
    }
 
}

/*
 * The orignal function always runs O(n^2) time even if the array is sorted. It
 * can be optimized by stopping the algorithm if the inner loop didn’t cause any
 * swap.
 */ 