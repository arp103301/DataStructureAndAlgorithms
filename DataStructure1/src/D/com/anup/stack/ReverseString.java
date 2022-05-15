package D.com.anup.stack;

import java.util.Stack;

public class ReverseString {
	
	public static String reverse(String str) {
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		
		for(char c : chars) {
			stack.push(c);
		}
		
		for(int i = 0; i < chars.length; i++) {// can use either of  char.length or str.length
			chars[i] = stack.pop();
		}
		return new String(chars);
		
	}
 
	public static void main(String[] args) {
		String str = "ABCD";
		System.out.println("Before reverse - " + str);
		System.out.println("After reverse - " + reverse(str));
	}
}