package ik.com.anup.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

/*Given an integer array and a number k, find the k most frequent elements in the array.

Example One
{
"arr": [1, 2, 3, 2, 4, 3, 1],
"k": 2
}
Output:

[3, 1]
		
*/

public class Top_K_Frequent_Elements {
	
	
	
	static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
	    
	      HashMap<Integer,Integer> hmap = new HashMap<>();
	        for(int i=0;i<arr.size();i++){
	            hmap.put(arr.get(i),hmap.getOrDefault(arr.get(i),0)+1);// value = times it appears 
	        }
	      
	        PriorityQueue<Integer> pq = 
	        		new PriorityQueue<>((a,b)->hmap.get(a)-hmap.get(b));// comparator constructor of PQ
	        
	        
	        
	        Iterator iterator = hmap.keySet().iterator();

	        while (iterator.hasNext()) {
	            pq.add((Integer)iterator.next());
	            if(pq.size()>k){// occurs more time than k 
	                pq.poll();
	            }
	        }
	        return new ArrayList<Integer>(pq);
	    }
}
