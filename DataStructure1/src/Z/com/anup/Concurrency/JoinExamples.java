package Z.com.anup.Concurrency;

public class JoinExamples extends Thread{   
   @Override
	public void run(){  
     for(int i=1;i<=2;i++){  
      try{  
    	  Thread.sleep(3);  
    	  System.out.println("The current  runMethod thread name is: " + Thread.currentThread().getName());  
      }catch(Exception e){System.out.println(e);}  
    //.out.println(i);  
     }  
    }  
   public static void main(String args[]){  
	// creating 3 threads  
	   JoinExamples th1 = new JoinExamples();  
	   JoinExamples th2 = new JoinExamples();  
	   JoinExamples th3 = new JoinExamples();  
	     
		// thread th1 starts
		th1.start();

		// starting the second thread after when
		// the first thread th1 has ended or died.
		try {
			System.out.println("The current1 thread name is: " + Thread.currentThread().getName());

			// invoking the join() method
			th1.join();//******************************************************************************************
		}

		// catch block for catching the raised exception
		catch (Exception e) {
			System.out.println("The exception has been caught " + e);
		}

		// thread th2 starts
		th2.start();

		// starting the th3 thread after when the thread th2 has ended or died.
		try {
			System.out.println("The current2 thread name is: " + Thread.currentThread().getName());
			th2.join();
		}

		// catch block for catching the raised exception
		catch (Exception e) {
			System.out.println("The exception has been caught " + e);
		}

		// thread th3 starts
		th3.start();
		System.out.println("The current3 thread name is: " + Thread.currentThread().getName());
	}
}


//main waits for both 0 and 1 to complete before completing itself, then th2 will complete on its own