package ik.com.anup.LinkedList;

//hint::::::::::::::::::::::::::::::::::: stack is not result

import java.util.ArrayList;
import java.util.Stack;

/*You have to build a min stack. Min stack should support push, pop methods (as usual stack)
 *  as well as one method that returns the minimum element in the entire stack.

You are given an integer array named operations of size n, containing values >= -1.

operations[i] = -1 means you have to perform a pop operation. The pop operation does not return the removed/popped element.
operations[i] = 0 means you need to find the minimum element in the entire stack and add it at the end of the array to be returned.
operations[i] >= 1 means you need to push operations[i] on the stack.
Example
{
"operations": [10, 5, 0, -1, 0, -1, 0]
}
Output:

[5, 10, -1]
Initially stack = [], ans = [].
operations[0] = 10 -> push -> stack = [10], ans = []
operations[1] = 5 -> push -> stack = [10, 5], ans = []
operations[2] = 0 -> get minimum element -> stack = [10, 5], ans = [5]
operations[3] = -1 -> pop -> stack = [10], ans = [5]
operations[4] = 0 -> get minimum element -> stack = [10], ans = [5, 10]
operations[5] = -1 -> pop -> stack = [], ans = [5, 10]
operations[6] = 0 -> get minimum element -> stack = [], ans = [5, 10, -1] 
(As stack is empty we have to consider -1 as the minimum element.)

Notes
Return an integer array res, containing answer for each operations[i] = 0.
If stack is empty, then do nothing for pop operation.
If stack is empty, then consider -1 as the minimum element.
Constraints:

1 <= n <= 100000
-1 <= operations[i] <= 2 * 109, for all i.*/
public class ImplementAMinStack {
	  static ArrayList<Integer> min_stack(ArrayList<Integer> operations) {
	        // Write your code here.
	        // 5 value           5 min
	        // 5,4               5, 4
	        // 5, 4 , 10         5, 4
	        // 5, 4, 10, 11      5, 4
	        // 5, 4, 10, 11, 2   5, 4, 
	        // min = 4
	        // min = 2
	        // 10, 5,  5
	        // 10, 5, 5, 5
	        // Maintain a mintack, where for every item, insert the min into the stack
	        // since pop does not require to return 
	        Stack<Integer> minStack = new Stack<>();
	        ArrayList<Integer> result = new ArrayList<>();
	        for(int op: operations) {
	            // 10, 5
	            // result = 5 
	            // 10, 
	            
	            if(op >=1) {
	                if(minStack.isEmpty() || op < minStack.peek()) {
	                	//minstack.peek gives nodeValue on top, and we want to push whichever is the minimum
	                    minStack.push(op);
	                } else {
	                    minStack.push(minStack.peek());
	                }
	            } else if(op == 0) {// only required to send arraylist if op==0
	                if(!minStack.isEmpty()) {
	                    result.add(minStack.peek());
	                } else {
	                    result.add(-1);
	                }
	            } else if(op == -1) {
	                if(!minStack.isEmpty()) {
	                    minStack.pop();
	                }
	            }
	        }
	        return result;
	        
	    }
	  
	  
	  
	  
	/////  https://github.com/Eric-programming/CodeSolution/blob/master/src/Stack%26Queue/MinStack/MinStack.java
	  
	  
	  class MinStack {
		    Stack<Integer> stack = new Stack<>(); //Store all values
		    Stack<Integer> minStack = new Stack<>(); //Min value for each insertion
		    /** initialize your data structure here. */
		    public MinStack() {
		        
		    }
		    
		    public void push(int val) {
		        if(minStack.isEmpty() || val < minStack.peek()){
		            minStack.add(val);
		        }else{
		            minStack.add(minStack.peek());
		        }
		        stack.add(val);
		    }
		    
		    public void pop() {
		        stack.pop();
		        minStack.pop();
		    }
		    
		    public int top() {
		        return stack.peek();
		    }
		    
		    public int getMin() {
		        return minStack.peek();
		    }
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
