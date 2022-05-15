package ik.com.anup.sorting;

/*Given an array of numbers, rearrange them in-place so that even numbers appear before odd ones.

Example
{
"numbers": [1, 2, 3, 4]
}
Output:

[4, 2, 3, 1]
The order within the group of even numbers does not matter; same with odd numbers. 
So the following are also correct outputs: [4, 2, 1, 3], [2, 4, 1, 3], [2, 4, 3, 1].

Notes
It is important to practice solving this problem by rearranging numbers in-place.
There is no need to preserve the original order within the even and within the odd numbers.
We look for a solution of the linear time complexity that uses constant auxiliary space.
Constraints:

1 <= length of the array <= 105
1 <= element of the array <= 109

**/

import java.util.ArrayList;
import java.util.Arrays;

public class Segregate_evens_and_odds {
    
	
	////////////////////////////////////same as Q sort 
      
	
	  static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {
   
      int leftPointer = 0;
      int rightPointer = numbers.size()-1;
      Integer temp;
    
		while (leftPointer < rightPointer) {
			if (numbers.get(leftPointer) % 2 == 0) { // if Even
				leftPointer++;
			} else if (numbers.get(rightPointer) % 2 != 0) {//odd
				rightPointer--;
			} else {
				// Swap the left and right index IFF leftpointer is at ODD number
				temp = numbers.get(leftPointer);
				numbers.set(leftPointer, numbers.get(rightPointer));
				numbers.set(rightPointer, temp);
				leftPointer++;
				rightPointer--;
			}
		}
      return numbers;
  }
  
	  public static void main(String[] args) {
	  Integer[] array = {10, 4, 61, 4, 8, 13, 2, 3};// java 8 Integer instead of int []
      ArrayList<Integer> numlist= new ArrayList<Integer>(Arrays.asList(array));
      for (int arrnum1 : numlist) {
          System.out.print(arrnum1+",");
      }
      System.out.print("\n After sorting \n");
      numlist = Segregate_evens_and_odds.segregate_evens_and_odds(numlist);
   
      for (int arrnum2 : numlist) {
          System.out.print(arrnum2+",");
      }
    }
}
