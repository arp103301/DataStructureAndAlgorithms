package Z.com.anup.companiesSamples;
// Java program to find maximum distance between two
// same occurrences of a number.
import java.io.*;
import java.util.*;
public class DistanceMetric {


	    // Function to find maximum distance between equal elements
	    static int maxDistance(int[] arr, int n)
	    {
	        // Used to store element to first index mapping
	        HashMap<Integer, Integer> map = new HashMap<>();
	         
	        // Traverse elements and find maximum distance between
	        // same occurrences with the help of map.
	        int max_dist = 0;
	 
	        for (int i = 0; i < n; i++)
	        {
	            // If this is first occurrence of element, insert its
	            // index in map
	            if (!map.containsKey(arr[i]))
	                map.put(arr[i], i);
	 
	            // Else update max distance
	            else
	                max_dist = Math.max(max_dist, i - map.get(arr[i]));
	        }
	 
	        return max_dist;
	}
	 
	// Driver code
	public static void main(String args[])
	{
	    int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
	    int n = arr.length;
	    System.out.println(maxDistance(arr, n));
	}
	
	 
}
