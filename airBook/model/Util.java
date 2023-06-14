package model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static String dateToString(Date date) {
		SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
		return HHmm.format(date);
	}
	
	public static Date stringToDate(String str) {
		String HHStr = str.substring(0, str.lastIndexOf(":"));
		int HH = Integer.parseInt(HHStr);
		String mmStr = str.substring(str.lastIndexOf(":") + 1);
		int mm = Integer.parseInt(mmStr);
		Date date = new Date(0000, 0, 0, HH, mm, 0);
		return date;
	}
	
	public static Time dateTotime(Date date) {
		SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
		String HHStr = HHmm.format(date).substring(0, 2);
		int HH = Integer.parseInt(HHStr);
		String mmStr = HHmm.format(date).substring(2);
		int mm = Integer.parseInt(mmStr);
		Time time = new Time(HH, mm, 00);
		return time;
	}
	
	public static Date timeToDate(Time time) {
		Date date = new Date(0000, 0, 0, time.getHours(), time.getMinutes(), 0);
		return date;
	}
	
	public static java.sql.Date utildateToSqldate(Date date) {
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
		java.sql.Date sqlDate = java.sql.Date.valueOf(yyyyMMdd.format(date));
		return sqlDate;
	}
}