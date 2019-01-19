/**
 * 验证对象初始化过程
 */
package testStatic;

/**
 * @author yan
 *
 */
public class TestClass {
	String name;
	public TestClass(String name){
		this.name = name;
		System.out.println("执行TestClass构造函数！======对象名为: " + name);
	}
	
	void makeInner(){
		System.out.println("执行TestClass类的方法！******对象名为：" + name);
	}
}
