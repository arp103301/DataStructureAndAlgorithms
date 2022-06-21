package Z.com.anup.Concurrency;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class RunnableSingleThread {
public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Runnable task1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println("My Task1..");
			}
		};
		
		Runnable task2 = ()->{
			System.out.println(Thread.currentThread().getName());
			System.out.println("My Task2..");
		};
		
		//MyTask task3 = new MyTask();
		executorService.submit(task1);
		executorService.submit(task2);
		//executorService.submit(task3);
		
		executorService.shutdown();
		
	}
}
