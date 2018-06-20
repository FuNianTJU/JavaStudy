package io.file;

import java.io.*;

public class TxtFileDemo {
	public static void main(String[] args){
		Writer writer = null;
		try{
			writer = new FileWriter("C:\\Users\\yan\\Desktop\\test\\2.txt");
			writer.write("line 1\n");
			writer.write("line 2\n");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		Reader reader = null;
		try{
			reader = new FileReader("C:\\Users\\yan\\Desktop\\test\\2.txt");
			char[] buffer = new char[1024];
			int offset;
			while((offset=reader.read(buffer))>0){
				System.out.println(offset);
				System.out.println(new String(buffer,0,offset));
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		}
	}
}
