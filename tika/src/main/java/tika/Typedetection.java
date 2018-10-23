package tika;

import java.io.File;

import org.apache.tika.Tika;

/**
 * 文档类型检测
 * @author yan
 *
 */
public class Typedetection {
	 public static void main(String[] args) throws Exception {

	      //assume example.mp3 is in your current directory
	      File filePath = new File("C:/Users/yan/Desktop/test/");//
	      
	      //Instantiating tika facade class 
	      Tika tika = new Tika();
	      
	      //detecting the file type using detect method
	      /*String filetype = tika.detect(file);
	      System.out.println(filetype);*/
	      
	      File[] files = filePath.listFiles();
	      for(File file : files){
	    	  String fileType = tika.detect(file);
	    	  System.out.println(file+" 文件类型为："+fileType+'\n');
	      }
	      
	   }
}

























