package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.AdminView;
import view.ClientView;

public class Ctrl {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private AdminView admin;
	private ClientView client;
	private MemberVO member; // 현재 로그인한 회원

	public Ctrl() {
		mDAO = new MemberDAO();
		pDAO = new ProductDAO();
		admin = new AdminView();
		client = new ClientView();
		member = null; // 세션 로그인 데이터
		// member은 초기화하지 않음
		// 프로그램을 실행한다고 해서 자동로그인 되는 것은 아니기 때문
	}
//	public Ctrl(MemberVO member) { //자동 로그인
//		mDAO = new MemberDAO();
//		pDAO = new ProductDAO();
//		admin = new AdminView();
//		client = new ClientView();
//		this.member = null; // 세션 로그인 데이터
//		// member은 초기화하지 않음
//		// 프로그램을 실행한다고 해서 자동로그인 되는 것은 아니기 때문
//	}

	public void startApp() {
		while (true) {
			int action = client.printClientMenu01(); // 1.2.3.
			if (action == 1234) {
				while (true) {
					action = admin.printAdminMenu();
					if (action == 1) { // 회원목록출력 1.2.

						ArrayList<MemberVO> datas = mDAO.selectAll(null); // 3.4.5.
						// 7. 6.
						admin.printMemberList(datas);
						// 8.

						// 1. 사용자가 관리자인상황.
						// 2. 관리자가 회원목록볼래~
						// 3. V가 C한테 말합니다. 회원목록보겠다는데?
						// 4. C가 아, 회원목록데이터가 필요하구나? ㅇㅋ
						// 5. M한테 회원목록 좀 줘~
						// 6. M이 selectAll()합니다.
						// 7. AL<MVO>가 반환되고 C는 그걸-
						// 8. -V한테 줍니다.

						// admin.printMemberList(mDAO.selectAll(null));

					} else if (action == 2) {
						admin.printAdminEnd();
						break;
					}
				}
			} else if (action == 1) {

				MemberVO mVO = client.signUp();

				boolean flag = mDAO.insert(mVO);

				if (flag) {
					client.signUpTrue();
				} else {
					client.signUpFalse();
				}

				// 1. 사용자가 console에 회원가입할래~ 1번입력
				// 2. V는 입력한 값을 C한테 전달
				// 3. C는 아~ 회원가입하고싶구나? ㅇㅋ
				// 4. C는 V한테 회원가입할 정보를 입력받아오라고 지시
				// 5. V는 사용자한테 회원가입창 보여줌
				// 6. 사용자는 정보를 입력
				// 7. V는 사용자가 입력한 정보를 C한테 전달
				// 8. C는 이 정보를 M한테 전달
				// 9. M은 회원가입을 수행
				// 10. M은 insert()가 잘되었는지아닌지를 T,F를 반환
				// 11. C는 결과에따라 맞는 V화면을 보여줄수있도록 지시
				// 12. 사용자는 V가 보여주는 화면을 보게됨

//				if (mDAO.insert(client.signUp())) {
//					client.signUpTrue();
//				} else {
//					client.signUpFalse();
//				}

			} else if (action == 2) {

				// 1. 아이디입력해봐! 라고 V가 사용자에게 요청
				// 2. 비밀번호도 같이 입력해~~

				// 3. C는 이 정보가 있는지, 그리고 맞는지(==유효한지)
				// 위의 여부를 M한테 판단을 부탁함
				// --->> selectOne()

				// 4. M은 VO를 반환 == 존재하는 회원
				// 5. -> 로그인 성공 V
				// => 다음 스텝으로 이동
				// null을 반환 == 없거나, 비밀번호가 틀림!
				// 6. -> 로그인 실패 V
				// => 프로그램 모드에 계속 있어야함...

				MemberVO mVO = client.signIn(); // 1. 2.

				member = mDAO.selectOne(mVO); // 3.
				// 유효한 사용자 정보 or null(로그인 실패시)
				// 유효한 사용자 정보 == 현재 로그인한 회원

				if (member == null) {
					client.signInFalse();
					continue;
				}

				client.signInTrue();

				while (true) { // 사용자모드 진입
					action = client.printClientMenu02(member);
					if (action == 1) { // 로그아웃

						member = null;

						// 사용자가 로그아웃을 원하면,
						// C에 mdata가 현재 존재하는데, 이걸
						// 제거하고

						// 로그아웃이 되었음을 사용자에게 알려주자!~~

						client.logout();
						client.printClientEnd02();
						break;
					} else if (action == 2) { // 마이페이지

						String mpw = client.mypage(member);
						MemberVO mdata = new MemberVO(member.getMid(), mpw, member.getName());
						boolean flag = mDAO.update(mdata);

						if (flag) {
							client.printMemberChangeTrue();
						} else {
							client.printMemberChangeFalse();
						}

//						String mpw = client.getMpw(); // 사용자가 입력한 비밀번호
//						//현재 로그인한 사람의 비밀번호와 사용자가 입력한 비밀번호를 확인하는 로직
//						if(!(member.getMpw().equals(mpw))) {
//							client.printFalse();
//							continue;
//						}
//						
//						String npw = client.getChangePw().getMpw();
//						member.setMpw(npw);
//						
//						// member = client.getChangePw();
//						
//						if (!(mDAO.update(member))) {
//							
//							client.printMemberChangeFalse();
//							continue;
//						}
//						else { //회원  성공
//							client.printMemberChangeTrue();
//							client.printClientEnd02();
//							break;
//						}

					} else if (action == 3) { // 회원탈퇴
						// 현재 로그인한 상황.
						// 비밀번호를 한번더 확인하는 로직
						// 비밀번호가 불일치 -> 회원탈퇴 x
						// 비밀번호 일치
						// ->
						// 로그인이 되어있는 회원을
						// 전체회원목록에서 제거

						String mpw = client.getMpw(); // 사용자가 입력한 비밀번호
						// 현재 로그인한 사람의 비밀번호와 사용자가 입력한 비밀번호를 확인하는 로직
						if (!(member.getMpw().equals(mpw))) {
							client.printFalse();
							continue;
						}

						if (!(mDAO.delete(member))) {
							// 회원 탈퇴 실패
							client.printMemberDeleteFalse();
							continue;
						} else { // 회원 탈퇴 성공
							client.printMemberDeleteTrue();
							client.printClientEnd02();
							break;
						}

					} else if (action == 4) { // 상품목록출력
						ArrayList<ProductVO> pdatas = pDAO.selectAll(null);
						client.printProductList(pdatas);

					} else if (action == 5) { // 상품목록검색_이름으로 검색
						String name = client.getSearchContent();
						ProductVO pVO = new ProductVO(0, name, 0, 0);
						ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
						client.printProductList(pdatas);

					} else if (action == 6) { // 상품목록검색_가격으로 검색
						ProductVO pVO = client.getSearchFilter();
						ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
						client.printProductList(pdatas);

					} else if (action == 7) { // 상품검색_최고가 검색
						ProductVO pVO = new ProductVO(0, "최고가", 0, 0);
						ProductVO data = pDAO.selectOne(pVO);
						client.printProduct(data);
					}
				}

			} else if (action == 3) {
				client.printClientEnd01();
				break;
			}
		}
	}
}
