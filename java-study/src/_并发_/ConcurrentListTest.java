package _并发_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

public class ConcurrentListTest {
	
	@Test
	public void testSychrnizedList(){
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		list.add("1");
		Vector<String> vector = new Vector<String>();
		vector.add("2");
		System.out.println(vector.get(0));
		
	}
	
	@Test
	public void testCopyOnWriteList(){
		CopyOnWriteArrayList<Cat> list = new CopyOnWriteArrayList<Cat>();
		list.add(new Cat("黑猫"));
		list.add(new Cat("白猫"));
		
		System.out.println(list);
	}

}

class Cat{
	String name;
	public Cat(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
	
}
