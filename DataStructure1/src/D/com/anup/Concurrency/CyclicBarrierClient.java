package Z.com.anup.Concurrency;




//https://www.java67.com/2015/06/how-to-use-cyclicbarrier-in-java.html

import java.util.concurrent.BrokenBarrierException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;




public class CyclicBarrierClient {
	// Main driver method
    public static void main(String args[])
        throws InterruptedException
    {
        // Let us create task that is going to
        // wait for four threads before it starts
    	CyclicBarrier barrier = new CyclicBarrier(4);// specify the number of 
 
        // Creating worker threads
        MyThread2 first = new MyThread2(1000, barrier, "WORKER-1");//My ThreadInstaces
        MyThread2 second = new MyThread2(2000, barrier, "WORKER-2");
        MyThread2 third = new MyThread2(3000, barrier, "WORKER-3");
        MyThread2 fourth = new MyThread2(4000, barrier, "WORKER-4");
 
        // Starting above 4 threads
        first.start();
        second.start();
        third.start();
        fourth.start();
 
        // The main task waits for  threads that are initialized iwth latch=3
       // barrier.await();///////////////No Need****************
 
        // Main thread has started
        System.out.println(Thread.currentThread().getName()+ " has finished");
    }
}



// threadClass has delay and latch var:::  and run method calls latch.countDown()

//A class to represent threads for which
//the main thread waits.
class MyThread2 extends Thread {
 private int delay;
 private CyclicBarrier barrier;

 public MyThread2(int delay, CyclicBarrier barrier,
               String name)
 {
     super(name);
     this.delay = delay;
     this.barrier = barrier;
 }

 @Override 
 public void run()
 {
     
         
	 try { 
	Thread.sleep(delay); 
	 System.out.println(Thread.currentThread().getName() + " is calling await()");
	 barrier.await();//******************//
	 System.out.println(Thread.currentThread().getName() + " has started running again"); 
	 } catch (InterruptedException | BrokenBarrierException e) { e.printStackTrace(); 
	 }

	 
 }
}