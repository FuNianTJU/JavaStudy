
package dateAndTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	
	private static void doCalendarTimeExample() {
		System.out.println("CURRENT DATE/TIME");
		System.out.println("=================");
		Date now = Calendar.getInstance().getTime(); //从历元至现在的毫秒偏移量
		System.out.println("Calendar.getInstance().getTime():"+now);
	}
	
	private static void doAdd() {
		System.out.println("add/subtract calender/dates");
		System.out.println("=================");
		
		//get today's date
		Calendar now = Calendar.getInstance();
		Calendar working;
		SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		
		working = (Calendar)now.clone();
		working.add(Calendar.DAY_OF_YEAR, -(365*2));
		System.out.println("Two years ago it was:"+formatter.format(working.getTime()));
	}
	
	private static void doDateDifference() {
		System.out.println("difference between two dates");
		System.out.println("=================");
		Date startDate1 = new GregorianCalendar(1994,02,14,14,00).getTime();
		Date enDate1 = new Date();
		
		long diff = enDate1.getTime() - startDate1.getTime();
		
		System.out.println("difference between "+enDate1);
		System.out.println(" and "+startDate1+" is "+(diff/(1000L*60L*60L*24L))+" days.");
	}
	
	private static void doGetMethods() {
		System.out.println("calendar get methods");
		System.out.println("====================");
		Calendar c = Calendar.getInstance();
		
		System.out.println("YEAR: "+c.get(Calendar.YEAR));
		System.out.println("MONTH: "+c.get(Calendar.MONTH));
		System.out.println("DAY_OF_MONTH: "+c.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_WEEK: "+c.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_WEEK: "+c.get(Calendar.DAY_OF_YEAR));
		System.out.println("WEEK_OF_YEAR: "+c.get(Calendar.WEEK_OF_YEAR));
		System.out.println("WEEK_OF_MONTH: "+c.get(Calendar.WEEK_OF_MONTH));
		System.out.println("DAY_OF_WEEK_IN_MONTH: "+c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("HOUR: "+c.get(Calendar.HOUR));
		System.out.println("AM_PM: "+c.get(Calendar.AM_PM));
		System.out.println("HOUR_OF_DAY(24-hour): "+c.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE: "+c.get(Calendar.MINUTE));
		System.out.println("SECOND: "+c.get(Calendar.SECOND));
	}
	
	public static void main(String[] args){
		doCalendarTimeExample();
		doAdd();
		doDateDifference();
		doGetMethods();
	}
}






















