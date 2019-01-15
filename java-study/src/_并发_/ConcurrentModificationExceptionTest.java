package _并发_;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationExceptionTest {
	static final ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args)  {
        //ArrayList<Integer> list = new ArrayList<Integer>();
		list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2){
            	iterator.remove();   //在迭代器中如果要删除元素的话，需要调用Itr类的remove方法
            	//list.remove(integer); //会抛出ConcurrentModificationException异常
            }
        }
    }
	
	/**
	 * 通过Iterator访问的情况下，每个线程里面返回的是不同的iterator
	 */
	@org.junit.Test
	public void testThreads(){
		list.clear();
		list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //遍历list
        Thread thread1 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();//会抛出ConcurrentModificationException
                    System.out.println(integer);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        };
        //修改list
        Thread thread2 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    if(integer==2)
                        iterator.remove(); 
                }
            };
        };
        thread1.start();
        thread2.start();
	}
}
