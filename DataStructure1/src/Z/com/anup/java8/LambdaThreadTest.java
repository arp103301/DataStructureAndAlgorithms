package Z.com.anup.java8;

import java.util.concurrent.TimeUnit;

public class LambdaThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
	/*	Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println("My task1 started..");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("My task1 end..");
			}
		};
		
		
		Thread th1 = new Thread(task1);
		th1.start();
		*/
		
		
		// Child thread

		new Thread(() -> { // Lambda Expression
	         for(int i=1; i <= 5; i++) {
	            System.out.println("Child Thread: "+ i);
	            try {
	               Thread.sleep(500);
	            } catch(Exception e) {
	               e.printStackTrace();
	            }
	         }
	      }).start();
	      
	      
	      
		
	      
	      
	      // Main Thead
	      for(int j=1; j < 5; j++) {
	         System.out.println("Main Thread: "+ j);
	         try {
	            Thread.sleep(500);
	         } catch(Exception e) {
	            e.printStackTrace();
	         }
	
	      }
	}
}
