package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorDemo {
	public static void main(String args[]) {
		
		Set set = new HashSet<String>();
		
		//添加新元素
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		
		//添加基本数据类型
		set.add(new Integer(1));
		set.add(new Double(7.0));
		
		//得到集合的迭代器
		Iterator iterator = set.iterator();
		
		//遍历集合中所有元素
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			iterator.remove();
		}
		
		System.out.println("set="+set);
	}
}
