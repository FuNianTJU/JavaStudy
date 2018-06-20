package io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedIODemo {
	public static void main(String[] args){
		//向文件写入字符
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter("C:\\Users\\yan\\Desktop\\test\\2.txt"));
			writer.write("line 1");
			writer.newLine();
			writer.write("line 2");
			writer.newLine();
			writer.write("yan xue sen");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		
		//从文件读取内容
		BufferedReader reader=null;
		try{
			reader = new BufferedReader(new FileReader("C:\\Users\\yan\\Desktop\\test\\2.txt"));
			String buf;
			while((buf=reader.readLine())!=null){
				System.out.println(buf);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
