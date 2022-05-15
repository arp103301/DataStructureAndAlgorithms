package ik.com.anup.strings;
import java.util.Stack;
/*The intuitive form of the algorithm is as follows:-

Convert the input number into a type where each digit of the number can be iterated properly
Iterate through each digit of the input number
2.1 If the digit is lesser than the digit present at the top of the stack, delete the element at the top of the stack and keep track of K
2.2 Add the digit of the input number to the stack
Perform a check for corner cases
Return the stack in the form of an integer as our final answer*/
public class RemoveKDigitsToMakeSmallestNumber {

	static int smallestNumber(int num, int K) {
		
		String input = String.valueOf(num);
		
		StringBuilder result = new StringBuilder();
		
		int numLength = input.length();
		
		if (K == numLength) {
			return 0;
		}
		if (K == 0) {
			return num;
		}
		int index = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (index < numLength) {
			//compare the top of stack to the incoming value
			while (K > 0 && !stack.isEmpty() &&  stack.peek() > Character.getNumericValue(input.charAt(index))) {
				stack.pop();
				K--;
			}
			// integer to push into stack
			stack.push(Integer.parseInt(String.valueOf(input.charAt(index))));
			index++;
		}
		/*
		 * while (K > 0) { stack.pop(); K--; }///////////is this necessary????
		 */
		while (!stack.isEmpty()) {
			result.append(stack.remove(0));
		}
		return Integer.parseInt(String.valueOf(result));
	}

	public static void main(String args[]) {
		System.out.println(smallestNumber(95163, 3));
	}
}
/*
 * We know that each element is going to be processed at most twice with respect
 * to the operations performed (1 push and 1 pop) and hence there will be 2n
 * operations at most. This makes our complexity (2N).
 * 
 * Let us assume that a constant amount of work C is being done each time inside
 * each loop (different operations such as comparison, insertion, removal,
 * etc.), which makes our total complexity ((2N) + C).
 */