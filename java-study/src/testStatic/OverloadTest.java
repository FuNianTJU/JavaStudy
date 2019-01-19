
package testStatic;

/**
 * 测试函数重载
 * @author yan
 *
 */
public class OverloadTest {
	public static void main(String[] args){
		String name = "leilei";
		int age = 19;
		say(age, name);
		say(name, age);
	}
	
	public static void say(int age, String name){
		System.out.printf("your age is %d; %s\n", age, name);
	}
	public static void say(String name, int age){
		System.out.printf("%s, your age is %d.", name, age);
	}
}
