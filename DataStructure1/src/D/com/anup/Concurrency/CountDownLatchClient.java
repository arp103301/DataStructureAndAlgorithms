package Z.com.anup.Concurrency;
//https://www.geeksforgeeks.org/difference-between-countdownlatch-and-cyclicbarrier-in-java/
import java.util.concurrent.CountDownLatch;






//CountDownLatch is a thread waiting for multiple threads to finish or calling countDown(). 
//When all threads have called countDown(), the awaiting thread continues to execute

//same type of threads **********************************myThread
// keeps track of tasks

public class CountDownLatchClient {
	// Main driver method
    public static void main(String args[])
        throws InterruptedException
    {
        // Let us create task that is going to
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(3);// specify the no. of calls to the countdown() method************
 
        // Creating worker threads
        CLThread first = new CLThread(1000, latch, "WORKER-1");//My ThreadInstaces
        CLThread second = new CLThread(2000, latch, "WORKER-2");
        CLThread third = new CLThread(3000, latch, "WORKER-3");
        CLThread fourth = new CLThread(4000, latch, "WORKER-4");
 
        // Starting above 4 threads
        first.start();
        second.start();
        third.start();
        fourth.start();
 
        // The main task waits for  threads that are initialized iwth latch=3
        latch.await();//********** diff between latch and cbarrir;; cbarrer do not need this in mainmethod
 
        // Main thread has started
        System.out.println(Thread.currentThread().getName()
                           + " has finished");
    }
}



// threadClass has delay and latch var:::  and run method calls latch.countDown()

//A class to represent threads for which
//the main thread waits.
class CLThread extends Thread {
 private int delay;
 private CountDownLatch latch;

 public CLThread(int delay, CountDownLatch latch,
               String name)
 {
     super(name);
     this.delay = delay;
     this.latch = latch;
 }

 @Override public void run()
 {
     try {
         Thread.sleep(delay);
         latch.countDown();//****************************
         System.out.println(
             Thread.currentThread().getName()
             + " finished");
     }
     catch (InterruptedException e) {
         e.printStackTrace();
     }
 }
}