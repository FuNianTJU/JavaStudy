package 调用机制.异步调用;

/**
 * asynchronous call（异步调用），一个可以无需等待被调用函数的返回值就让操作继续进行的方法
 * 异步调用通常采用多线程来实现。
 * @author yan
 *
 */
public class Main {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		System.out.println("===========分割线1===========");
		//methodA()是异步调用，通知methodA()执行后，继续执行后续指令，不等待methodA()执行完成
		a.methodA();
		System.out.println("===========分割线2===========");
		b.methodB();
		System.out.println("===========分割线3===========");
		System.out.println("main()函数执行结束。\n");
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

