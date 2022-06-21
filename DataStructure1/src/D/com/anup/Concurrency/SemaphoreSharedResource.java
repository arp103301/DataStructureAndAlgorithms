package Z.com.anup.Concurrency;

//https://www.netjstech.com/2016/02/semaphore-in-java-concurrency.html

import java.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreSharedResource {
  public static void main(String[] args) {
    Semaphore semObj = new Semaphore(1);/////////////////********number of permits
   // MyThread4 st = new MyThread4(sem);//****************
    // Creating three threads
    //Thread t1 = new Thread(st, "Thread-A");// Thread instances
  //  Thread t2 = new Thread(st, "Thread-B");
   // Thread t3 = new Thread(st, "Thread-C");
    
    
    Thread t1 = new MyThread4(semObj, "Thread-A");// Thread instances
    Thread t2 = new MyThread4(semObj, "Thread-B");
    Thread t3 = new MyThread4(semObj, "Thread-C");
    
    
    t1.start();
    t2.start();
    t3.start();
  }
}


//Thread class with semaphore and counter variables and incrment/decrement methods inside run 
class MyThread4 extends Thread{
  private int count = 0;
  private Semaphore sem;
  MyThread4(Semaphore s, String name){
	  super(name);  
	  this.sem = s;
  }
  // incrementing the value
  public void increment() {
    try {
      // used sleep for context switching
      Thread.sleep(10);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    count++;
  }
  // decrementing the value
  public void decrement() {    
    count--;
  }

  public int getValue() {
    return count;
  }
    
  @Override
  public void run() {
    try {
      // acquire method to get one permit
      sem.acquire();
      this.increment();
      System.out.println("PermitCount for Thread After increment - " + Thread.currentThread().getName() + ":: " + this.getValue());
      this.decrement();
      System.out.println("PermitCount for Thread at last " + Thread.currentThread().getName() + ":: " + this.getValue());
      // releasing permit
      sem.release();
    }
    catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
