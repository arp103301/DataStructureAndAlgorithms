package ik.com.anup.recursion;

import java.util.ArrayList;
import java.util.Arrays;

import D.com.anup.test.SysOut;

/*Given a string that might contain duplicate characters, find all the possible distinct subsets of that string.

Example One
{
"s": "aab"
}
Output:

["", "a", "aa", "aab", "ab", "b"]
Example Two
{
"s": "dc"
}
Output:

["", "c", "cd", "d"]
Notes
All the subset strings should be individually sorted.
The order of the output strings does not matter.
Constraints:

1 <= length of the string <= 15
String consists of lowercase English letters*/
public class SubsetsWithDuplicateCharacters {
	 
	public static ArrayList<String> get_distinct_subsets(String s) {
	       char[] sortedCharArr = s.toCharArray();
	       Arrays.sort(sortedCharArr);// for duplicate entroes 

	       ArrayList<String> result = new ArrayList<>();
	       subsetHelper(sortedCharArr, 0, new StringBuilder(), result);
	       return result;
	    }
	    
	    static void subsetHelper(char[] inputCharArr, int indx, StringBuilder slate,  ArrayList<String> result){
	        if(inputCharArr.length == indx){
	            result.add(slate.toString());
	            
	            //print
	             
	            System.out.println(result);
	            return;
	        }
	        
	       
	        //include current element and recur
	        slate.append(inputCharArr[indx]);
	        subsetHelper(inputCharArr, indx + 1, slate, result);
	        slate.deleteCharAt(slate.length()-1);
	        
	        //   // remove adjacent duplicate elements>>>> extra step for subset with duplicae elemetns
	        while(indx < inputCharArr.length-1 && inputCharArr[indx] == inputCharArr[indx+1]){
	            indx++;
	        }
	        
	         //do not include current element and recur
	        subsetHelper(inputCharArr, indx+1, slate, result);
	    }
	  
	    
	    
	    
	    public static void main(String[] args)
	    {
	        Integer[] S = { 1, 3, 1 }; 
	      
	        ArrayList<Integer> numlist= new ArrayList<Integer>(Arrays.asList(S));
	        get_distinct_subsets("131");
	    }
}
