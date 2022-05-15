package ik.com.anup.sorting;
//sort using the index
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import F.com.anup.algorithms.sorting.MergeSort;

/*Given a list of numbers, sort it using the Merge Sort algorithm.

Example
{
"arr": [5, 8, 3, 9, 4, 1, 7]
}
Output:

[1, 3, 4, 5, 7, 8, 9]
Notes
Constraints:

1 <= length of the given list <= 105
-109 <= number in the list <= 109*/


public class Merge_sort {
	

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        
        int start=0;
        int end=arr.size()-1;
        
        helper(arr, start, end);
        
        return arr;
    }
    
    
    static void helper(ArrayList<Integer> arr, int start, int end){
         
        if(start >= end)
            return;
            
        int mid = start + (end-start)/2;
        
        helper(arr, start, mid);// Sort left half
        helper(arr, mid+1, end);// Sort right half
        
        mergeHelper(arr, start, mid, end);// Merge them
        
    }
    
    static void mergeHelper(ArrayList<Integer> arr, int start, int mid, int end){
        ArrayList<Integer> aux = new ArrayList<>(end-start+1);
        
        int i=start;
        int j=mid+1;
        
        while(i <= mid && j <= end){
        	// Iterate through orignal array. Compare the left and right
    		// half of orginalaray, copying back the "smaller" element from the two halves
    		// into the auxarray.
            if(arr.get(i) <=  arr.get(j)){
                aux.add(arr.get(i));
                i++;
            } else {
                aux.add(arr.get(j));
                j++;
            }
        }
        //left half has remaining elements
        while(i <= mid){
            aux.add(arr.get(i));
            i++;
        }
        //right half has remaning elements
        while(j <= end){
            aux.add(arr.get(j));
            j++;
        }
        // after sorting ::copy the aux to original 
        for(int k = start; k<=end; k++){  
            arr.set(k, aux.get(k-start ));
        }
    }
    
    
    public static void main(String[] args) {
        Integer[] array = {10, 4, 6, 4, 8, -13, 2, 3};// java 8 Integer instead of int []
        ArrayList<Integer> numlist= new ArrayList<Integer>(Arrays.asList(array));
        for (int arrnum : numlist) {
            System.out.print(arrnum);
        }
        System.out.print("\n After sorting \n");
        numlist = Merge_sort.merge_sort(numlist);
        // Prints:
        // [-13, 2, 3, 4, 4, 6, 8, 10]
        //System.out.println(java.util.Arrays.toString(array));
        for (int arrnum : numlist) {
            System.out.print(arrnum);
        }
      }
}
