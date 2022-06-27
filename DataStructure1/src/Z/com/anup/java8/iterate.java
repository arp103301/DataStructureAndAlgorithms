package Z.com.anup.java8;

import java.util.stream.Stream;

public class iterate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stream<String> st = Stream.iterate("", (str) -> str + "x"); 
		System.out.println(st.limit(3).map(str -> str + "y"));
		
	}

}
