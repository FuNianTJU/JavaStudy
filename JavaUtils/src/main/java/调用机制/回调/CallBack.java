package 调用机制.回调;

/**
 * 定义回调接口
 * @author yan
 *
 */
public interface CallBack {
	/**
	 * 异步请求执行成功后调用此方法
	 */
	public void onSuccess();
	/**
	 * 异步请求执行失败后调用此方法
	 */
	public void onFailure();
}
