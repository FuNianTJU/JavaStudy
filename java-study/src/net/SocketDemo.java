package net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public void init() throws UnknownHostException, IOException{
		String host = "book.zongheng.com";
		int port = 80;
		Socket socket = new Socket(host, port);
		
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	public void connect() throws IOException{
		String buff = null;
		write("GET/book/325639.html\n");
	}
	
	public void process(String msg){
		System.out.println(msg);
	}

	private void write(String string) {
		try{
			writer.write(string);
			writer.flush();
		}catch (IOException e) {
			System.err.println("Write failed:"+e.getMessage());
		}
		
	}
	
	public void destroy(){
		try{
			if(reader!=null)
				reader.close();
			if(writer!=null)
				writer.close();
			if (socket!=null) 
				socket.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		SocketDemo test = new SocketDemo();
		try{
			test.init();
			test.connect();
			
		}catch (IOException e) {
			System.err.println("Failed:"+e.getMessage());
		}finally {
			test.destroy();
		}
	}
}









