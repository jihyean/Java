package model;

import java.util.Date;

// toString() 오버라이딩 필요할 시 수정할 예정

public class AirBookVO {
	private int airBooknum; // 항공예매 번호(PK)
	private String memberId; // 아이디(FK)
	private int airDetNum; // 항공상서 번호(FK)(내가 변경할 예약번호)
	private int airBookCnt; // 예매좌석 개수(내가 변경할 좌석개수)
	private Date airBookDate; // 카드 번호
	private String airBookCard; // 예매 날짜
	// 임시 변수
	private String tmpAction;
	private int tmpDetNum; // 기존 예약한 번호
	private int tmpCnt; // 기존 예약한 번호의 잔여좌석
	
	private String tmpStart;
	private String tmpReturn;
	private String tmpDate;
	private String tmpString;
	

	public AirBookVO(int airBooknum, String memberId, int airDetNum, int airBookCnt, Date airBookDate, String airBookCard) {
		this.airBooknum = airBooknum;
		this.memberId = memberId;
		this.airDetNum = airDetNum;
		this.airBookCnt = airBookCnt;
		this.airBookDate = airBookDate;
		this.airBookCard = airBookCard;
	}

	public int getAirBooknum() {
		return airBooknum;
	}

	public void setAirBooknum(int airBooknum) {
		this.airBooknum = airBooknum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getAirDetNum() {
		return airDetNum;
	}

	public void setAirDetNum(int airDetNum) {
		this.airDetNum = airDetNum;
	}

	public int getAirBookCnt() {
		return airBookCnt;
	}

	public void setAirBookCnt(int airBookCnt) {
		this.airBookCnt = airBookCnt;
	}

	public Date getAirBookDate() {
		return airBookDate;
	}

	public void setAirBookDate(Date airBookDate) {
		this.airBookDate = airBookDate;
	}

	public String getAirBookCard() {
		return airBookCard;
	}

	public void setAirBookCard(String airBookCard) {
		this.airBookCard = airBookCard;
	}
	
	// 임시 변수
	public String getTmpAction() {
		return tmpAction;
	}

	public void setTmpAction(String tmpAction) {
		this.tmpAction = tmpAction;
	}
	
	public int getTmpCnt() {
		return tmpCnt;
	}

	public void setTmpCnt(int tmpCnt) {
		this.tmpCnt = tmpCnt;
	}

	public int getTmpDetNum() {
		return tmpDetNum;
	}

	public void setTmpDetNum(int tmpDetNum) {
		this.tmpDetNum = tmpDetNum;
	}
	
	public String getTmpStart() {
		return tmpStart;
	}

	public void setTmpStart(String tmpStart) {
		this.tmpStart = tmpStart;
	}

	public String getTmpReturn() {
		return tmpReturn;
	}

	public void setTmpReturn(String tmpReturn) {
		this.tmpReturn = tmpReturn;
	}

	public String getTmpDate() {
		return tmpDate;
	}

	public void setTmpDate(String tmpDate) {
		this.tmpDate = tmpDate;
	}

	public String getTmpString() {
		return tmpString;
	}

	public void setTmpString(String tmpString) {
		this.tmpString = tmpString;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "[예약번호: "+ airBooknum +"] 항공상세번호: " + airDetNum +"\n"
				+"좌석 수: "+ airBookCnt + "석 예약날짜: "+ airBookDate +"\n"
				+"결제카드: "+ airBookCard+"\n";
	}
	
}
