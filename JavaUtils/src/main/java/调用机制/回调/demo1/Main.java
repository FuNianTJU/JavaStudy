package 调用机制.回调.demo1;

public class Main {
	public static void main(String[] args) {
		AsyncTask sender = new AsyncTask();
		sender.send("朋友，新年好！", new MsgSendCallback());
	}
}
