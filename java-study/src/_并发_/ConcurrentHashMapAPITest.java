package _并发_;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Test;

public class ConcurrentHashMapAPITest {
	ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String,String>();
	
	@Before
	public void init(){
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("3", "value3");
		map.put("4", "value4");
		map.put("5", "value5");
		map.put("6", "value6");
	}
	
	@Test
	public void testClear(){
		System.out.println("map.size() : "+map.size());
		map.clear(); //移除所有映射关系
		System.out.println("map.size() : "+map.size());
	}
	
	@Test
	public void testContains(){
		//测试是否存在value为指定值的映射
		String testValue1 = "value0";
		String testValue2 = "value1";
		System.out.println(map.containsValue(testValue1));
		System.out.println(map.containsValue(testValue2));
		System.out.println(map.contains(testValue2));
		
		//测试对象key是否为表中的键
		String key1 = "1";
		String key2 = "9";
		System.out.println(map.containsKey(key1));
		System.out.println(map.containsKey(key2));
	}
	
	@Test
	public void testElements(){
		//返回映射中值得枚举
		Enumeration<String> enums = map.elements();
		while(enums.hasMoreElements()){
			System.out.println(enums.nextElement());
		}
		
	}
	
	@Test
	public void testEntrySet(){
		//返回此映射所包含的映射关系的Set视图
		Set<Map.Entry<String, String>> set = map.entrySet();
		Iterator<Map.Entry<String, String>> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	@Test
	public void testGet(){
		System.out.println(map.get("1")); //返回键对应的映射值
		System.out.println(map.get("0")); //不存在该映射关系则返回null
	}
	
	@Test
	public void testIsEmpty(){
		System.out.println(map.isEmpty()); //判断map是否不包含K-V映射关系
		map.clear();
		System.out.println(map.isEmpty());
	}
	
	@Test
	public void testKeys(){
		//返回映射中key的枚举
		Enumeration<String> enums = map.keys();
		while(enums.hasMoreElements()){
			System.out.println(enums.nextElement());
		}
	}
	
	@Test
	public void testKeySet(){
		//返回此映射所包含的键的set视图
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	@Test
	public void testPut(){
		//将指定键映射到此表中的指定值。键和值都不可以为 null。
		//return 以前与 key 相关联的值，如果 key 没有映射关系，则返回 null 
		//throw NullPointerException - 如果指定键或值为 null
		System.out.println(map.put("newKey", "newValue"));
		System.out.println(map.put("1", "newValue1"));
		try {
			System.out.println(map.put("7", null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPutAll(){
		System.out.println(map.toString());
		Map<String, String> map2 = new HashMap<String,String>();
		map2.put("1", "newValue1");
		map2.put("newkey", "newValue");
		map.putAll(map2); //将指定映射中所有映射关系复制到此映射中。
		System.out.println(map.toString());
	}
	
	/*如果指定键已经不再与某个值相关联，则将它与给定值关联。这等价于： 
	   if (!map.containsKey(key)) 
	      return map.put(key, value);
	  else
	       return map.get(key);
	       除了原子地执行此操作之外。*/
	@Test
	public void testPutIfAbsent(){
		System.out.println(map.putIfAbsent("1", "2"));
		System.out.println(map.putIfAbsent("7", "2"));
	}
	
	@Test
	public void testRemove(){
		System.out.println(map.remove("1"));//从此映射中移除键（及其相应的值）。
		System.out.println(map);
	}
	
	@Test
	public void testReoveKV(){
		//只有目前将键的条目映射到给定值时，才移除该键的条目。
		System.out.println(map.remove("1","value1"));
		System.out.println(map.remove("2","value10"));
	}
	
	@Test
	public void testReplace(){
//		只有目前将键的条目映射到某一值时，才替换该键的条目。这等效于： 
//		   if (map.containsKey(key)) {
//		       return map.put(key, value);
//		   } else return null;不同之处在于该操作是以原子方式执行的。 
		System.out.println(map.replace("1","value11"));
	}
	
	@Test
	public void testReplaceKV(){
//		只有目前将键的条目映射到给定值时，才替换该键的条目。这等效于： 
//		   if (map.containsKey(key) && map.get(key).equals(oldValue)) {
//		       map.put(key, newValue);
//		       return true;
//		   } else return false;不同之处在于该操作是以原子方式执行的。
		System.out.println(map.replace("1","value1","newValue"));
	}
	
	@Test
	public void testSize(){
		//返回此映射中的键-值映射关系数。
		System.out.println(map.size());
	}
	
	@Test
	public void testValues(){
		//返回此映射中包含的值的 Collection 视图。
		Collection<String> list = map.values();
		System.out.println(list);
	}
}
























