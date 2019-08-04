package 调用机制.同步调用;

/**
 * 同步调用，程序中的方法按声明顺序执行，前面的方法执行完后才执行后面的方法
 * @author yan
 *
 */
public class Main {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		System.out.println("开始执行，调用类A,B的方法...");
		a.methodA();
		b.methodB();
		System.out.println("程序执行结束。");
	}
}
/**
 * output:
 * 开始执行，调用类A,B的方法...
 * 执行class A 的方法。
 * class A 的方法执行完成。
 * 执行 class B 的方法。
 * class B 的方法执行完成
 * 程序执行结束。
 * */

