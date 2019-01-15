package _并发_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Test;

/**
	1）Vector、Stack、HashTable
	
	2）Collections类中提供的静态工厂方法创建的类
	
	Vector实现了List接口，Vector实际上就是一个数组，和ArrayList类似，但是Vector中的方法都是synchronized方法，即进行了同步措施。
	
	Stack也是一个同步容器，它的方法也用synchronized进行了同步，它实际上是继承于Vector类。
	
	HashTable实现了Map接口，它和HashMap很相似，但是HashTable进行了同步处理，而HashMap没有。
*/
public class SynchronizedContainer {
	
	@Test
	public void tetsVector(){
		Vector<String> vector = new Vector<String>();
	}
	
	@Test
	public void testStack(){
		Stack<String> stack = new Stack<String>();
	}
	
	@Test
	public void testHashTable(){
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
	}
	
	@Test
	public void testCollections(){
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
		Set<String> set = Collections.synchronizedSet(new HashSet<String>());
		SortedMap<String, String> sortedMap = Collections.synchronizedSortedMap(new TreeMap<String, String>());
		SortedSet<String> sortedSet = Collections.synchronizedSortedSet(new TreeSet<String>());
	}
	
}























