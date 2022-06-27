package Z.com.anup.java8;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//check for Boolean part 
		//::Represents a predicate (boolean-valued function) of one argument. 
		//where predicate is functional interface have only 1 method
		//This is a functional interfacewhose functional method is test(Object).
		Predicate<String> pre1= s->s.length()>=5;
		System.out.println("the length of the strig is mor than 5 ::"+ pre1.test("trythisString"));
		
		
		
		//predicate joining 
		
		
		Predicate<String> pre2= s->s.length()/2==0;
		System.out.println("the length of the string is odd:"+pre2.test("howaboutnow?"));
		
		Predicate<String> pre3= s->s.length()%2==0;
		System.out.println("the length of the string is  even:"+pre3.test("howaboutnow?"));
		
		
		Predicate pre4 = pre1.and(pre3);
		System.out.println("the length of the string is odd:"+pre4.test("howaboutnow?"));
	}

}

// Input single argument
// input type can be anthing like String, Integer or Employee
//return type is not needed as it is always Boolean
//advantage over ternary >> code reusablity  .. we can use  variable pre1 anywhere we need it
//
// predicate joing 
	//and 
		// negate
			//or 

