package io.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args){
		RandomAccessFile randomAccessFile=null;
		try{
			randomAccessFile = new RandomAccessFile("C:\\Users\\yan\\Desktop\\test\\2.txt", "rw");
			randomAccessFile.writeInt(100);
			randomAccessFile.writeChar('a');
			randomAccessFile.seek(4);
			char charData = randomAccessFile.readChar();
			System.out.println("charData="+charData);
			randomAccessFile.writeUTF("马上又要高考了，祝各位一战成功！");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				randomAccessFile.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
