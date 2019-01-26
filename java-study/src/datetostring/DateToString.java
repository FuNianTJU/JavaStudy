package datetostring;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转String类型
 * @author yan
 *
 */
public class DateToString {
	public static void main(String [] args){
		//SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMdd" );
		String str = sdf.format(new Date());
		System.out.println(str);
		System.out.println(new Date());
	}
}
