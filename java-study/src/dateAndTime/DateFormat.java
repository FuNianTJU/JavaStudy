package dateAndTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
	public static void main(String[] args){
		
		//通过Date类来获取当前时间
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		System.out.println(df.format(day));    
		
		//通过System类中的currentTimeMillis方法来获取当前时间 
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(System.currentTimeMillis()));
		
		//通过Calendar类来获取当前时间
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改   
		int year = c.get(Calendar.YEAR);  
		int month = c.get(Calendar.MONTH);   
		int date = c.get(Calendar.DATE);    
		int hour = c.get(Calendar.HOUR_OF_DAY);   
		int minute = c.get(Calendar.MINUTE);   
		int second = c.get(Calendar.SECOND);    
		System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second);    
		
		//通过Date类来获取当前时间 
		Date date2 = new Date();    
		String year2 = String.format("%tY", date2);   
		String month2 = String.format("%tB", date2);   
		String day2 = String.format("%te", date2);    
		System.out.println("今天是："+year2+"-"+month2+"-"+day2); 
		
	}
}
