package net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws MalformedURLException{
		URL hp = new URL("http://www.google.com/");
		System.out.println("Protocol:"+hp.getProtocol());
		System.out.println("Port:"+hp.getPort());
		System.out.println("Host:"+hp.getHost());
		System.out.println("File:"+hp.getFile());
		System.out.println("Ext:"+hp.toExternalForm());
	}
}
