package Z.com.anup.companiesSamples;

// num%i ==0 in the for loop gives prime;

// Method to compute the prime number
// Time Complexity is O(sqrt(N))
/*static boolean checkPrime(int numberToCheck)
{
    if(numberToCheck == 1) {
        return false;
    }
    for (int i = 2; i*i <= numberToCheck; i++) {
        if (numberToCheck % i == 0) {/////////////////////////////////////////*
            return false;
        }
    }
    return true;
}*/


public class CountPrimeNumbers {
	 public  static int countPrimes(int n) {
         
		   boolean primes[] = new boolean [n];
		        //since default is false and we need true   
		         for (int i=0;i<primes.length; i++) primes[i]= true;
		        
					/*
					 * Any non-prime number will always have a factor that is less than or equal to
					 * its square root. For example, pick 36. It's factors are - 1*36, 2*18, 3*12,
					 * 4*9, 6*6. In each case, there is at least one number satisfying the above
					 * condition. So here, by considering all numbers up to the square root of n, we
					 * can successfully eliminate the non-prime numbers up to n.
					 */
		        for(int i =2;i*i<n;i++)// see reason above >>>>>>>>>>>>0(sqrt(n)
		        {
		            if(primes[i])
		            {
		                // Update all multiples of i to false
		                for(int j = i*i;j<n;j=j+i)////>>>>>>>>>>>>>>>>0(sqrt(n)
		                {
		                    primes[j]=false;
		                }
		                
		            }
		        }
		        
		        int count =0;
		        //sum the count
		        for (int i= 2; i<primes.length; i++){
		            if (primes[i]) count++;
		            
		        }
		      return count  ; 
		    }
	 
	 // Driver code
	    public static void main(String[] args)
	    {
	      
	 
	       
	        System.out.println(countPrimes(13));
	    }
}


//O(n)= O(sqrtn*sqrtn+n)= O(n)