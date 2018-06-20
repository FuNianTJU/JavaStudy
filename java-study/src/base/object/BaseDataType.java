package base.object;

public class BaseDataType {
	public static void main(String args[]){
		//创建Integer对象
		Integer i = new Integer(256);
		Integer j = new Integer("256");
		
		System.out.println(i.intValue()); //转换为int型
		System.out.println(i.doubleValue()); //转换为浮点型数据
		System.out.println("i= "+i.toString()); //转换为字符串
		System.out.println(i==j);
		System.out.println(i.compareTo(j));
		
		System.out.println(Integer.parseInt("100")*2); //将字符串转化为整型数据
		System.out.println("100*2="+Integer.toString(100*2));
		
		int k;
		k = Integer.valueOf("1010",2).intValue(); //valueOf() 字符串转Integer对象
		System.out.println(k);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
	}
}
