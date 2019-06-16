package io;

/**
 * 标准输出流与错误输出流混用会造成输出乱序
 * 标准输出流先缓存后输出，错误输出流不缓存，直接输出
 * @author yan
 *
 */
public class TestSystemOut {    
	public static void main(String[] args) {
	    System.out.println("start...");
	    System.err.println("middle...");
	    System.out.println("end...");
	}
}
