package stringstudy;

public class StringBufferDemo {
	public static void main(String args[]){
		//创建一个StringBuffer对象
		StringBuffer buffer = new StringBuffer();
		//连接字符串
		buffer.append('S');
		buffer.append("tringBuffer");
		
		System.out.println(buffer.charAt(1));
		System.out.println(buffer.capacity());
		System.out.println(buffer.indexOf("tring"));
		System.out.println("buffer="+buffer.toString());
	}
}
