package io;

import java.util.Scanner;

public class ScannerDemo {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		//从键盘接收数据
		
		//next();
		//nextLine();
		//nextNum();
		sum();
		
		scan.close();
	}
	public static void next(){
		//next方式接收字符串
		System.out.println("next方式接收：");
		//判断是否还有输入
		if(scan.hasNext()){
			String str1 = scan.next();
			System.out.println("输入的数据为："+str1);
		}
	}
	
	public static void nextLine() {
		//nextLine方式接收字符串
		System.out.println("nextLine方式接收：");
		//判断是否还有输入
		if(scan.hasNextLine()){
			String str2 = scan.nextLine();
			System.out.println("输入的数据为："+str2);
		}
	}
	
	public static void nextNum() {
		int i = 0;
		float f = 0.0f;
		System.out.println("输入整数：");
		if(scan.hasNextInt()){
			i = scan.nextInt();
			System.out.println("整数数据："+i);
		}else {
			System.out.println("输入的不是整数！");
		}
		
		System.out.println("输入小数：");
		if(scan.hasNextFloat()){
			f = scan.nextFloat();
			System.out.println("小数数据："+f);
		}else {
			System.out.println("输入的不是小数！");
		}
	}
	
	public static void sum(){
		double sum = 0;
		int m = 0;
		
		while(scan.hasNextDouble()){
			double tmp = scan.nextDouble();
			m=m+1;
			sum = sum+tmp;
		}
		
		System.out.println(m+"个数的和为"+sum);
		System.out.println(m+"个数的平均值是"+(sum/m));
	}
}
















