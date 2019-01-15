package _并发_;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 倒计时锁存器CountdownLatch示例
 * 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 * 用给定的计数 初始化 CountDownLatch。
 * 调用 countDown()方法会使计数减1，在当前计数到达零之前，await 方法会一直受阻塞
 * @author yan
 *
 */
public class CountdownLatchDemo {
	static final int SIZE = 10;
	
	public static void main(String[] args){
		ExecutorService executorService = Executors.newCachedThreadPool();
		//初始化锁存器,前置任务和等待任务使用同一个锁存器对象
		CountDownLatch latch = new CountDownLatch(SIZE);
		try {
			for(int i=0;i<10;i++){
				executorService.execute(new WaitingTask(latch));
			}
			for(int i=0;i<SIZE;i++){
				executorService.execute(new TaskPortion(latch));
			}
			System.out.println("启动所有任务。");
			executorService.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//执行任务的一部分
class TaskPortion implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private static Random rand = new Random(47);
	private final CountDownLatch latch;
	
	public TaskPortion(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void doWork() throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.println(this + " completed");
	}
	
	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public String toString() {
		return String.format("%1$-3d ", id);
	}
}

//等待锁存器释放才能执行
class WaitingTask implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private final CountDownLatch latch;
	
	public WaitingTask(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await();
			System.out.println("Latch barrier passed for " + this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String toString() {
	    return String.format("WaitingTask %1$-3d ", id);
	}
	
}













