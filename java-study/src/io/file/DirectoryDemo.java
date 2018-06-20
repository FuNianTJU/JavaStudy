package io.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

import org.omg.CORBA.PUBLIC_MEMBER;

public class DirectoryDemo {
	//删除一个目录，需要先递归地删除目录下的所有文件和子目录，然后才能删除一个目录
	public static boolean deleteDir(File dir){
		if(dir.isDirectory()){
			String[] children = dir.list();
			for(int i=0;i<children.length;i++){
				boolean success = deleteDir(new File(dir,children[i]));
				if(!success){
					return false;
				}
			}
		}
		return dir.delete();
	}
	
	public static void main(String[] args){
		//得到当前目录
		String curDir = System.getProperty("user.currentDir");
		System.out.println("当前目录为："+curDir);
		File currentDir = new File(curDir);
		File newDir = new File(curDir+File.separator+"newDir");
		
		//创建一个新目录
		boolean success = newDir.mkdirs();
		if(success){
			System.out.println("currentDir created");
		}
		
		//删除目录
		success = deleteDir(newDir);
		if(success){
			System.out.println("currentDir deleted");
		}
		
		//得到目录下所有文件和子目录
		String[] children = currentDir.list();
		if(children==null){
			System.out.println("current dir is empty");
		}else{
			for(int i=0;i<children.length;i++){
				String filename = children[i];
				System.out.println("filename="+filename);
			}
		}
		
		//得到目录下后缀是".txt"的所有文件名
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return !name.endsWith(".txt");
			}
		};
		
		children = currentDir.list(filter);
		File[] files = currentDir.listFiles();
		
		//得到所有子目录
		FileFilter fileFilter = new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		files = currentDir.listFiles(fileFilter);
		
		//得到系统的根目录
		File[] roots = File.listRoots();
		for(int i=0;i<roots.length;i++){
			File root = roots[i];
			System.out.println("root="+root);
		}
	}
}



















