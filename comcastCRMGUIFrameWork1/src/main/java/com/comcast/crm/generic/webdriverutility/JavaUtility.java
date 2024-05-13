package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandonNumber()
	{
		Random random = new Random();
		int ranint = random.nextInt(5000);
		return ranint;
	}
	
	public String getSystemDateYYYYDDMM()
	{
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		
		return date;
	}
	
	public String getRequiredDateYYYYDDMM(int days)
	{

		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateObj);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate = sim.format(cal.getTime());
		return reqdate;
	}

}
