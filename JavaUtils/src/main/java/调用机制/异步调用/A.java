package 调用机制.异步调用;

public class A implements Runnable {

	@Override
	public void run() {
		System.out.println("methodA()执行中...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("methodA()执行完成。");
	}
	
	public void methodA(){
		System.out.println("开始执行 methodA()");
		Thread thread = new Thread(new A());
		thread.start();
	}
	
}
