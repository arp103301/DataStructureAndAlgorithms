package ik.com.anup.sorting;

public class LambdaExpression2 {


	
		public class Main {
				
		  public static void main(String[] args) {
		    StringFunction exclaim = (s) -> s + "!";
		    StringFunction ask = (s) -> s + "?";
		    printFunction("Hello", exclaim);
		    printFunction("Hello", ask);
		  }
		   
		  public static void printFunction(String str, StringFunction format) {
		    String result = format.run(str);
		    System.out.println(result);
		  }
		
		}
		
		interface StringFunction {
			  
			String run(String str);	
		}

	}
