package collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String args[]){
		//创建对象
		Set set = new HashSet<>();
		
		//添加新元素
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		
		//添加基本数据类型
		set.add(new Integer(1));
		set.add(new Double(7.0));
		
		//添加重复元素
		set.add("3");
		//输出set中的内容
		System.out.println("set="+set.toString());
	}
}
