package Z.com.anup.Concurrency;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//https://www.youtube.com/watch?v=GLaXemAWTvk  for diagram 10:35 mn/secs
// Tasks are subummited to threadPool via a queue called blockingQueue

//https://github.com/kishanjavatrainer/FutureAndCallableExample/blob/master/FutureAndCallableExample/src/com/infotech/client/ClientTest.java

public class CallableClient {


		public static void main(String[] args) {
			
			Callable<String> task1 = new Callable<String>() {
				@Override
				public String call() throws Exception {
					return "My Task is done";
				}

			};
			
			ExecutorService executorService = Executors.newSingleThreadExecutor();
			Future<String> future = executorService.submit(task1);/////////////**************////
			if(future.isDone()){
				try {
					System.out.println(future.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
			
			/*
			 * MyCallable task2 = new MyCallable(10); Future<Integer> future2 =
			 * executorService.submit(task2);
			 * 
			 * try { System.out.println(future2.get()); } catch (InterruptedException |
			 * ExecutionException e) { e.printStackTrace(); }
			 */
			
			executorService.shutdown();
		}

	
}
