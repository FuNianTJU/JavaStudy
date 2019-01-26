package executor.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池监控示例
 * @author lenovo
 *
 */
public class TestThreadPoolExecutor {

   public static void main(final String[] arguments) throws InterruptedException {
	   
      ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();

      //Status before tasks execution
      System.out.println("Maximum allowed threads: "
         + executor.getMaximumPoolSize());//最大线程数
      System.out.println("Current threads in pool: "
         + executor.getPoolSize());//当前线程数
      System.out.println("Currently executing threads: "
         + executor.getActiveCount());//正在执行任务的线程数
      System.out.println("Total number of tasks(ever scheduled): "
         + executor.getTaskCount());//计划任务数
      System.out.println("Total number of tasks completede: "
 	         + executor.getCompletedTaskCount());//完成任务数
      for(int i=1;i<=20;i++){
    	  executor.submit(new Task());
      }

      //Status after tasks execution
      System.out.println("Maximum allowed threads: "
         + executor.getMaximumPoolSize());
      System.out.println("Current threads in pool: "
         + executor.getPoolSize());
      System.out.println("Currently executing threads: "
         + executor.getActiveCount());
      System.out.println("Total number of tasks(ever scheduled): "
    	         + executor.getTaskCount());
      System.out.println("Total number of tasks completede: "
    	         + executor.getCompletedTaskCount());
      
      System.out.println("睡眠5秒");
      Thread.sleep(5000);
      System.out.println("Total number of tasks(ever scheduled): "
         + executor.getTaskCount());
      System.out.println("Total number of tasks completede: "
    	         + executor.getCompletedTaskCount());

      executor.shutdown();
   }  

   static class Task implements Runnable {

      public void run() {
         try {
            System.out.println("Running Task! Thread Name: " + Thread.currentThread().getName());
            Thread.sleep(2000);
         } 
         catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}