package testStatic;

/**
 * 对象初始化过程：
 * 1. 初始化static变量
 * 2. 执行static代码块
 * 3. 初始化非static变量
 * 4. 父类无参构造函数
 * 5. 子类构造函数
 * 
 * 6. 直接调用类的静态方法执行顺序是：
 *    1)初始化static变量
 *    2)执行static代码块
 *    3)执行静态方法  
 * 
 * @author yan
 *
 */
public class TestStatic {
	public static void main(String[] args){

		//ObjectCreation objectCreation1 = new ObjectCreation("object1");
		//ObjectCreation objectCreation2 = new ObjectCreation("object2");
		//ChildObjectCreation childObjectCreation1 = new ChildObjectCreation();
		//ChildObjectCreation childObjectCreation2 = new ChildObjectCreation("childObjectCreation2");
		//ChildObjectCreation.print();
		ObjectCreation.print();
		
	}
}
