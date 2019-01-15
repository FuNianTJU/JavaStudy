package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String [] args){
		Map map = new HashMap<String,String>();
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("3", "value3");
		map.put("4", "value4");
		map.put("1", "value5");
		
		System.out.println(map.get("1"));
		
		//列举所有关键字
		Set keSet = map.keySet();
		for(Iterator iterator=keSet.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
		
		//列举所有的值
		Collection values = map.values();
		for(Iterator iterator=values.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
		
		Set entrySet = map.entrySet();
		for(Iterator iterator=entrySet.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
	}
}
