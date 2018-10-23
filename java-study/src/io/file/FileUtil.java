package io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

/**
 * 文件操作方法测试
 * @author yan
 */

public class FileUtil {
	/**
	 * 读取文件大小
	 * @param file
	 * @return 返回文件字节数
	 * @author yan
	 */
	public static long getFileSize(File file){
		long fileSize = 0;
		try {
			FileChannel fileChannel = null;
			FileInputStream fInputStream = new FileInputStream(file);
			fileChannel = fInputStream.getChannel();
			fileSize = fileChannel.size();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return fileSize;
	}
	
	/**
	 * 判断操作系统是否是linux系统
	 * 如果是linux系统返回true,否则返回false
	 * @return
	 * @author yan
	 */
	public static Boolean isOSLinux(){
		return System.getProperty("os.name").toLowerCase().startsWith("linux");
	}
	
	/**
	 * 判断操作系统是否是Windows系统
	 * 如果是Windows系统返回true,否则返回false
	 * @return
	 * @author yan
	 */
	public static Boolean isOSWin(){
		return System.getProperty("os.name").toLowerCase().startsWith("win");
	}
	
	/**
	 * 读取文件大小
	 * @param filePath
	 * @return
	 * @author yan
	 */
	public static long readFileSize(String filePath){
		long start  = System.currentTimeMillis();
		
		Process process = null;
		BufferedReader input = null;
		String cmd = "du -bs " + filePath + " | awk '{print $1}'";
		System.out.println("运行命令：" + cmd);

//		StringBuilder command = new StringBuilder("du -bs ");
//		command.append(filePath).append(" | awk '{print $1}'");
//		String cmd = command.toString();
		
		try {
			process = Runtime.getRuntime().exec(new String[] { "sh", "-c", cmd });
			process.waitFor();
			input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			if (null != input) {
				line = input.readLine();
			}
			// 获取到输出信息
			if (line != null) {
				sb.append(line);
				while ((line = input.readLine()) != null) {
					sb.append(line);
				}
			} else {
				// 获取错误输出
				input = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				while ((line = input.readLine()) != null) {
					sb.append(line);
				}
			}
			String response = sb.toString();
			System.out.println("命令响应：" + response);
			
			long end  = System.currentTimeMillis();
			System.out.println("执行时间为：" + (end-start));
			
			return Long.parseLong(response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("命令执行出现异常：" + cmd);
			return 0;
		} finally {
			if (null != input) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println("关闭BufferedReader是出现异常");
				}
			}
			if (process != null) {
				process.destroy();
			}
		}
	}
	
	public static void main(String [] args){
		long fileSize = readFileSize("/data/arrow/gtpBatchReceive/APP000000385_cdm_019_4dbd5dd2c2b64c35900eaed065340019_20171218");
		System.out.println("fileSize:" + fileSize);
	}
	
}
















