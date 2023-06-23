package model;

public class AirOptVO {
	private int airOptNum; // 항공옵션 번호(PK)
	private String airOptGrade; // 좌석등급
	private int airOptPice; // 추가금액
	
	public AirOptVO(int airOptNum, String airOptGrade, int airOptPice) {
		this.airOptNum = airOptNum;
		this.airOptGrade = airOptGrade;
		this.airOptPice = airOptPice;
	}

	public int getAirOptNum() {
		return airOptNum;
	}

	public void setAirOptNum(int airOptNum) {
		this.airOptNum = airOptNum;
	}

	public String getAirOptGrade() {
		return airOptGrade;
	}

	public void setAirOptGrade(String airOptGrade) {
		this.airOptGrade = airOptGrade;
	}

	public int getAirOptPice() {
		return airOptPice;
	}

	public void setAirOptPice(int airOptPice) {
		this.airOptPice = airOptPice;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "항공옵션번호: " + airOptNum + ", 좌석등급: " + airOptGrade + ", 추가금액: " + airOptPice;
	}
	
}
