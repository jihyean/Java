package model;

import java.util.Date;

public class AirInfoVO {
	private int airInfoNum; // 항공정보 번호(PK)
	private String airInfoAirline; // 항공사
	private String airInfoRoute; // 비행경로
	private Date airInfoStart; // 출발시간
	private Date airInfoReturn; // 도착시간
	private int airInfoPrice; // 가격
	private Date airInfoDate; // 비행날짜
	// 임시 변수 
	private String tmpAirSC;
	private int tmpPrice;

	public AirInfoVO() {
		this(null, null, null, null, 0);
	}

	public AirInfoVO(String airInfoAirline, String airInfoRoute, Date airInfoStart, Date airInfoReturn, int airInfoPrice) {
		this(0, airInfoAirline, airInfoRoute, airInfoStart, airInfoReturn, airInfoPrice, null);
	}
	
	public AirInfoVO(int airInfoNum, String airInfoAirline, String airInfoRoute, Date airInfoStart, Date airInfoReturn,
		int airInfoPrice, Date airInfoDate) {
		this.airInfoNum = airInfoNum;
		this.airInfoAirline = airInfoAirline;
		this.airInfoRoute = airInfoRoute;
		this.airInfoStart = airInfoStart;
		this.airInfoReturn = airInfoReturn;
		this.airInfoPrice = airInfoPrice;
		this.airInfoDate = airInfoDate;
		this.tmpAirSC = "전체";
	}

	public int getAirInfoNum() {
		return airInfoNum;
	}

	public void setAirInfoNum(int airInfoNum) {
		this.airInfoNum = airInfoNum;
	}

	public String getAirInfoAirline() {
		return airInfoAirline;
	}

	public void setAirInfoAirline(String airInfoAirline) {
		this.airInfoAirline = airInfoAirline;
	}

	public String getAirInfoRoute() {
		return airInfoRoute;
	}

	public void setAirInfoRoute(String airInfoRoute) {
		this.airInfoRoute = airInfoRoute;
	}

	public Date getAirInfoStart() {
		return airInfoStart;
	}

	public void setAirInfoStart(Date airInfoStart) {
		this.airInfoStart = airInfoStart;
	}

	public Date getAirInfoReturn() {
		return airInfoReturn;
	}

	public void setAirInfoReturn(Date airInfoReturn) {
		this.airInfoReturn = airInfoReturn;
	}

	public int getAirInfoPrice() {
		return airInfoPrice;
	}

	public void setAirInfoPrice(int airInfoPrice) {
		this.airInfoPrice = airInfoPrice;
	}

	public Date getAirInfoDate() {
		return airInfoDate;
	}

	public void setAirInfoDate(Date airInfoDate) {
		this.airInfoDate = airInfoDate;
	}
	 
	// 임시 변수
	public String getTmpAirSC() {
		return tmpAirSC;
	}
	
	public void setTmpAirSC(String tmpAirSC) {
		this.tmpAirSC = tmpAirSC;
	}
	
	public int getTmpPrice() {
		return tmpPrice;
	}
	
	public void setTmpPrice(int tmpPrice) {
		this.tmpPrice = tmpPrice;
	}
	

	// toString 오버라이딩
	@Override
	public String toString() {
		
		String str = "[편명: " + airInfoNum + "] " + airInfoRoute + " " + airInfoDate +" "
				+ Util.dateToString(airInfoStart) +" ~ "+ Util.dateToString(airInfoReturn) +"\n\t\t "
				+ airInfoAirline +" 운임비용: "+ airInfoPrice + "원 ";
		
		
		// String str = "[" + airInfoNum + "]" + airInfoAirline + airInfoRoute + Util.dateToString(airInfoStart) + " " + Util.dateToString(airInfoReturn) + " " + airInfoPrice + " " + airInfoDate + tmpAirSC;
		
		if (Util.compareTime(airInfoStart)) {
			str += " [마감]\n";
		}
		else {
			str += "\n";
		}
		return str;
	}
}