package _并发_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * volatile关键字解决并发可见性问题
 * 主内存中有一变量data,使用volatile关键字修饰，可达到以下效果
 * 1)线程1修改完本地工作内存中的data变量后，强制将data最新值刷新回主内存
 * 2)此时强制让其他线程的工作内存中的data变量值直接过期失效，使用data需要重新从主内存加载
 * 注意:volatile关键字不能保证原子性
 * @author yan
 *
 */
public class VolatileTest {
	public volatile int data = 0;
	public int data2 = 0;
	
	public static void main(String[] args){
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Thread1());
		executorService.execute(new Thread2());
	}
}

class Thread1 extends VolatileTest implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			data++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
}

class Thread2 extends VolatileTest implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(data);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
}