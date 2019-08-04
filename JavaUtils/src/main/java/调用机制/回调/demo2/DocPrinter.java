package 调用机制.回调.demo2;

import 调用机制.回调.CallBack;

/**
 * 调用方实现回调接口
 * @author yan
 *
 */
public class DocPrinter implements CallBack {

	@Override
	public void onSuccess() {
		System.out.println("文档打印成功，请到打印室取文档。");
	}

	@Override
	public void onFailure() {
		System.out.println("文档打印失败，请重试！");
	}
	
	public void printDoc(String doc){
		AsyncTask2 printer = new AsyncTask2();
		printer.print(doc, this);
	}

}
