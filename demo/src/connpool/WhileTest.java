package connpool;

import java.util.Calendar;
import java.util.Random;

public class WhileTest {
	public static void main(String[] args) throws InterruptedException {
		   Calendar cale = Calendar.getInstance();   
	       cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天 
	       cale.set(Calendar.HOUR_OF_DAY, 23);
	       cale.set(Calendar.MINUTE, 59);
	       
	       Calendar c = Calendar.getInstance();
	       
	       System.out.println(cale.compareTo(c));
	}
	
}
