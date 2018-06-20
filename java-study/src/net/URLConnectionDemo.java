package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionDemo {
	public static void main(String[] args){
		int c;
		String urlStr = "http://www.aileleba.com/145219/zhangjie38976498.shtml";
		URL hp = null;
		try {
			hp = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("Invalid format of URL:"+hp+","+e.getMessage());
		}
		
		URLConnection hpCon = null;
		try {
			hpCon = hp.openConnection();
		} catch (IOException e) {
			System.err.println("Can't get conection from URL:"+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Date:"+new Date(hpCon.getDate()));
		System.out.println("Content-Type:"+hpCon.getContentType());
		System.out.println("Expires:"+hpCon.getExpiration());
		System.out.println("Last-Modified:"+new Date(hpCon.getLastModified()));
		
		int len = hpCon.getContentLength();
		System.out.println("Content-Length:"+len);
		
		if(len>0){
			System.out.println("========Content========");
			
			try {
				InputStream input = hpCon.getInputStream();
				int i = len;
				while(((c=input.read())!=-1)&&(--i>0)){
					System.out.println((char)c);
				}
				input.close();
			} catch (IOException e) {
				System.err.println("I/O failed:"+e.getMessage());
			}
			
		}else {
			System.out.println("No Content Available");
		}
		
	}
}



















