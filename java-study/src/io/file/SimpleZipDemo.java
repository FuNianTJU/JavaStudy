package io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class SimpleZipDemo {
	public static void main(String[] args) throws IOException{
		FileOutputStream f = new FileOutputStream("C:\\Users\\yan\\Desktop\\test\\test.zip");
		CheckedOutputStream  csum = new CheckedOutputStream(f, new Adler32());
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(csum));
		
		//设置Zip文件的注释说明信息
		out.setComment("A test of Java Zipping");
		
		for(int i=0;i<args.length;i++){
			System.out.println("Writing file"+args[i]);
			BufferedReader in = new BufferedReader(new FileReader(args[i]));
			out.putNextEntry(new ZipEntry(args[i]));
			int c;
			while((c=in.read())!=-1)
				out.close();
			in.close();
		}
		out.close();
		
		//必须close以后才能计算校验和
		System.out.println("Checksum:"+csum.getChecksum().getValue());
		
		//解压缩
		System.out.println("解压缩");
		FileInputStream fi = new FileInputStream("C:\\Users\\yan\\Desktop\\test\\test.zip");
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		ZipInputStream in2 = new ZipInputStream(new BufferedInputStream(csumi));
		ZipEntry ze;
		while((ze=in2.getNextEntry())!=null){
			System.out.println("Reading file"+ze);
			int x;
			while((x=in2.read())!=-1){
				System.out.write(x);
			}
		}
		System.out.println("Checksum:"+csumi.getChecksum().getValue());
		in2.close();
		
		//解压缩的另外一种形式
		ZipFile zf = new ZipFile("C:\\Users\\yan\\Desktop\\test\\test.zip");
		Enumeration e = zf.entries();
		while(e.hasMoreElements()){
			ZipEntry ze2 = (ZipEntry)e.nextElement();
			System.out.println("File:"+ze2);
		}
		
	}
}
















