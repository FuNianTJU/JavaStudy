package io.file;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataWriteDemo {
	public static void main(String[]args){
		DataOutputStream dataOutput =null;
		try{
			dataOutput = new DataOutputStream(new FileOutputStream("C:\\Users\\yan\\Desktop\\test\\1.txt"));
			dataOutput.writeInt(1);
			dataOutput.writeBoolean(true);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dataOutput!=null){
				try{
					dataOutput.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
