package D.com.anup.array;

import java.util.HashMap;
import java.util.Map;
 
public class TwoSumArray {
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < numbers.length; i++) {
		    if(!map.containsKey(target - numbers[i])) {
			   map.put(numbers[i], i);// key is value of array and value is indx of array
		    } else {
		         result[1] = i;
		         result[0] = map.get(target - numbers[i]);
		         return result;   
		    }
		}
		throw new IllegalArgumentException("Two numbers not found");
	}
 
	public static void main(String[] args) {
		int[] numbers = {2, 11, 5, 10, 7, 8};
		int[] result = twoSum(numbers, 9);
		System.out.println("The two indices are - " + result[0] + 
                                   " and " + result[1]);
	}
}