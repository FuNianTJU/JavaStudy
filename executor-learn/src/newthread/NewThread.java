package newthread;

import java.util.concurrent.*;  
import java.util.Date;

/**
 * 实现线程的3中方式
 * @author lenovo
 *
 */
//方式一：继承Thread实现多线程
class NewThread_1 extends Thread {
	public void run(){
		System.out.println("继承Thread类实现多线程");
	}
}

//方式二：实现Runnable接口实现多线程
class NewThread_2 implements Runnable{
	public void run(){
		System.out.println("实现Runnable接口实现多线程");
	}
}

//方式三：实现Callable接口，实现有返回结果Future的多线程
//需定义返回值类型
class NewThread_3 implements Callable<Object>{
	private String name;
	public NewThread_3(String name) {
		this.name = name;
	}
	public Object call() throws Exception{
		System.out.println(">>>"+name+"任务启动");
		Date dateTmp1 = new Date();
		Thread.sleep(1000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>"+name+"任务结束");
		return name + "任务返回结果，任务运行时间为【" + time + "毫秒】";
	}
}

public class NewThread{
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		//方式一
		NewThread_1 thread_1 = new NewThread_1();
		thread_1.start();
		
		//方式二，需先实例化一个Thread，并传入自己的NewThread_2实例
		NewThread_2 thread_2 = new NewThread_2();
		Thread t = new Thread(thread_2);
		t.start();
		
		//方式三（实现一）构造FutureTask对象
		NewThread_3 thread_3 = new NewThread_3("有返回值的线程");
		FutureTask<Object> fTask = new FutureTask<>(thread_3);	
		//使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程
		Thread fThread = new Thread(fTask);
		fThread.start();
        System.out.println("子线程的返回值："+fTask.get());//获取返回值
        
		//使用ExecutorService执行任务,创建线程池
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(fTask);//提交任务
		System.out.println("子线程的返回值："+fTask.get()); //获取返回值
		executor.shutdown();//关闭线程池
       
		//方式三（实现二）不构造FutureTask对象，使用ExecutorService.submit方法来获得Future对象
		ExecutorService executor2 = Executors.newCachedThreadPool();
		Future future = executor2.submit(thread_3);
		executor2.shutdown();
		System.out.println(">>>"+future.get().toString());	
	}	
}
















