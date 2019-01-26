package stringstudy;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class StringTest {
	
	/**
	 * 将此 String 编码为 byte 序列
	 */
	@Test
	public void testGetByte(){
		String strByte = "又是一个愉快的周末！";
		
		byte[] b1 = strByte.getBytes();
		byte[] b2 = null;
		try {
			b2 = strByte.getBytes("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//byte类型没有重写toString()方法,序列化输出是使用的Object对象的默认toString()结果
		System.out.println("字符串strByte的二进制编码是：" + b1.toString());
		System.out.println("字符串strByte的二进制编码是：" + b2.toString());
		
		System.out.println("b1和b2是否相等：" + b1.equals(b2));
		
		//比较两个byte数组的内容
		for(byte b : b1){
			System.out.println(b);
		}
		System.err.println("=====================");
		for(byte b : b2){
			System.out.println(b);
		}
	}
}
















