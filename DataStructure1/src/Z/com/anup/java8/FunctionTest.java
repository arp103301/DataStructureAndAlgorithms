package Z.com.anup.java8;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// Function <InputType, ReturnType>
		 Function<Integer, Integer> fun1 = i ->i*i;
		 System.out.println(" the function output is "+ fun1.apply(5));
		
		 
		  Function <Integer,Integer>  fun2 = i->i+2;
		  System.out.println(" the function output is "+ fun2.apply(5));
		 
		 
		  Function fun3 = fun1.andThen(fun2);// first f1 and then f2
		  System.out.println(" Functional Chaining "+fun3.apply(9));
		  
		  Function fun4 = fun1.compose(fun2);// first f2 then f1
		  System.out.println(" Functional Chaining "+fun4.apply(9));
	}

}
//  this is functional interface 
//takes 1 input and gives 1 ouput
//output may not be boolean

// need to declare return and input type
