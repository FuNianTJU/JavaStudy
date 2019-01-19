package testStatic;

public class BytesTest {
	public static void main(String[] args){
		// byte  
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);  
        System.out.println("包装类：java.lang.Byte");  
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);  
        System.out.println();
        
        byte a = 100;
        System.out.println("a: "+a);
        
        String string = "yu nan";
        byte[] byteOfStr = string.getBytes();
        System.out.println(byteOfStr);
        for(byte b:byteOfStr){
        	System.out.println(b);
        }
	}
	
	
}
