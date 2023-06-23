package model;

public class StatusVO {
	private int statusNum; // 등급번호
	private String statusName; // 등급이름
	
	// 생성자
	public StatusVO(int statusNum, String statusName) {
		this.statusNum = statusNum;
		this.statusName = statusName;
	}

	// getter, setter
	public int getStatusNum() {
		return statusNum;
	}

	public void setStatusNum(int statusNum) {
		this.statusNum = statusNum;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "등급 : "+ this.statusName;
	}
	
	
}
