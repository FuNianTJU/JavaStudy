package stringstudy;

public class StringDemo {
	public static void main(String args[]){
		//两种赋值方式
		String s1 = "String test";
		String s2 = new String("String test ");
		
		//获取字符串长度
		int stringLength = s1.length();
		System.out.println("length of s1 is:" + stringLength);
		
		//检查字符串前缀和后缀
		boolean startTest = s1.startsWith("Str");
		boolean endTest = s1.endsWith("est");
		System.out.println("startTest = "+startTest);
		System.out.println("endTest = "+endTest);
		
		//查询特定字符位置
		System.out.println("空格字符位置为：" + s1.indexOf(' '));
		System.out.println("子串索引为：" + s1.indexOf("test"));
		
		//得到特定位置的字符
		char singleChar = s1.charAt(0);
		System.out.println("字符串的第一个字符是："+singleChar);
		
		//取子串
		System.out.println("subString=" + s1.substring(0, 5));
		
		//除去字符串两端的空白
		String trimString = s2.trim();
		System.out.println(trimString);
		
	}
}
