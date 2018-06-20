package io.file;

import java.io.File;
import java.io.IOException;
/**
 * 对文件名进行操作
 * @author yan
 *
 */
public class FileNameDemo {
	public static void main(String[] args){
		//通过相对路径创建一个File对象
		String path = File.separator+"a"+File.separator+"b";
		File file = new File(path);
		
		//得到绝对路径
		String absolutePath = file.getAbsolutePath();
		System.out.println("absolutePath="+absolutePath);
		
		//比较两个File对象指代是否一致
		File otherFile = new File(absolutePath);
		try{
			String canonicalPath1 = file.getCanonicalPath();
			String canonicalPath2 = otherFile.getCanonicalPath();
			System.out.println(canonicalPath1.equals(canonicalPath2));
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		//得到上一级路径
		String parentPath = file.getParent();
		System.out.println("parentPath="+parentPath);
		
		//判断file对象是否是目录
		System.out.println(file.isDirectory());
	}
}















