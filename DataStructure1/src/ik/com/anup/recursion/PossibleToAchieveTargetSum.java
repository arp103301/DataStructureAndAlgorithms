package ik.com.anup.recursion;

import java.util.ArrayList;

/*Possible To Achieve Target Sum
Given a set of integers and a target value k, find whether there is a non-empty subset that sums up to k.

Example One
{
"arr": [2, 4, 8],
"k": 6
}
Output:

1
Because 2 + 4 = 6.

Example Two
{
"arr": [2, 4, 6],
"k": 5
}
Output:

0
Because no subset of numbers from the input sums up to 5.

Notes
Constraints:

1 <= size of the input array <= 18
-1012 <= elements of the array, k <= 1012*/
public class PossibleToAchieveTargetSum {
	
	
	static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {

     return  helper(arr,k, 0,  0, 0);
   
 }
 
 static Boolean helper(ArrayList<Long> arr,long target , int indx,  long slate, int count) {// count is used to make sure edge case of null element
     
	 if(arr.size() == 0)   return false;
         
	  if (indx==arr.size()) {
         if(slate == target && count!=0){
             return true;
         }
         if (slate == 0&& target ==0 && count==0) {
        	 return false ;
         }
	  }  
         // RECURSION
         
        
         
         //include
         boolean left = helper(arr,target,indx+1,slate+arr.get(indx),count+1);
          
         // do not include 
         boolean right = helper(arr,target,indx+1,slate,count);
         
          return (left || right);
         
 }
	

}
