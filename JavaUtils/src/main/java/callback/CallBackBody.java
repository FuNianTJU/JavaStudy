package callback;

/**
 * 回调接口，定义任务执行函数和回调函数
 * 
 * @author yan
 *
 */
public abstract class CallBackBody {
	
	public void onSuccess(Object context){
		System.out.println("onSuccess");
	}
	
	public void onFailure(Object context){
		System.out.println("onFailure");
	}
	
	/**
	 * 实际应用中自定义context接口来提供具体任务的执行规范
	 * @param context
	 * @throws Exception 
	 */
	public abstract void execute(Object context) throws Exception;

}
