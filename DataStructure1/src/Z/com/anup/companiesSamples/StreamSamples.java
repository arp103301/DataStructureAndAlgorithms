package Z.com.anup.companiesSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import D.com.anup.test.SysOut;

public class StreamSamples {

	 static class Person {
		
		 String id ;
		 String name;
		 Integer age;
		 
		 public Person () {
			 
		 }
		
		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public Integer getAge() {
			return age;
		}

		public Person(String id, String name, Integer age) {
			this.id= id; this.age= age; this.name= name;
			
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	List <Person> personList = new ArrayList<>();
	
	personList.add(new Person ("1111","AAAA",31));
	personList.add(new Person ("2222","BBBB",41));
	personList.add(new Person ("3333","CCCC",51));
		
		//i-> i>20  or i-> i*i
	//Stream s =personList.stream().filter(Person->Person.age>40);
	//s.toList().forEach(x-> System.out.println("the person with age greater then 40 is"));
			
	//personList.stream().filter(Person->Person.age>40).
	//forEach(Person-> System.out.println("the person with age greater then 40 is"+Person.toString()));
	
	

	
	Map<Integer, Person> personMap = new HashMap<>() {{// double curly
		put(31, new Person ("1111","AAAA",31));
		put(41, new Person ("2222","BBBB",41));
		put(51, new Person ("3333","CCCC",51));
	}};
	
	//personMap.put(31, new Person ("1111","AAAA",31)));// throwing error why???
	
	personMap.forEach((key,value)->System.out.println(value.getName()+":"+value.getAge()));
	
	
	
	
	
	Integer []  num1 = {0,1,1,0,0,1,0,1,0,1};
	//Integer [] num2 = new Integer[num1.length];
	//List<Integer> list = Arrays.asList(num1);
	
	int left = 0, right = num1.length - 1;
	 
  /*  while (left < right)
    {
        // Increment left index while we see 0 at left 
        while (num1[left] == 0 && left < right)
           left++;

        // Decrement right index while we see 1 at right
        while (num1[right] == 1 && left < right)
            right--;

        // If left is smaller than right then there is a 1 at left
         //  and a 0 at right.  Exchange arr[left] and arr[right]
        if (left < right)
        {
        	num1[left] = 0;
        	num1[right] = 1;
            left++;
            right--;
        }
    }
*/
	
	for (int i= 0; i<num1.length-1; i++) {
		if (num1[i+1]<num1[i]) {
			int temp = num1[i+1];
			num1[i+1]= num1[i];
			num1[i]= temp;
		}
		System.out.println(""+num1);
	}
	
	//using java 8
	   List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
		List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
		
		sortedList.forEach(i-> System.out.println(i));
}//main

}//class