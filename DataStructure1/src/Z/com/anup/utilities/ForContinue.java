package Z.com.anup.utilities;

public class ForContinue {
	  public static void main(String[] args) {
		   
		  //continue test :: next i occurs... skips 4 and next iteration continues
			
			for (int i = 0; i < 10; i++) {
				if (i == 4) {
					continue;
				}
				System.out.println(i);
			}
		  
		  
		  // break test:: for loop stops::This example stops the loop when i is equal to 4:
	/*	  for (int i = 0; i < 10; i++) {
		      if (i == 4) {
		        break;
		      }
		      System.out.println(i);
		    } 
		 */ }
}

