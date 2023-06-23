package model;

public class MemberVO {
	private String memberId; // 아이디(PK)
	private String memberPw; // 비밀번호
	private String memberName; // 이름
	private int statusNum; // 등급번호
	private String tmpPw; // 비밀번호 변경 임시변수
	private String action; // 어떤 기능인지 알려줄 임시변수
	private String statusName; // 등급이름 - 추후에 사용할 예정
	private String tmpString;
	
	// 생성자
	public MemberVO(String memberId, String memberPw, String memberName) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.statusNum = 2; // 사용자는 기본적으로 '2'
							// 관리자는 '1'이 될 예정
							// 추후에 등급 추가 시 변경
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getStatusNum() {
		return statusNum;
	}

	public void setStatusNum(int statusNum) {
		this.statusNum = statusNum;
	}

	public String getTmpPw() {
		return tmpPw;
	}

	public void setTmpPw(String tmpPw) {
		this.tmpPw = tmpPw;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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
		return this.memberName +"님 아이디 : "+ this.memberId;
	}
	
	public String getTmpString() {
		return tmpString;
	}

	public void setTmpString(String tmpString) {
		this.tmpString = tmpString;
	}

	// equals 오버라이딩
	@Override
	public boolean equals(Object obj) {
		// 아이디가 같으면 같은 객체
		MemberVO mVO = (MemberVO) obj;
		if(this.memberId.equals(mVO.memberId)) {
			return true;
		}
		return false;
	}
	
	
	
	
}
 