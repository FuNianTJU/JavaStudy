package executor.threadpool;

import java.util.concurrent.*;

/**
 * 三种线程池
 * @author lenovo
 *
 */
public class TestThreadPool {
	public static void main(String[] args){
		ExecutorService exec1 = Executors.newCachedThreadPool();
		ExecutorService exec2 = Executors.newFixedThreadPool(5);
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			//exec1.execute(new TestRunnable());//提交任务
			//exec2.execute(new TestRunnable());//提交任务
			exec3.submit(new TestRunnable());//提交任务
			System.out.println("=====" + i + "=====");
		}
		exec3.shutdown();
	}
}

class TestRunnable implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName() + "线程被调用了。");
	}
}