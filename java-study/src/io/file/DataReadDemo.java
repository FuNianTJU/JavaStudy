package io.file;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataReadDemo {
	public static void main(String[]args){
		DataInputStream dataInput =null;
		try{
			dataInput = new DataInputStream(new FileInputStream("C:\\Users\\yan\\Desktop\\test\\1.txt"));
			int intData = dataInput.readInt();
			boolean boolData = dataInput.readBoolean();
			System.out.println("intData = "+intData);
			System.out.println("boolData = "+boolData);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dataInput!=null){
				try{
					dataInput.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
