package model;

import java.util.Date;

public class AirDetVO {
	private int airDetNum; // 항공상세 번호(PK)
	private int airInfoNum; // 항공정보 번호(FK)
	private int airOptNum; // 항공옵션 번호(FK)
	private int airDetCnt; // 잔여좌석 개수
	// 임시 변수
	private String airTmpName;
	private String airInfoAirline; // 항공사
	private String airInfoRoute; // 비행경로
	private Date airInfoStart; // 출발시간
	private Date airInfoReturn; // 도착시간
	private int price; // 가격
	private Date airInfoDate; // 비행날짜
	private String airOptGrade; // 좌석등급
	
	// 기본 AirDetVO 생성자
	public AirDetVO(int airDetNum, int airInfoNum, int airOptNum, int airDetCnt) {
		this(airDetNum, airInfoNum, airOptNum, airDetCnt, null, null, null, null, null, 0, null, null);
	}
	
	// Join AirDetVo 생성자
	public AirDetVO(int airDetNum, int airInfoNum, String airInfoAirline, String airInfoRoute, Date airInfoStart, Date airInfoReturn, int price, Date airInfoDate, String airOptGrade, int airDetCnt) {
		this(airDetNum, airInfoNum, 0, airDetCnt, null, airInfoAirline, airInfoRoute, airInfoStart, airInfoReturn, price, airInfoDate, airOptGrade);
	}
	
	// 전체 AirDetVO 생성자
	public AirDetVO(int airDetNum, int airInfoNum, int airOptNum, int airDetCnt, String airTmpName,
			String airInfoAirline, String airInfoRoute, Date airInfoStart, Date airInfoReturn, int price,
			Date airInfoDate, String airOptGrade) {
		this.airDetNum = airDetNum;
		this.airInfoNum = airInfoNum;
		this.airOptNum = airOptNum;
		this.airDetCnt = airDetCnt;
		this.airTmpName = airTmpName;
		this.airInfoAirline = airInfoAirline;
		this.airInfoRoute = airInfoRoute;
		this.airInfoStart = airInfoStart;
		this.airInfoReturn = airInfoReturn;
		this.price = price;
		this.airInfoDate = airInfoDate;
		this.airOptGrade = airOptGrade;
	}

	public int getAirDetNum() {
		return airDetNum;
	}


	public void setAirDetNum(int airDetNum) {
		this.airDetNum = airDetNum;
	}

	public int getAirInfoNum() {
		return airInfoNum;
	}

	public void setAirInfoNum(int airInfoNum) {
		this.airInfoNum = airInfoNum;
	}

	public int getAirOptNum() {
		return airOptNum;
	}

	public void setAirOptNum(int airOptNum) {
		this.airOptNum = airOptNum;
	}

	public int getAirDetCnt() {
		return airDetCnt;
	}

	public void setAirDetCnt(int airDetCnt) {
		this.airDetCnt = airDetCnt;
	}
	
	// 임시 변수
	public String getAirTmpName() {
		return airTmpName;
	}

	public void setAirTmpName(String airTmpName) {
		this.airTmpName = airTmpName;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getAirInfoDate() {
		return airInfoDate;
	}

	public void setAirInfoDate(Date airInfoDate) {
		this.airInfoDate = airInfoDate;
	}

	public String getAirOptGrade() {
		return airOptGrade;
	}

	public void setAirOptGrade(String airOptGrade) {
		this.airOptGrade = airOptGrade;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "[상세번호: " + airDetNum + "번]\n"
				+"편명: " + airInfoNum + " " + airInfoRoute + " " + airInfoDate + " " + Util.dateToString(airInfoStart) +" ~ "+ Util.dateToString(airInfoReturn) +"\n\t"
				+ "항공사: " + airInfoAirline + " 좌석등급: " + airOptGrade + " 잔여좌석: " + airDetCnt + "석 가격: " + price +"원\n";
	}
}
