package ik.com.anup.LinkedList;
// hint:: always push to s1
// for pop:: always from s2.. if s2 is  empty( add the elements from s1 to s2  and then start popping off);
import java.util.Stack;

public class QueueUsingTwoStacks {

	
	  private Stack<Integer> inputStack = new Stack<Integer>();
	  private Stack<Integer> outputStack = new Stack<Integer>();

	  
	  
	    public void enqueue(Integer item) {
	        inputStack.push(item);
	    }

	    
	    
	    
	    public Integer dequeue() {
	    	
	    	 /* If both stacks are empty then error */
	        if (inputStack.isEmpty() && outputStack.isEmpty()) {
	            System.out.println("Q is empty");
	            System.exit(0);
	        }
	    	
	    	
	    	 /* Move elements from stack1 to stack 2 only if
	        stack2 is empty */
	        if (outputStack.isEmpty()) {
	            while (!inputStack.isEmpty()) {
	               outputStack.push(inputStack.pop());
	            }
	        }
	        return outputStack.pop();
	    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueUsingTwoStacks q = new QueueUsingTwoStacks(); 
		    q.enqueue(1); 
		    q.enqueue(2); 
		    q.enqueue(3); 
		  
		    System.out.println(q.dequeue()); 
		    System.out.println(q.dequeue());
		    System.out.println(q.dequeue());

	}

}

/*Time Complexity: 
	Push operation: O(1). 
	Same as pop operation in stack.
	Pop operation: O(N). 
	In the worst case we have empty whole of stack 1 into stack 2
	Auxiliary Space: O(N). 
	Use of stack for storing values*/