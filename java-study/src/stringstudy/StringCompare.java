package stringstudy;

public class StringCompare {
	public static void main(String args[]){
		String str1 = new String("hello");
		String str2 = "hello";
		
		System.out.println("str1==str2: "+(str1==str2));  //比较内存地址
		System.out.println("str1.equals(str2): "+str1.equals(str2)); //比较两个对象的内容
		
		String str3 = "hello";
		System.out.println("str3==str2: "+(str3==str2));
		System.out.println("str3.equals(str2): "+str3.equals(str2));
	}
	
}
