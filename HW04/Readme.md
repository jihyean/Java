## 설계서
# model

mberVO
   private String mid 	// 아이디(PK)
   private String mid 	// 비밀번호
   private String mid	// 이름

// 생성자 ---> 모든 값 입력 받아야 생성
public MemberVO(String mid,String mpw,String name) {
	this.mid=mid;
	this.mpw=mpw;
	this.name=name;
}

getter setter
toString 오버라이딩
equals 오버라이딩 	// 아이디(PK)가 같다면 같은 객체

//////////////////////////////////////////////////////////////////////////////////////////////////////////
MemberDAO
실패 혹은 null 일시 ---> 로그 출력합니다
//*******************************************************************************//
private ArrayList<MemberVO> datas;
생성자 MemberDAO() {
	datas = new ArrayList<MemberVO>(); //객체 생성
	datas.add(new MemberVO("admin", "1234", "관리자"));
	datas.add(new MemberVO("coding_helper", "timo", "작은 티모"));
}
//*******************************************************************************//

public boolean insert(MemberVO mVO)
회원가입		// 아이디 중복 검사 후 가입 > flag 사용 예정
		// 가입 성공 ---> return true; 가입 실패 ---> return false;

getMid(), getMpw(), getName()
아이디, 비밀번호, 이름 각 인자로 받음

//*******************************************************************************//

public MemberVO selectOne(MemberVO mVO)
로그인		// 해당 아이디 있는지 확인
		// 비밀번호 일치하는지 확인
		// 존재확인 성공 ---> return 해당 객체; 존재확인 실패 ---> return null;

getMid()로 해당 아이디 존재하는지 확인 후에 있다면 getMpw()로 비밀번호 확인
로그인 성공--->해당 객체 반환
로그인 실패--->return null;

//*******************************************************************************//

public MemberVO selectAll(MemberVO mVO)
return null;		//회원 목록 출력 기능
			// 해당 사항 없으므로 return null
해당 사항 없음	

//*******************************************************************************//
public boolean update(MemberVO mVO)
return false;

해당 사항 없음


//*******************************************************************************//

public boolean delete(MemberVO mVO)
회원탈퇴		// 해당 아이디 있는지 확인 후 삭제
		// 삭제 성공 ---> return true; 삭제 실패 ---> return false;

getMid()로 해당 아이디 존재하는지 확인 후에 있다면 삭제 후 성공/실패 반환

//*******************************************************************************//

[ 우선순위 ]
객체 생성
회원가입
로그인
회원탈퇴



