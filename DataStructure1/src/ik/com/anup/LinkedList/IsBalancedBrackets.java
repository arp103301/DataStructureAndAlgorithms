package ik.com.anup.LinkedList;
//https://www.youtube.com/watch?v=Otf9lp3DQJo
import java.util.Stack;

public class IsBalancedBrackets {

	 public boolean isValid(String s) {
	        boolean result = false ;
	        
	        Stack<Character> st = new Stack();
	        
	        for (int i =0; i<s.length(); i++) {
	        	
	        	char c = s.charAt(i);
	        	// case for open bracketts
	        	if (c=='(' || c =='{'||c=='['){
	        		st.push(c);
	        		
	        	}else {//// case for close bracketts
	        			if (st.isEmpty()) return false;
	        			else {//stack notempty
	        				 char poppedChar = st.pop();
	        				  if (poppedChar!='('&& s.charAt(i)==')'){//)
	        					  return false;
	        				  }
	        				  else if (poppedChar!='['&& s.charAt(i)==']'){//) {//]
	        					  return false;
	        				  }
	        					  
	        				  else if(poppedChar!='{'&& s.charAt(i)=='}'){//) {//}
	        					  return false;
	        				  }
	        				
	        			}
	        			
	        		}
     	
	        }
	        
	        //stack may not be empty by now
	        if (st.isEmpty()) result = true;
	        else  result =false ;
     
	        return result;
	    }
}
