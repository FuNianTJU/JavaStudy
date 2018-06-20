package io;

import java.io.*;

public class IODemo {
	public static void main(String[] args) throws IOException{
		String srcString = "ABC";
		
		byte[] bytes = srcString.getBytes();
		
		InputStream inputStream = new ByteArrayInputStream(bytes);
		
		int b;
		
		while((b=inputStream.read())>=0){
			System.out.println((byte)b);
		}
		
		System.out.println();
		
		inputStream.close();
		
		Reader reader = new StringReader(srcString);
		
		int tmp;
		
		while((tmp=reader.read())>=0){
			System.out.println((char)tmp);
		}
		
		reader.close();
	}
}













