package executor.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 批量提交任务
 * @author lenovo
 *
 */
public class InvokeAll {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		//获取任务队列
		List<Callable<String>> taskList = new ArrayList<Callable<String>>();
		for(int i=0;i<20;i++){
			taskList.add(new ThreadJob(i));
		}
		
		ExecutorService exe = Executors.newCachedThreadPool();
		
		//invokeAll执行给定的任务，当所有任务完成时，返回保持任务状态和结果的 Future 列表
		List<Future<String>> futures = exe.invokeAll(taskList);
		for(Future<String> future : futures){
			System.out.println(future.get());
		}
		exe.shutdown();
	}
	
}

class ThreadJob implements Callable<String>{
	private int id;
	public ThreadJob(int id){
		this.id = id;
	}
	/**  
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法， 
     * 则该方法自动在一个线程上执行 
     */ 
	public String call() throws Exception{
		System.out.println("call()方法被自动调用！ " + Thread.currentThread().getName());
		Thread.sleep(1000);
		return "call()方法被自动调用，任务返回的结果是：任务id: " + id + 
				" 线程名为： " + Thread.currentThread().getName();
	}
}
