package executor.newthread;

public class GetCPUS {
	public static void main(String [] args){
		//获得 Java 虚拟机可用处理器的数目(硬件线程数)
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
