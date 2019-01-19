package testStatic;

public class ObjectCreation {
	TestClass testClass1 = new TestClass("filedValue");
	static TestClass testClass2 = new TestClass("static value");
	
	static{
		testClass2.makeInner();
	}
	
	public ObjectCreation(){
		System.out.println("ObjectCreation init");
	}
	
	public ObjectCreation(String name){
		System.out.println("ObjectCreation " + name + " init");
	}
	
	public static void print() {
		System.out.println("执行了父类的静态方法！");
	}
}
