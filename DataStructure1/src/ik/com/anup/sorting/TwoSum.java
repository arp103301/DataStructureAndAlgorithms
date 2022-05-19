package ik.com.anup.sorting;

//map of value_i/key_i 


/*Given an array and a target number, find the indices of the two values from the array that sum 
up to the given target number.

Example One
{
"numbers": [5, 3, 10, 45, 1],
"target": 6
}
Output:

[0, 4]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	 
	
	 static ArrayList<Integer> two_sum(ArrayList<Integer> numbers, Integer target) {
	        // Write your code here.
	        Map<Integer,Integer> map = new HashMap<>(numbers.size());
	        ArrayList<Integer> resultList = new ArrayList<>(2);
	        for(int i=0; i<numbers.size(); i++){
	            int n2 = target - numbers.get(i);
	            
	            if(map.containsKey(n2)){
	                resultList.add(map.get(n2));
	                resultList.add(i);
	                return resultList;
	            } else {
	                map.put(numbers.get(i), i);
	            }
	        }
	        //not found hence populate the list as [-1,-1] and return it
	        resultList.add(-1);
	        resultList.add(-1);
	        return resultList;
	    
	 }
	 }