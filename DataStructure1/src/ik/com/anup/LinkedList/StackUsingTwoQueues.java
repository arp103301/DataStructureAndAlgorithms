package ik.com.anup.LinkedList;

// Hint: always pop from q1 
// ADD:: to q1 if empty .. 
		//Add:if q1 is not empty then reverse the q1 o q2, then add this current one and reverse the q2 to q1 



import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

	
	
	
	Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    public int pop() {// always pop from queue1 
        if (q1.peek() == null) {
            System.out.println("The stack is empty, nothing to return");
            int i = 0;
            return i;
        } else {
            int pop = q1.remove();
            return pop;
        }
    }

    public void push(int data) {

        if (q1.peek() == null) {
            q1.add(data);
        } else {
            for (int i = q1.size(); i > 0; i--) {
                q2.add(q1.remove());
            }
            q1.add(data);
            for (int j = q2.size(); j > 0; j--) {
                q1.add(q2.remove());
            }

        }
    }
    
     int top()
    {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }
     public boolean empty() {
         if (q1.isEmpty() && q2.isEmpty())
             return true;
         else   return false;
     }
    
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingTwoQueues s1 = new StackUsingTwoQueues(); 
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.push(9);
        s1.push(10);
        // s1.push(6);
        System.out.println("1st = " + s1.pop());
        System.out.println("2nd = " + s1.pop());
        System.out.println("3rd = " + s1.pop());
        System.out.println("4th = " + s1.pop());
        System.out.println("5th = " + s1.pop());
        System.out.println("6th = " + s1.pop());
        System.out.println("7th = " + s1.pop());
        System.out.println("8th = " + s1.pop());
        System.out.println("9th = " + s1.pop());
        System.out.println("10th= " + s1.pop());
	}

}
/* pop - O(1)
push - O(n)*/