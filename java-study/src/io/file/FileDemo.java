package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args){
		//String path = "D:"+File.separatorChar+"a"+File.separatorChar+"b";
		String path = "D:\\b";
		System.out.println(path);
		File file = new File(path);
		
		//检查文件是否存在
		if(file.exists()){
			System.out.println("file exists");
		}else{
			System.out.println("file not exists");
		}
		
		boolean success;
		
		//创建新文件
		try {
			success = file.createNewFile();
			if(success){
				System.out.println("file created");
			}else {
				System.out.println("file already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//得到文件的大小
		long fileLength = file.length();
		System.out.println("fileLength="+fileLength);
		
		//删除文件
		/*success = file.delete();
		if(success){
			System.out.println("file deleted");
		}else {
			System.out.println("file delete failed");
		}*/
		
		//文件重命名
		success = file.renameTo(new File("destFile"));
		if(success){
			System.out.println("file renamed");
		}else {
			System.out.println("file rename failed");
		}
		
		//得到文件上次修改的时间
		long lastModifiedTime = file.lastModified();
		System.out.println("lastModifiedTime=" + new Date(lastModifiedTime));
	}
}
















