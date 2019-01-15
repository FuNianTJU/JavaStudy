package _异常_;

/**
 * 重新抛出异常
 * @author yan
 *
 */
public class Rethrowing {
	//模拟dao层异常
	public static void dao() throws Exception {
		System.out.println("originating the exception in dao()");
		throw new Exception("thrown from dao()");
	}
	
	//模拟service层
	public static void service() throws Exception {
		try {
			dao();
		} catch (Exception e) {
			System.out.println("Exception inside service(), Caused by: ");
			e.printStackTrace();
			throw e;//此异常对象是原始异常对象，持有全部站轨迹信息
		}
	}
	
	//模拟Controller层
	public static void controller() throws Exception{
		try {
			service();
		} catch (Exception e) {
			System.out.println("Exception inside controller(), Caused by: ");
			e.printStackTrace();
			//更新调用栈信息，抛出的异常对象中包含的是重新抛出点的信息，有关原来异常发生点的信息会丢失。
			//会丢失原异常抛出点到当前抛出点的栈轨迹
			//throw (Exception)e.fillInStackTrace();
			
			//以此异常为cause构造新的异常并抛出，可通过这个异常链追踪到异常最初发生的位置
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		try {
			service();
		} catch (Exception e) {
			System.err.println("Exception1:");
			e.printStackTrace();
		}
		
		try {
			controller();
		} catch (Exception e) {
			System.err.println("Exception2:");
			e.printStackTrace();
		}
	}
	
}
























