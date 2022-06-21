package Z.com.anup.Concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreThreadsComm {
	  public static void main(String[] args) {    
	    Shared s = new Shared();// this extra shared class takes i ::thisis not thread class
	    // Producer and Consumer threads
	    Thread t1 = new Thread(new SemProducer(s), "Producer");
	    Thread t2 = new Thread(new SemConsumer(s), "Consumer");
	    t1.start();
	    t2.start();    
	  }
	}











	// Shared class used by threads:: have sc(0) and sp(1).. and 
//	method get( sc_acquire/sp_release and put sp_acquire/sc_release
	class Shared{
	  int i;
	  // 2 semaphores 
	  Semaphore sc = new Semaphore(0);//consumer no permit
	  Semaphore sp = new Semaphore(1);// producer 1 permit

	  public void get(){
	    try {
	      // acquiring consumer semaphore
	      sc.acquire();
	    } catch (InterruptedException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    System.out.println("Got - " + i);
	    // releasing producer semaphore
	    sp.release();
	  }

	  public void put(int i){
	    try {
	      // acquiring producer semaphore
	      sp.acquire();
	    } catch (InterruptedException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    this.i = i;
	    System.out.println("Putting - " + i);
	    // releasing consumer semaphore
	    sc.release();
	  }
	}

	// Producer threadClass:: with SharedObj and run has put
	class SemProducer implements Runnable{
	  Shared s;
	  SemProducer(Shared s){
	    this.s = s;
	  }
	  @Override
	  public void run() {
	    for(int i = 0; i < 5; i++){
	      s.put(i);
	    }
	  }            
	}

	// Consumer threadClass with SharedObj and run has get
	class SemConsumer implements Runnable{
	  Shared s;
	  SemConsumer(Shared s){
	    this.s = s;
	  }
	  
	  @Override
	  public void run() {    
	    for(int i = 0; i < 5; i++){
	      s.get();                
	    }
	  }
	}