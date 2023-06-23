package model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	// Date 자료형을 String HH:mm 으로 출력 
	//	-> 항공정보vo 에서 출발시간, 도착시간이 Date 자료형이라서 시간만 출력되게
	//	-> Util.dateToString(airInfoStart) + " " + Util.dateToString(airInfoReturn)
	public static String dateToString(Date date) {
		SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
		return HHmm.format(date);
	}
	
	// String HH:mm 형태를 Date로 바꿔줌 
	//	-> 크롤링 시 HH:mm 형태로 받아오는데 항공정보vo에 담을 때 에서 출발시간, 도착시간이 Date 자료형이라서
	//	-> AirInfoVO aiVO = new AirInfoVO(airline, location, Util.stringToDate(startTime), Util.stringToDate(returnTime), price);
	public static Date stringToDate(String str) {
		String HHStr = str.substring(0, str.lastIndexOf(":"));
		int HH = Integer.parseInt(HHStr);
		String mmStr = str.substring(str.lastIndexOf(":") + 1); 
		int mm = Integer.parseInt(mmStr);
		Date date = new Date(0000, 0, 0, HH, mm, 0);
		return date;
	}
	
	// Date 자료형을 Time 자료형으로 바꿔줌 
	//	-> 항공정보vo에서 출발시간, 도착시간이 Date 자료형인데 테이블에 삽입할 시 테이블 자료형이 sql.time이기 때문에 pstmt.setTime(vo.출발시간)이 불가
	//	-> pstmt.setTime(4, Util.dateTotime(aiVO.getAirInfoReturn()));
	public static Time dateTotime(Date date) {
		SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
		String HHStr = HHmm.format(date).substring(0, 2);
		int HH = Integer.parseInt(HHStr);
		String mmStr = HHmm.format(date).substring(2);
		int mm = Integer.parseInt(mmStr);
		Time time = new Time(HH, mm, 00);
		return time;
	}
	
	// Time 자료형을 Date 자료형으로 바꿔줌 
	//	-> 항공정보테이블을 select할때 항공정보를 vo에 저장해야 하는데 rs.getTime(출발시간) 불가
	/*
	 * rs = pstmt.executeQuery();
	 * while(rs.next()) {
	 *     pdatas.add(new AirInfoVO(null, null, Util.timeToDate(rs.getTime("AIRINFO_START")), Util.timeToDate(rs.getTime("AIRINFO_RETURN")), 0));
	 * }
	 */
	public static Date timeToDate(Time time) {
		Date date = new Date(0000, 0, 0, time.getHours(), time.getMinutes(), 0);
		return date;
	}
	
	// utilDate를 sqlDate로 바꿔줌
	//	-> 항공예약 insert 시 예약날짜를 데이터베이스에 삽입해야 하는데 util.Date 자료형이라서 pstmt.setDate(5, abVO.getAirBookDate()) 불가
	//	-> pstmt.setDate(5, Util.utildateToSqldate(abVO.getAirBookDate()));
	public static java.sql.Date utildateToSqldate(Date date) {
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = java.sql.Date.valueOf(yyyyMMdd.format(date));
		return sqlDate;
	}
	
	// 시간 비교
	public static boolean compareTime(Date date) {
		Date now = new Date();
		Time nowTime = dateTotime(now);
		Time airTime = dateTotime(date);		
		
		if (nowTime.after(airTime)) { // 현재시간이 출발시간을 넘었으면
			return true;
		} else {
			return false;
		}
	}
}