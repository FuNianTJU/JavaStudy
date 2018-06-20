package dateAndTime;

import java.util.Date;

public class DateTest {
	public static void main(String[] args){
		Date currentDate = new Date();
		System.out.println("currentDate="+currentDate);
		
		Date newDate = new Date(100000);
		
		System.out.println("newDate = "+newDate);
		
		System.out.println(currentDate.after(newDate));
		System.out.println(currentDate.before(newDate));
		
		System.out.println("MS since 1970-1-1:"+currentDate.getTime());
	}
}
