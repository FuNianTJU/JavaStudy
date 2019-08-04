package 调用机制.回调.demo1;

import 调用机制.回调.CallBack;

/**
 * 单独编写回调类
 * @author yan
 *
 */
public class MsgSendCallback implements CallBack {

	@Override
	public void onSuccess() {
		System.out.println("消息发送成功。");
		
	}

	@Override
	public void onFailure() {
		System.out.println("消息发送失败，请重试。");
		
	}

}
