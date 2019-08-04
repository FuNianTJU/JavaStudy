package 调用机制.回调.demo1;

import 调用机制.回调.CallBack;

public class AsyncTask implements Runnable {
	String message;
	CallBack callBack;
	
	/**
	 * 异步发送消息，根据执行情况调用回调类中的对应函数
	 * @param msg
	 * @param callBack
	 */
	public void send(String msg, CallBack callBack){
		message = msg;
		this.callBack = callBack;
		new Thread(this).start();//异步执行
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("发送消息："+message);
		} catch (InterruptedException e) {
			e.printStackTrace();
			callBack.onFailure();
		}
		callBack.onSuccess();
	}

}
