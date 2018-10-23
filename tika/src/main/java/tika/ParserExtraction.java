package tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

/*
 * 内容提取接口
 * 文件路径需根据实际情况配置
 */
public class ParserExtraction {
	
public static void main(final String[] args) throws IOException,SAXException, TikaException {

	   //txt文件的编码需为UTF-8
	   //File file = new File("C:/Users/lenovo/Desktop/test/灵山摘录.docx");
	   File file = new File("C:/Users/yan/Desktop/test/Test.html");
	   
	   //parse method parameters
	   Parser parser = new AutoDetectParser();
	   BodyContentHandler handler = new BodyContentHandler();
	   Metadata metadata = new Metadata();
	   FileInputStream inputstream = new FileInputStream(file);
	   ParseContext context = new ParseContext();
	   
	   //parsing the file
	   parser.parse(inputstream, handler, metadata, context);
	   inputstream.close();
	   //内容提取
	   System.err.println("内容提取  File content : \n");
	   System.out.println(handler.toString());
	   
	   System.out.println("==============元数据提取================\n");
	   //使用方法names()从其元数据对象中提取文件的所有元数据名称的列表
	   String[] metadataNames = metadata.names();
	   for(String name:metadataNames){
		   System.out.println(name + ":"+metadata.get(name));
	   }
	/*   System.out.println("\n==============添加元数据================\n");
	   metadata.add("Author", "yanxuesen");
	   System.out.println( Arrays.toString(metadata.names()));
	   //metadataNames = metadata.names();
	   System.out.println(metadata.get("Author"));
	   
	   System.out.println("\n=============设置元数据元素的值===========\n");
	   //metadata.set(Metadata.DATE, new date());
	   metadata.set(Metadata.AUTHOR, "ram ,raheem ,robin");
	   String[] metadataNamesafter = metadata.names();  
	   for(String name : metadataNamesafter) {
	       System.out.println(name + ": " + metadata.get(name));
	   }*/
   }
}












