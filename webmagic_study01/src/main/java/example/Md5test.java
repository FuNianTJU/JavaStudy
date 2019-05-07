package example;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5test {
	public static void main(String [] args) {
		String str = "http://www.runoob.com/";
		String str2 = "http://www.runoob.com";
		String s1 = DigestUtils.md5Hex(str);
		String s2 = DigestUtils.md5Hex(str2);
		System.out.println(s1.equals(s2));
	}
}
