package model;

import java.util.ArrayList;

// 회원목록출력
// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
public class MemberDAO {
	private ArrayList<MemberVO> datas;

	public MemberDAO() {
		datas = new ArrayList<MemberVO>();
		datas.add(new MemberVO("admin", "1234", "관리자"));
		datas.add(new MemberVO("coding_helper", "timo", "작은 티모"));
	}

	public ArrayList<MemberVO> selectAll(MemberVO mVO) {
		return datas;
	}

	public MemberVO selectOne(MemberVO mVO) {
		for(MemberVO v:datas) {
			if(mVO.getMid().equals(v.getMid())) {
				if(mVO.getMpw().equals(v.getMpw())) {
					return v;
				}
				System.out.println("로그: MemberDAO: selectOne(): 비밀번호가 일치하지 않습니다");
				return null;
			}
		}
		System.out.println("로그: MemberDAO: selectOne(): 해당 아이디가 없습니다");
		return null;
	}

	public boolean insert(MemberVO mVO) {
		boolean flag = false;
		for (MemberVO data : datas) {
			if (data.equals(mVO)) {
				flag = true;
				System.out.println(" 로그: MemberDAO: insert(): 아이디 중복");
				break;
			}
		}
		if (flag) {
			return false;
		}
		datas.add(new MemberVO(mVO.getMid(), mVO.getMpw(), mVO.getName()));
		/*
		 * datas.add(new MemberVO()); -> datas DB공간에 new 새로운 데이터를 추가
		 * MemberVO(데이터1,데이터2,데이터3) -> 데이터들을 mVO에서 추출하면됨
		 */
		return true;

		// 1. mVO가 의미하는것 == 회원가입할 정보
		// 2. mVO를내가 가지고 있는 datas에 넣음
		// 3. PK이기 때문에 중복검사하고 성공시 add 실패시 반환
	}

	public boolean update(MemberVO mVO) {
		
		// 회원 비밀번호 변경
		for (MemberVO data : datas) {
			if (data.getMid().equals(mVO.getMid())) {
				data.setMpw(mVO.getMpw());
				return true;
			}
		}
		System.out.println(" 로그: MemberDAO: update(): 해당 회원이 없습니다");
		return false;
	}

	public boolean delete(MemberVO mVO) {
		
		for(int i=0; i<datas.size(); i++) {
			if(datas.get(i).equals(mVO)) {
				// PK값이 같다면 동일한 객체 ---> 오버라이딩
				datas.remove(i);
				return true;
			}
		}

		System.out.println(" 로그: MemberDAO: delete(): 해당 회원이 없습니다");
		return false;
	}
}

























