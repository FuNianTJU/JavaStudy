package tika;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

/*
 * 内容提取
 */
public class TikaExtraction {
	public static void main(String[] args) throws IOException, TikaException{
		File file = new File("C:/Users/yan/Desktop/test/test.txt");
		Tika tika = new Tika();
		String filecontent = tika.parseToString(file);
		System.out.println("提取的内容为：\n"+ filecontent);
	}
}
