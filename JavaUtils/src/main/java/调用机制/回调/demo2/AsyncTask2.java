package 调用机制.回调.demo2;

import 调用机制.回调.CallBack;

public class AsyncTask2 implements Runnable {
	String doc;
	CallBack callBack;

	public void print(String msg, CallBack callBack){
		doc = msg;
		this.callBack = callBack;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("打印文档："+doc);
		} catch (InterruptedException e) {
			e.printStackTrace();
			callBack.onFailure();
		}
		callBack.onSuccess();
	}

}
