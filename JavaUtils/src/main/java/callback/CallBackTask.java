package callback;

/**
 * 定义了一个CallBackTask，做为外层的面子工程，其主要工作为start 开始一个异步操作，
 * 然而真正干活的是CallBackBody，它里面的execute才是真正要处理的事情，如果成功，
 * 则触发onSucess，否则触发onFailure。
 * @author yan
 *
 */
public class CallBackTask {
	private CallBackBody body;
	
	public CallBackTask(CallBackBody body){
		this.body = body;
	}
	
	public void start(final Object context){
		final Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					body.execute(context);//出发任务
				} catch (Exception e) {
					e.printStackTrace();
					body.onFailure(context);//失败回调
				}
				body.onSuccess(context);//成功回调
			}
		});
		t.start();
	}
}
