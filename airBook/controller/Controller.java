package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.AirBookDAO;
import model.AirBookVO;
import model.AirDetDAO;
import model.AirDetVO;
import model.AirInfoDAO;
import model.AirInfoVO;
import model.AirOptDAO;
import model.AirOptVO;
import model.Crawling;
import model.MemberDAO;
import model.MemberVO;
import model.StatusDAO;
import model.StatusVO;
import model.Util;
import view.AdminView;
import view.CommonView;
import view.CustomerView;

public class Controller {

	private static Scanner sc = new Scanner(System.in);
	private AirOptDAO AoDAO;
	private AirDetDAO AdDAO;
	private AirInfoDAO AiDAO;
	private AirBookDAO AbDAO;
	private StatusDAO sDAO;
	private MemberDAO mDAO;
	private AdminView aView;
	private CustomerView cView;
	private MemberVO member;

	public Controller() {
		AoDAO = new AirOptDAO();
		AdDAO = new AirDetDAO();
		AiDAO = new AirInfoDAO();
		AbDAO = new AirBookDAO();
		sDAO = new StatusDAO();
		mDAO = new MemberDAO();
		aView = new AdminView();
		cView = new CustomerView();
		this.member = null;
	}

	public void startApp() {
		//		// 항공정보 insert
		//		ArrayList<AirInfoVO> aiList = Crawling.sample();
		//
		//		for (AirInfoVO aiVO : aiList) {
		//			AiDAO.insert(aiVO);         
		//		}
		//
		//		// 항공옵션 insert
		//		ArrayList<AirOptVO> aoList = new ArrayList<AirOptVO>();
		//		aoList.add(new AirOptVO(0, "이코노미", 1));
		//		aoList.add(new AirOptVO(0, "비즈니스", 3));
		//		aoList.add(new AirOptVO(0, "퍼스트", 10));
		//
		//		for (AirOptVO aoVO : aoList) {
		//			AoDAO.insert(aoVO);
		//		}
		//
		//		// 항공상세 insert
		//		ArrayList<AirInfoVO> aiNumList = AiDAO.selectAll(new AirInfoVO());
		//		ArrayList<AirOptVO> aoNumList = AoDAO.selectAll(new AirOptVO(0, null, 0));
		//
		//		for (AirInfoVO aidata : aiNumList) {
		//			int aiNum = aidata.getAirInfoNum();
		//			for (AirOptVO aodata : aoNumList) {
		//				int aoNum = aodata.getAirOptNum();
		//				AirDetVO adVO = new AirDetVO(0, aiNum, aoNum, 0);
		//				AdDAO.insert(adVO);
		//			}
		//		}
		//
		//		// 회원듭급 insert
		//		ArrayList<StatusVO> sList = new ArrayList<StatusVO>();
		//		sList.add(new StatusVO(0, "관리자"));
		//		sList.add(new StatusVO(0, "사용자"));
		//
		//		for (StatusVO sVO : sList) {
		//			sDAO.insert(sVO);
		//		}

		// ===================== 초 기 콘 솔 창 ==================================

		boolean flag = false;
		while (true) {

			// 초기화면 출력
			int action = cView.getMenu();

			if (action == 1) { // 회원가입
				MemberVO mVO = cView.signUp(); // 사용자가 입력한 아이디 비밀번호를 M에 전달해줄 mVO 객체 생성

				mVO.setTmpString("아이디중복확인");

				if (mDAO.selectOne(mVO) != null) {
					cView.printSignUpFalse();
					continue;
				}
				if (!mDAO.insert(mVO)) {
					cView.printSignUpFalse();
					continue;
				}
				cView.printSignUpTrue();
			}
			// 로그인
			else if (action == 2) {
				MemberVO mVO = cView.signIn(); // V에서 사용자가 입력한 아이디와 비밀번호를 mVO에 저장
				mVO.setTmpString("로그인");
				member = mDAO.selectOne(mVO);// mVO에 해당하는 회원을 추출해서 member 객체에 대입

				// 만약 해당 회원 정보가 없을시 ---> 로그인 실패
				if (member == null) {
					cView.printSignInFalse();
					continue;
				}
				cView.printSignInTrue();

				// ========================== 사 용 자 모 드 분 기 점 ==============================================

				if (member.getStatusNum() == 2) {
					// 종료까지 반복
					while (true) {
						// V야 getAirMenu (사용자 모드 프로그램 목록) [input x, output 트라이캐치 처리된 menuInt값]
						int uAction = cView.getAirMenu();
						if (uAction == 1) { // 1. 항공권 목록 출력
							cView.printAirList(AiDAO.selectAll(new AirInfoVO()));
						}

						// 2. 정렬 출력 (인기순, 날짜순)
						else if (uAction == 2) {
							int selectSort = cView.getSortMenu();

							// 1. 날짜순 출력
							if (selectSort == 1) {
								AirInfoVO aiVO = new AirInfoVO();
								aiVO.setTmpAirSC("전체시간");
								cView.printAirSortDate(AiDAO.selectAll(aiVO));
							}
							// 2. 인기순 출력
							else if (selectSort == 2) {
								AirInfoVO aiVO = new AirInfoVO();
								aiVO.setTmpAirSC("전체인기");
								cView.printAirSortLike(AiDAO.selectAll(aiVO));
							}
						}
						// 3. 필터검색 (가격, 날짜)
						else if (uAction == 3) {
							cView.printAirList(AiDAO.selectAll(cView.getFilterSearch()));
						}
						// 4. 예매
						else if (uAction == 4) {
							// 현재 AirInfo(항공정보)에 있는 항공 리스트 출력
							cView.printAirList(AiDAO.selectAll(new AirInfoVO()));
							int ticketing = cView.getAirbookNum(); // 예매할 번호 사용자에게서 입력 받음
							AirInfoVO aiVO = new AirInfoVO(ticketing, null, null, null, null, 0, null); // 해당 번호 저장

							// 해당 예약번호가 있는지 존재 확인 ---> 없을시 실패
							aiVO = AiDAO.selectOne(aiVO);
							if (aiVO == null) {
								cView.printBookFalse(); // 예매 실패 출력
								continue;
							}

							// 출발시간 비교 ---> 과거일시 예매실패
							if (Util.compareTime(aiVO.getAirInfoStart())) {
								cView.printBookSYSFalse();
								cView.printBookFalse(); // 예매 실패 출력
								continue;
							}

							// 항공 상세 정보 객체에 "예약할 항공편 번호" 저장
							AirDetVO adVO = new AirDetVO(0, ticketing, 0, 0);
							adVO.setAirTmpName("예약"); // 기능 구분 키워드

							// 해당 항공편의 옵션(비즈니스, 이코노미 등...)을 출력 후 "항공상세번호" 선택 받음
							// 입력 받은 항공상세번호 존재 확인
							AirBookVO abVO = cView.getOptionNum(AdDAO.selectAll(adVO));

							// 해당 항공편에 예매 가능한 항공 상세가 없을 경우
							if (abVO == null) {
								cView.printBookFalse();
								continue;
							}

							//AirDetVO adVO1 = AdDAO.selectOne(new AirDetVO(abVO.getAirDetNum(), 0, 0, 0));

							abVO.setMemberId(member.getMemberId());

							// insert 실패시
							if (!AbDAO.insert(abVO)) {
								cView.printBookFalse();
								continue;
							}
							AirDetVO adVO2 = new AirDetVO(abVO.getAirDetNum(), 0, 0, abVO.getAirBookCnt());
							adVO2.setAirTmpName("감소"); // 기능 키워드 저장

							// 재고 감소 실패시
							if (!AdDAO.update(adVO2)) {

								// 여기서 insert한거 없애야 하는거 아닌지?

								cView.printBookFalse();
								continue;
							}

							// 성공
							cView.printBookTrue();

							//티켓출력
							AirBookVO abVO1 = new AirBookVO(0,null,0,0,null,null);
							abVO1.setTmpString("티켓");
							abVO1.setMemberId(member.getMemberId());
							cView.printTicket(AbDAO.selectOne(abVO1));


						}
						// 5. 마이페이지
						else if (uAction == 5) {
							flag = false;
							// 종료까지 반복
							while (true) {
								int myAct = cView.getMypageMenu();

								// 1. 예매한 항공권 내역 확인
								if (myAct == 1) {
									// System.out.println("예매하셨던 항공권 번호를 입력하세요");
									AirBookVO abVO = new AirBookVO(0, member.getMemberId(), 0, 0, null, null);

									cView.printAirBookList(AbDAO.selectAll(abVO));
								}
								// 2. 예약 변경
								// 예매 변경 시 변경 횟수, 수수료
								else if (myAct == 2) {
									// int airnum=cView.airBookChange(AbDAO.selectAll());
									// AirBookVO abVO=new AirBookVO(0,member.getmId(),0,0,null,null);
									// AbDAO.update();
									// cView.printBookChangeTrue();
									// 내가 예매한 목록
									AirBookVO abVO = new AirBookVO(0, member.getMemberId(), 0, 0, null, null);
									int airNum = cView.airBookChange(AbDAO.selectAll(abVO));

									if (airNum == 0) {
										cView.printBookFalse(); // 예매 실패 출력
										continue;
									}

									// 내가 변경하기 전 예약한 정보
									// 1. 변경 전 예매한 상세번호
									// 2. 변경 전 예매한 좌석 개수
									AirBookVO abVO2 = new AirBookVO(airNum, null, 0, 0, null, null);
									abVO2.setTmpString("selectOne");
									abVO2 = AbDAO.selectOne(abVO2);

									if(abVO2 == null) {
										CommonView.printFalse();
										continue;
									}

									if(!abVO2.getMemberId().equals(member.getMemberId())) {
										CommonView.printFalse();
										continue;
									}

									AirDetVO adVO = new AirDetVO(0, 0, 0, 0);
									adVO.setAirTmpName("예약변경");
									// 내가 변경할 항공상세
									// 1. 변경 할 상세번호
									// 2. 변경 할 좌석 개수
									AirDetVO adVO2 = cView.airBookChangeNew(AdDAO.selectAll(adVO));


									if(adVO2 == null) {
										cView.printBookChangeFalse();;
										continue;
									}

									// 없는 상세 번호 선택시
									if(AdDAO.selectOne(adVO2)==null) {
										CommonView.printFalse();
										continue;
									}

									// 변경 조건이 맞춰지면 우리가 예약테이블에 넣을(update) 정보들을 저장
									AirBookVO abVO3 = new AirBookVO(airNum, null, adVO2.getAirDetNum(),
											adVO2.getAirDetCnt(), null, null);

									AirInfoVO aiVO = new AirInfoVO(0, null, null, null, null, 0, null);

									// AirInfoNum(항공정보를 갖고 싶어서)
									AirDetVO adVO3 = AdDAO.selectOne(adVO2);
									aiVO.setAirInfoNum(adVO3.getAirInfoNum());
									aiVO = AiDAO.selectOne(aiVO);
									// 시간을 알고 싶음
									// airInfoNum이 필요함
									// 그러면 airDet의 객체의 멤버변수의 값이 필요함
									// 그러면 airDet의 PK로 selectOne해서 다 불러와야겠다
									// airDet밖에 없어요 
									// 왜? 사실 다 모름
									// 근데 사용자가 알려줌 ---> "이걸로 변경할래"라고

									if (Util.compareTime(aiVO.getAirInfoStart())) {
										cView.printBookSYSFalse();
										cView.printBookFalse(); // 예매 실패 출력
										continue;
									}

									// 변경 전 예매한 상세번호의 좌석 개수 되돌리기
									AirDetVO adVO4 = new AirDetVO(abVO2.getAirDetNum(), 0, 0, -abVO2.getAirBookCnt());
									adVO4.setAirTmpName("감소"); // 기능 키워드 저장


									// 변경 후 예매한 상세번호의 좌석 개수 차감하기
									AirDetVO adVO5 = new AirDetVO(abVO3.getAirDetNum(), 0, 0, abVO3.getAirBookCnt());
									adVO5.setAirTmpName("감소"); // 기능 키워드 저장

									// 예매변경 -> 예매변경실행 -> 기존예매좌석증가 -> 변경한예매좌석차감
									// 현재 남은 좌석 개수
									if (abVO2.getAirDetNum() == adVO2.getAirDetNum()) { // 현재 예약된 상세번호(취소될거) == 바꿀 상세번호(구매될거)
										if (abVO2.getAirBookCnt() + AdDAO.selectOne(adVO2).getAirDetCnt() < adVO2.getAirDetCnt()) {
											CommonView.printFalse();
											continue;
										}
									} else {
										if (AdDAO.selectOne(adVO2).getAirDetCnt() < adVO2.getAirDetCnt()) {
											CommonView.printFalse();
											continue;
										}
									}
									// 예매 변경
									if (!AbDAO.update(abVO3)) {
										cView.printBookChangeFalse();
										continue;
									}
									// 이전 재고 롤백
									if (!AdDAO.update(adVO4)) {
										cView.printBookChangeFalse();
										continue;
									}
									// 변경한 예매 재고 감소
									if (!AdDAO.update(adVO5)) {
										cView.printBookChangeFalse();
										continue;
									}
									cView.printBookChangeTrue();
								}
								// 3. 예매 취소
								else if (myAct == 3) {
									AirBookVO abVO = new AirBookVO(0, member.getMemberId(), 0, 0, null, null);
									int airNum = cView.airBookCancel(AbDAO.selectAll(abVO)); // 취소할 예약 번호

									if (airNum == 0) {
										cView.printCancelFalse();
										continue;
									}

									AirBookVO abVO2 = new AirBookVO(airNum, null, 0, 0, null, null);
									abVO2.setTmpString(" ");
									abVO2 = AbDAO.selectOne(abVO2);

									if (abVO2 == null) {
										CommonView.printFalse();
										continue;
									}

									if (!abVO2.getMemberId().equals(member.getMemberId())) {
										CommonView.printFalse();
										continue;
									}

									AirInfoVO aiVO = new AirInfoVO(0, null, null, null, null, 0, null);


									AirDetVO adVO = new AirDetVO(abVO2.getAirDetNum(), 0, 0, -(abVO2.getAirBookCnt()));

									AirDetVO adVO3 = AdDAO.selectOne(adVO);
									aiVO.setAirInfoNum(adVO3.getAirInfoNum());
									aiVO = AiDAO.selectOne(aiVO);

									if (Util.compareTime(aiVO.getAirInfoStart())) {
										cView.printDeleteSYSFalse();
										cView.printCancelFalse(); // 예매 실패 출력
										continue;
									}

									adVO.setAirTmpName("감소");

									// 예매한 좌석 복귀(롤백) ---> airDet의 잔여좌석
									if (!AdDAO.update(adVO)) {
										cView.printCancelFalse();
										continue;
									}

									// 예매내역 삭제
									if (!AbDAO.delete(abVO2)) {
										cView.printCancelFalse();
										continue;
									}

									cView.printCancelTrue();
								}
								// 4. 회원 정보 변경
								else if (myAct == 4) {

									// MemberVO mVO2 = new
									// MemberVO(member.getmId(),member.getmPw(),member.getmName());
									// member가 이미 로그인 된 상태인데 굳이 위에 선언해줄 필요가 있나?
									String mpw = cView.checkPasswd(member); // 사용자가 입력한 비밀번호를 mpw에 담음
									if (!member.getMemberPw().equals(mpw)) { // 만약 기존 비밀번호와 일치하지 않다면
										cView.printChangePassFalse(); // 비밀번호 일치 x 출력문
										continue;
									}

									String npw = cView.getNewPasswd(mpw); // 사용자가 입력한 새로운 비밀번호를 npw에 담음
									MemberVO mVO2 = new MemberVO(member.getMemberId(), npw, member.getMemberName());
									// 현재 로그인한 아이디와 새로운 비밀번호를 M에 전달 해줄 mVO 객체 생성

									if (!mDAO.update(mVO2)) { // 비밀번호 변경을 실패했다면
										cView.printChangePassFalse(); // 비밀번호 변경 실패 출력문
										continue;
									}
									cView.printChangePassTrue(); // 비밀번호 변경 성공 출력문
									member = null;
									flag = true;
									break;

								}
								// 5. 회원 탈퇴
								else if (myAct == 5) {
									String mpw = cView.checkPasswd(member); // 사용자가 입력한 비밀번호를 mpw에 담음
									if (!member.getMemberPw().equals(mpw)) { // 만약 기존 비밀번호와 일치하지 않다면
										cView.printMdeleteFalse(); // 비밀번호 일치 x 출력문
										continue;
									}

									if (!cView.checkMdelete()) {
										cView.printMdeleteFalse(); // 정말 탈퇴?
										continue;
									}
									if (!mDAO.delete(member)) {
										cView.printMdeleteFalse(); // 비밀번호 일치 x 출력문
										continue;
									}
									cView.printMdeleteTrue();
									member = null;
									flag = true;
									break;
								}
								// 6. 이전화면으로 돌아가기(마이페이지 종료)
								else if (myAct == 6) {
									cView.printback();
									break;
								}
							}// 마이페이지 반복 while문 끝
							if (flag) {
								break;
							}
						}
						// 6. 로그아웃
						else if (uAction == 6 || flag) {
							member = null;
							cView.printSignOutTrue();
							break;
						}
					}
				}

				// ========================= 관 리 자 모 드 분 기
				// ===============================================

				else if (member.getStatusNum() == 1) {
					// 종료까지 반복
					while (true) {
						// V야 getAdminMenu (관리자 모드 프로그램 목록) [input x, output 트라이캐치 처리된 menuInt값]
						int adSelect = aView.getAdminMenu();

						// 1. 항공 정보 변경
						if (adSelect == 1) {
							cView.printAirList(AiDAO.selectAll(new AirInfoVO())); // UI/UX

							// 변경할 상품 번호(항공정보 번호/ AirInfo_Num)
							int change = aView.getAirChangeNum();

							// selectOne으로 존재확인 ---> null일시 실패
							if (AiDAO.selectOne(new AirInfoVO(change, null, null, null, null, 0, null)) == null) {
								aView.printAirChangeFalse();
								continue;
							}

							// 변경할 시간/가격, 기능분류키워드 받아옴
							AirInfoVO aiVO = aView.getFilterChange();

							if (aiVO.getTmpAirSC().equals("")) {
								CommonView.printFalse();
								continue;
							}

							// 변경할 항공정보번호 인자 값에 담아서 전달
							aiVO.setAirInfoNum(change);
							if (!AiDAO.update(aiVO)) {
								aView.printAirChangeFalse();
								continue;
							}
							aView.printAirChangeTrue();

						}
						// 2. 잔여 좌석 변경
						else if (adSelect == 2) {
							int seatch = aView.getAirOption();

							AirDetVO adVO1 = AdDAO.selectOne(new AirDetVO(seatch, 0, 0, 0));

							if (adVO1 == null) {
								aView.printAirCntFalse();
								continue;
							}

							int seatch2;
							int seatCnt;

							// 잔여좌석 재고 검사
							while (true) {
								seatch2 = aView.getAirDept();

								seatCnt = adVO1.getAirDetCnt() + seatch2;
								if (seatCnt >= 0) {
									break;
								}
								CommonView.printFalse();
							}

							if(seatch2 == 0) {
								aView.printAirCntFalse();
								continue;
							}

							AirDetVO adVO2 = new AirDetVO(seatch, 0, 0, seatCnt);
							adVO2.setAirTmpName("변경");
							if (!AdDAO.update(adVO2)) {
								aView.printAirCntFalse();
								continue;
							}
							aView.printAirCntTrue();
						}
						// 3. 항공 노선 삭제
						else if (adSelect == 3) {
							int delete = aView.getDeleteAirNum();
							if (AiDAO.selectOne(new AirInfoVO(delete, null, null, null, null, 0, null)) == null) {
								aView.printAirDeleteFalse();
								continue;
							}
							if (!AiDAO.delete(new AirInfoVO(delete, null, null, null, null, 0, null))) {
								aView.printAirDeleteFalse();
								continue;
							}
							aView.printAirDeleteTrue();
						}
						// 4. 관리자모드 종료
						else if (adSelect == 4) {
							aView.printend();
							break;
						}

					} // 관리자 모드 while 끝

				} // 관리자 모드 if 끝

			} // 로그인 if 끝
			// 전체 프로그램 종료
			else if (action == 3) {
				cView.printend();
				break;
			}

		} // 전체 프로그램 while 끝

	} // startApp() 끝

}