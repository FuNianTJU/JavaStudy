package io;

import java.io.*;

//使用BufferedReader在控制台读取字符串
public class BRReadLines {
	public static void main(String[] args) throws IOException{
		BufferedReader bReader = new BufferedReader(
				new InputStreamReader(System.in));
		String str;
		System.out.println("Enter lines of text.");
		System.out.println("Enter 'end' to quit.");
		
		do{
			str = bReader.readLine();
			System.out.println(str);
		}while(!str.equals("end"));
	}
}
