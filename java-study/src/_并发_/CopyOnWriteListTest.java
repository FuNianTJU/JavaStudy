package _并发_;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class CopyOnWriteListTest {
	
	public static void main(String[] args){
//		final List<String> list = new LinkedList<String>();
//		final List<String> list = new Vector<String>();
		final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		final Random random = new Random();
		Thread[] array = new Thread[100];
		final CountDownLatch latch = new CountDownLatch(array.length);
		
		long begin = System.currentTimeMillis();
		for(int i=0;i<array.length;i++){
			array[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0; j<1000; j++){
						list.add("value"+random.nextInt(1000));
						System.out.println(list.get(j));
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
		System.out.println("List.size() : "+list.size());
		
	}

}
