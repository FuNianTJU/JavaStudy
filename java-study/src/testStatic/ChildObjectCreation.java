package testStatic;

public class ChildObjectCreation extends ObjectCreation{
	public ChildObjectCreation() {
		System.out.println("执行子类构造方法");
	}
	
	public ChildObjectCreation(String name) {
		//super(name);
		System.out.println("执行子类构造方法,对象名为：" + name);
	}
	
	public static void print() {
		System.out.println("执行了子类的静态方法！");
	}
}
