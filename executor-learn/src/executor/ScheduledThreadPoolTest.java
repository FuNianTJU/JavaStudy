package executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 可定时执行的线程池
 * @author lenovo
 *
 */
public class ScheduledThreadPoolTest {
	public static void main(String [] args){
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date day=new Date();
		System.out.println(df.format(day));
		System.out.println("============开始===========");
		/*
		 * 2秒后开始执行任务，每隔2秒执行一次
		 */
		final ScheduledFuture<?> handler = 
				scheduler.scheduleAtFixedRate(new beepTask(), 2, 2, TimeUnit.SECONDS);
		/*final ScheduledFuture<?> handler = 
				scheduler.scheduleWithFixedDelay(new beepTask(), 2, 2, TimeUnit.SECONDS);*/
		/*
		 * 20秒后关闭线程池
		 */
		scheduler.schedule(new Runnable() {
	         @Override
	         public void run() {
	        	 handler.cancel(true);
	             scheduler.shutdown();
	             System.out.println("==========取消任务执行，关闭线程池==========");
	             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     		 Date day=new Date();
	     		 System.out.println(df.format(day));
	         }
	      }, 10, TimeUnit.SECONDS);
	}
	
	static class beepTask implements Runnable{
		public void run(){
			System.out.println("吱吱吱");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date day=new Date();
			System.out.println(df.format(day));  
		}
	}
}
