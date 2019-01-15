package _异常_;

/**
 * 栈轨迹示例
 * 显示方法调用顺序
 * @author yan
 *
 */
public class WhoCalled {
	static void f(){
		try {
			throw new Exception();
		} catch (Exception e) {
			for(StackTraceElement ste: e.getStackTrace()){
				System.err.println(ste.getMethodName());
			}
		}
	}
	static void g(){
		f();
	}
	static void h(){
		g();
	}
	
	public static void main(String[] args){
		f();
		System.out.println("---------------------------------");
		g();
		System.out.println("---------------------------------");
		h();
	}

}
