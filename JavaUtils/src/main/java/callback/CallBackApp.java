package callback;

/**
 * 异步回调示例
 * CallBackApp做为最终的运行舞台，这里面还得单独跑一个线程，来启动CallBackTask，这样才不会阻塞后面的处理。
 * @author yan
 *
 */
public class CallBackApp {
	public static void main(String[] args) {
		System.out.println("准备开始执行异步任务...");
		
		Object context = "一个比较耗时的异步任务";
		
		new CallBackTask(new CallBackBody() {
			
			@Override
			public void execute(Object context) throws InterruptedException {
				System.out.println("异步任务信息："+context);
				System.out.println("\n正在执行耗时操作...");
				Thread.sleep(5000);
				System.out.println("异步任务执行完成！");
			}
			
			public void onSuccess(Object context) {
				System.out.println("\n成功后的回调函数...");
                //System.out.println(context);
			}
			
			public void onFailure(Object context){
				System.out.println("\n失败后的回调函数...");
                //System.out.println(context);
			}
			
		}).start(context);
		
		System.out.println("异步任务已经开始,请等待完成...");
		System.out.println("=============分割线============\n");
	}

}
