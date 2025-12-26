package crm_generic_WebdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used to return random no from 0 to 2000
	 * @return Random Number
	 */
	public int getRandomNumber() {
		Random r=new Random();
		int ranNum = r.nextInt(2000);
		return ranNum;
	}
	/**
	 * This method is used to return current date 
	 * @return date
	 */
	public String getSystemDate() {
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(d);
		return date;
	}
	
		
	
	/**
	 * This method is used to return Required date (befor or after) by providing +-day
	 * @param req
	 * @return
	 */
	public String getReqDate(int req) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, req);
    return sdf.format(cal.getTime());
}
}

