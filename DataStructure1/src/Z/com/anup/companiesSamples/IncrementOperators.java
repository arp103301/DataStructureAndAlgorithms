package Z.com.anup.companiesSamples;

public class IncrementOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 int sum =0;
 
 for (int i =0, j=0; i<5 & j<5;++i, j=i+1 ) {// having ++i or i++ in the increment step in for loop gives us the same result
	 sum+= i;
	 System.out.println(sum);
 }
	}

}
