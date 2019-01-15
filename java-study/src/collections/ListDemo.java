package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
	public static void main(String[] args){
		List list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		list.add(new Double(7.0));
		
		list.add("4");
		
		System.out.println("list="+list);
		
		ListIterator iterator=list.listIterator();
		
		//顺序列举
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//逆序列举
		while(iterator.hasPrevious()){
			System.out.println(iterator.previous());
		}
	}
}
