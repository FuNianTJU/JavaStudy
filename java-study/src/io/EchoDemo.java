package io;

public class EchoDemo {
	public static void main(String[] args) throws java.io.IOException{
		int ch;
		System.out.println("Enter some text:");
		
		while((ch = System.in.read())!='\n'){
			System.out.println((char)ch);
		}
	}
}
