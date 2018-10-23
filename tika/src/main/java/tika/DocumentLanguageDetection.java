package tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.language.*;

import org.xml.sax.SAXException;

/**
 * 语言类型检测
 * @author yan
 *
 */
public class DocumentLanguageDetection {
	public static void main(String[] args) throws IOException,SAXException,TikaException{
		File file = new File("C:/Users/yan/Desktop/test/1.txt");
		
		Parser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata =new Metadata();
		FileInputStream inputStream = new FileInputStream(file);
		ParseContext context = new ParseContext();
		
		parser.parse(inputStream, handler, metadata,context);
		LanguageIdentifier object = new LanguageIdentifier(handler.toString());
		System.out.println("Language name: "+ object.getLanguage());
		
	}
}
