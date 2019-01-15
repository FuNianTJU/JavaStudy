package _并发_;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * 测试不同map的写性能
 * @author yan
 *
 */
public class ConcurrentMapTest {
	public static void main(String[] args){
//		final Map<String, String> map = new Hashtable<String, String>(); //jdk1.5 之前的线程安全容器
//		final Map<String, String> map = new ConcurrentHashMap<String, String>(); //jdk1.5之后的线程安全容器
		final Map<String, String> map = new ConcurrentSkipListMap<String, String>();
		
		final Random random = new Random();
		Thread[] array = new Thread[100];
		final CountDownLatch latch = new CountDownLatch(array.length);
		
		long begin = System.currentTimeMillis();
		for(int i=0;i<array.length;i++){
			array[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0; j<10000; j++){
						map.put("key"+j, "value"+random.nextInt(10000));
					}
					latch.countDown();
				}
			});
		}
		
		for(Thread t : array){
			t.start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("执行时间为："+ (end-begin) + "ms");
	}

}
















