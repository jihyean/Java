package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.AirBookVO;
import model.AirDetVO;
import model.AirInfoVO;
import model.MemberVO;

public class CustomerView {
	static Scanner sc = new Scanner(System.in);
	final static int maxMenuNum = 3;
	final static int maxAirMenuNum = 6;
	final static int maxAirSortMenuNum = 2;
	final static int maxMyPageMenuNum = 6;
	final static int maxAirOptionNum = 3;

	// ===[메뉴
	// 출력]====================================================================================

	// 메뉴 출력
	public int getMenu() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 프로그램]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\n \t˚。˙＊。º＊˚．TryCatch 항공 예약 시스템입니다˚。˙＊。º＊˚\n");
		System.out.println(" \t\t\t어서오세요(>UvU<)\n");
		System.out.println(CommonView.RESET);

		System.out.println(CommonView.FONT_BLUE);
		System.out.printf("%20s %15s %15s", "[1]회원가입", "[2]로그인", "[3]프로그램종료\n");
		System.out.println(CommonView.RESET);

		while (true) {
			int menuNum = CommonView.trycatch();

			if (menuNum <= maxMenuNum && menuNum > 0) {
				return menuNum;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※프로그램 메뉴중에 선택해주세요※");
			System.out.println(CommonView.RESET);
		}
	}

	public int getAirMenu() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■[TryCatch 항공프로그램]■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		System.out.println(CommonView.FONT_BLUE);
		System.out.printf("%20s %15s %15s", "[1]항공권 목록 출력", "[2]정렬 출력(인기순, 시간순)", "[3]필터 검색(가격, 시간)\n");
		System.out.printf("%20s %15s %15s", "[4]예매", "[5]마이페이지", "[6]로그아웃\n");
		System.out.println(CommonView.RESET);

		while (true) {
			int menuNum = CommonView.trycatch();

			if (menuNum <= maxAirMenuNum && menuNum > 0) {
				return menuNum;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※프로그램 메뉴중에 선택해주세요※");
			System.out.println(CommonView.RESET);
		}
	}

	public int getSortMenu() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 프로그램]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		System.out.println(CommonView.FONT_BLUE);
		System.out.printf("%20s %15s", "[1]항공권 시간순", "[2]항공권 인기순\n");
		System.out.println(CommonView.RESET);

		while (true) {
			int menuNum = CommonView.trycatch();

			if (menuNum <= maxAirSortMenuNum && menuNum > 0) {
				return menuNum;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※프로그램 메뉴중에 선택해주세요※");
			System.out.println(CommonView.RESET);
		}
	}

	public int getMypageMenu() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■[TryCatch  마이페이지]■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		System.out.println(CommonView.FONT_BLUE);
		System.out.printf("%20s %15s %15s", "[1]예약내역 확인", "[2]예약 변경", "[3]예약 취소\n");
		System.out.printf("%20s %15s %15s", "[4]회원 정보 변경", "[5]회원 탈퇴", "[6]이전으로 돌아가기\n");
		System.out.println(CommonView.RESET);

		while (true) {
			int menuNum = CommonView.trycatch();

			if (menuNum <= maxMyPageMenuNum && menuNum > 0) {
				return menuNum;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※프로그램 메뉴중에 선택해주세요※");
			System.out.println(CommonView.RESET);
		}
	}

	// ===[메서드]====================================================================================

	// 회원 가입
	public MemberVO signUp() {
		String mId;
		String mPw;
		String mName;

		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 회원가입]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		while (true) {
			System.out.println();
			System.out.print("사용할 아이디 입력 ▶ ");
			mId = sc.next();

			if (mId.getBytes().length < 30) { // 길이 25바이트까지 varchar(25)
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※길이가 너무 깁니다!");
			System.out.print(CommonView.RESET);
			System.out.println("∴다시 입력해주세요");
		}

		while (true) {
			System.out.println();
			System.out.print("사용할 비밀번호 입력 ▶ ");
			mPw = sc.next();

			if (mPw.getBytes().length < 30) { // 길이 30바이트까지 varchar(30)
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※길이가 너무 깁니다!");
			System.out.print(CommonView.RESET);
			System.out.println("∴다시 입력해주세요");
		}

		while (true) {
			System.out.println();
			System.out.print("사용자 이름 입력 ▶ ");
			mName = sc.next();

			if (mName.getBytes().length < 15) { // 길이 30바이트까지 varchar(30)
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※길이가 너무 깁니다!");
			System.out.print(CommonView.RESET);
			System.out.println("∴다시 입력해주세요");
		}

		MemberVO mVO = new MemberVO(mId, mPw, mName);
		return mVO;
	}

	// 로그인
	public MemberVO signIn() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■[TryCatch 로그인]■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		System.out.print("사용자 아이디 ▶ ");
		String mId = sc.next();
		System.out.print("사용자 비밀번호 입력 ▶");
		String mPw = sc.next();
		MemberVO mVO = new MemberVO(mId, mPw, null);
		return mVO;
	}

	// ===[목록
	// 출력]====================================================================================

	// 전체 목록 출력
	public void printAirList(ArrayList<AirInfoVO> fdatas) {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■[TryCatch 항공권 목록]■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("출력할 항공권이 없습니다...(。・ω・。)");
			return;
		}

		// 항공권 목록 출력
		for (AirInfoVO v : fdatas) {
			System.out.println(v.toString());
		}
		// System.out.println();
		// System.out.println("항공권 목록 출력 완료!");
	}

	// 날짜순(시간순) 목록 출력
	public void printAirSortDate(ArrayList<AirInfoVO> fdatas) {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■ [TryCatch 항공권시간순] ■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("출력할 항공권이 없습니다...(。・ω・。)");
			return;
		}

		for (AirInfoVO v : fdatas) {
			System.out.println(v.toString());
		}
		// System.out.println();
		// System.out.println("항공권 목록 출력 완료!");
	}

	// 인기순 목록 출력
	public void printAirSortLike(ArrayList<AirInfoVO> fdatas) {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■ [TryCatch 항공권인기순] ■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);


		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("출력할 항공권이 없습니다...(。・ω・。)");
			return;
		}

		for (AirInfoVO v : fdatas) {
			System.out.println(v.toString());
		}
		System.out.println();
		System.out.println("항공권 목록 출력 완료!");
	}

	// ===[필터
	// 검색]====================================================================================
	//////////////////////////////////// Date 타입, 리턴
	// 필터검색: 날짜,가격으로 검색하기
	public AirInfoVO getFilterSearch() {
		AirInfoVO aiVO = new AirInfoVO();
		String searchCondition = "";
		while (true) {
			System.out.println(CommonView.FONT_BLUE);
			System.out.println("\tQ. 항공 시간으로 검색하시겠습니까?");
			System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
			System.out.println(CommonView.RESET);
			// System.out.println("1.YES 2.NO ");
			int num = CommonView.ok();
			if (num == 1) {
				searchCondition += "시간";

				System.out.println("\t첫번째 시간을 입력해주세요");
				System.out.println("\t[입력 형식 ex. 13:30]");

				String startDate;
				while (true) {
					startDate = CommonView.stringout();

					if (CommonView.stringToDate(startDate) != null) {
						break;
					}
					System.out.print(CommonView.FONT_RED);
					System.out.println("※올바른 형식으로 입력해주세요");
					System.out.println(CommonView.RESET);
				}

				String returnDate;
				while (true) {
					System.out.println("\t두번째 시간을 입력해주세요");
					System.out.println("\t[입력 형식 ex. 13:30]");

					while (true) {
						returnDate = CommonView.stringout();
						if (CommonView.stringToDate(returnDate) != null) {
							break;
						}
					}

					long startT = CommonView.stringToDate(startDate).getTime();
					long returnT = CommonView.stringToDate(returnDate).getTime();

					if (startT < returnT) {
						break;
					}
					System.out.print(CommonView.FONT_RED);
					System.out.println("※~~시간보다 과거는 입력할 수 없습니다");
					System.out.print(CommonView.RESET);

				}
				// 출발시간, 도착시간 인자에 저장
				aiVO.setAirInfoStart(CommonView.stringToDate(startDate));
				aiVO.setAirInfoReturn(CommonView.stringToDate(returnDate));

			}

			System.out.println(CommonView.FONT_BLUE);
			System.out.println("\tQ. 가격으로 검색하시겠습니까?");
			System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
			System.out.println(CommonView.RESET);

			num = CommonView.ok();
			if (num == 1) {
				searchCondition += "가격";
				int min;
				int max;

				while (true) {
					System.out.println();
					System.out.println("\t검색할 최저 가격을 입력해주세요");
					min = CommonView.trycatch();
					if (min >= 0) {
						break;
					}
					System.out.print(CommonView.FONT_RED);
					System.out.println("※양수로 입력해주세요");
					System.out.println(CommonView.RESET);
				}

				while (true) {
					System.out.println("\t검색할 최고 가격을 입력해주세요");
					max = CommonView.trycatch();
					if (max > min) {
						break;
					}
					System.out.print(CommonView.FONT_RED);
					System.out.println("※최저 가격보다 큰 값을 입력해주세요");
					System.out.print(CommonView.RESET);
				}
				aiVO.setAirInfoPrice(min);
				aiVO.setTmpPrice(max);
			}
			if (!searchCondition.equals("")) {
				break;
			}
			printSearchCFalse();
		}

		aiVO.setTmpAirSC(searchCondition);
		return aiVO;
	}

	// ===[항공권
	// 예매]====================================================================================

	// 예매할 번호 입력
	public int getAirbookNum() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■[TryCatch 항공권 예매]■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		System.out.println("\t예매할 항공 번호를 입력해주세요");
		int airNum;
		while (true) {
			airNum = CommonView.trycatch();
			if (airNum > 0) {
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※0보다 큰 수를 입력해주세요");
			System.out.print(CommonView.RESET);
		}

		return airNum;
	}

	// 좌석 등급 선택 ---> 예약 중도 포기시 return 0
	// 1. 이코노미, 2. 비즈니스, 3. 퍼스트
	public AirBookVO getOptionNum(ArrayList<AirDetVO> fdatas) {

		int airNum = 0;

		// 구매될 항공권 ---> 구매 가능한 항공권
		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("해당 항공편에 예매 가능한 항공권이 없습니다...(。・ω・。)");

			return null;
		}

		ArrayList<Integer> detNumList = new ArrayList<Integer>();
		for (AirDetVO v : fdatas) {
			System.out.println(v.toString());
			detNumList.add(v.getAirDetNum());
		}

		System.out.println("\t예매할 항공 상품 번호를 입력해주세요");
		while (true) {
			airNum = CommonView.trycatch();
			if (airNum >= detNumList.get(0) && airNum <= detNumList.get(detNumList.size() - 1)) {
				break;
			}
			CommonView.printFalse();
			System.out.print(CommonView.FONT_RED);
			System.out.println("※해당 항공정보의 상품 번호를 입력해주세요");
			System.out.print(CommonView.RESET);
		}

		int i = detNumList.indexOf(airNum);

		System.out.println("\t예매할 좌석 수량을 입력해주세요");
		int airCnt = -1;
		while (true) {
			airCnt = CommonView.trycatch();
			if (airCnt > 0 && airCnt <= fdatas.get(i).getAirDetCnt()) {
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※올바르게 입력해주세요");
			System.out.print(CommonView.RESET);
		}

		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\t정말 예매하시겠습니까?");
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);

		int num = CommonView.ok();
		if (num == 1) { // 1번 선택시 최종 선택된 name

			String cardNum = getCardNum();

			AirBookVO abVO = new AirBookVO(0, null, airNum, airCnt, null, cardNum);
			return abVO;
		}
		return null;
	}

	// 카드 번호 입력받기
	public String getCardNum() {
		// 16자리 숫자 맞는지
		// 숫자 맞는지
		long cardNum = 0;
		String cardNum2;
		while (true) {
			try {
				while (true) {
					System.out.println();
					System.out.println("\t카드 번호를 입력해주세요");
					cardNum = sc.nextLong();
					if (cardNum > 0) {
						break;
					}
					System.out.print(CommonView.FONT_RED);
					System.out.println("※올바르게 입력해주세요");
					System.out.print(CommonView.RESET);
				}
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.print(CommonView.FONT_RED);
				System.out.println("※올바르게 입력해주세요");
				System.out.print(CommonView.RESET);
				sc.nextLine();
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.print(CommonView.FONT_RED);
				System.out.println("※올바르게 입력해주세요");
				System.out.print(CommonView.RESET);
				sc.nextLine();
			}

			cardNum2 = String.valueOf(cardNum);
			if (cardNum2.length() == 16) {
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※카드 번호는 16자리의 숫자여야 합니다");
			System.out.print(CommonView.RESET);
		}
		return cardNum2;
	}

	// ===[예매 내역 목록
	// 출력]====================================================================================
	public void printAirBookList(ArrayList<AirBookVO> fdatas) {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■[TryCatch 항공권 예매 내역]■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("출력할 항공권이 없습니다...(。・ω・。)");
			return;
		}

		for (AirBookVO v : fdatas) {
			System.out.println(v.toString());
		}
		System.out.println();
		System.out.println("항공권 목록 출력 완료!");
	}

	// ===[예매
	// 변경]====================================================================================
	public int airBookChange(ArrayList<AirBookVO> fdatas) {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■[TryCatch 항공권 예매 변경]■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		int airNum = 0;
		// 취소될 항공권 ---> 취소 가능한 항공권
		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("예매된 항공권이 없습니다...(。・ω・。)");

			return airNum;
		}

		for (AirBookVO v : fdatas) {
			System.out.println(v.toString());
		}

		System.out.println("\t변경할 예약번호를 입력해주세요");
		while (true) {
			airNum = CommonView.trycatch();
			if (airNum > 0) {
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※예약번호는 양수로 입력해주세요");
			System.out.print(CommonView.RESET);
		}

		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\t정말 변경하시겠습니까?");
		System.out.println(CommonView.RESET);
		System.out.println(CommonView.FONT_RED);
		System.out.println("\t※변경 중 비정상접근시 취소될 수 있습니다"); // 문구 변경 가능 ---> 스레드 처리 때문에
		System.out.print(CommonView.RESET);
		System.out.println(CommonView.FONT_BLUE);
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);
		int num = CommonView.ok();
		if (num == 1) { // 1번 선택시 최종 선택된 name
			return airNum;
		}

		airNum = 0;
		return airNum;
	}

	public AirDetVO airBookChangeNew(ArrayList<AirDetVO> fdatas) {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■[TryCatch 항공권 예매 변경]■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		// 변경할(새로 구매될) 항공 상세 번호 저장할 변수
		int airNum = 0;

		// 구매될 항공권 ---> 구매 가능한 항공권
		if (fdatas.isEmpty()) {
			System.out.println(CommonView.FONT_CYAN);
			System.out.println("변경 가능한 항공권이 없습니다...(。・ω・。)");
			System.out.println(CommonView.RESET);

			return null;
		}

		for (AirDetVO v : fdatas) {
			System.out.println(v.toString());
		}

		System.out.println("\t변경할 항공 상품 번호를 입력해주세요");
		while (true) {
			airNum = CommonView.trycatch();
			if (airNum > 0) {
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※항공 상품 번호는 양수로 입력해주세요");
			System.out.print(CommonView.RESET);
		}

		int airCnt = -1;
		System.out.println("변경할 좌석 수를 입력해주세요");
		while (true) {
			airCnt = CommonView.trycatch();
			if (airCnt > 0) {
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※항공 구매 수량은 양수로 입력해주세요");
			System.out.print(CommonView.RESET);
		}

		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\t정말 변경하시겠습니까?");
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);

		int num = CommonView.ok();
		if (num == 1) { // 1번 선택시 최종 선택된 name

			AirDetVO adVO = new AirDetVO(airNum, 0, 0, airCnt);
			return adVO;
		} else {

			return null;
		}
	}

	// ===[예매
	// 취소]====================================================================================

	// 예매 취소할 예약 번호 입력
	// airNum을 0으로 설정 ---> 비정상 종료
	public int airBookCancel(ArrayList<AirBookVO> fdatas) {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■[TryCatch 항공권 예매 취소]■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		int airNum = 0;

		// 예매내역 없을시 취소 진행X
		// airNum을 0으로 설정 ---> 이거 뷰에서 막는 거 맞음? ---> 컨트롤러?
		// 컨트롤러에서 하면 DAO에서 받아온 배열리스트가 널이면 예매실패 출력을 뷰에 요청?
		if (fdatas.isEmpty()) {
			System.out.println(CommonView.FONT_CYAN);
			System.out.println("예매된 항공권이 없습니다...(。・ω・。)");
			System.out.println(CommonView.RESET);

			return airNum;
		}

		for (AirBookVO v : fdatas) {
			System.out.println(v.toString());
		}

		System.out.println("\t취소할 예약번호를 입력해주세요");
		while (true) {
			airNum = CommonView.trycatch();
			if (airNum > 0) {
				break;
			}
			System.out.print(CommonView.FONT_RED);
			System.out.println("※예약번호는 양수로 입력해주세요");
			System.out.print(CommonView.RESET);
		}

		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\t정말 취소하시겠습니까?");
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);

		int num = CommonView.ok();
		if (num == 1) { // 1번 선택시 최종 선택된 name
			return airNum;
		}

		airNum = 0;
		return airNum;
	}

	// ===[회원 정보 변경 /
	// 탈퇴]====================================================================================
	public String checkPasswd(MemberVO mVO) {
		// A. 현재 로그인한 ____님,
		// 비번입력해보세요!~~ (확인절차)
		System.out.print(mVO.getMemberName() + "님 비밀번호입력 ▶ ");
		String mPw = sc.next();
		return mPw;
	}

	// 변경할 비밀번호 입력받기
	public String getNewPasswd(String mPw) {
		// B. 비번불일치시, 실패
		// 비번일치시, 비번변경가능!
		while (true) {
			System.out.println("변경할 비밀번호를 입력해주세요");
			System.out.print("입력 ▶ ");
			String newMpw = sc.next();
			if (!newMpw.equals(mPw)) {
				return newMpw;
			}
		}
	}

	// 불린 반환 요청시 수정
	public boolean checkMdelete() {
		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\t정말 탈퇴 하시겠습니까?");
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);

		int num = CommonView.ok();
		if (num == 1) { // 1번 선택시 최종 선택된 name
			return true;
		}
		return false;
	}

	// ===[성공 / 실패
	// 메서드]====================================================================================

	public void printSignInTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[로그인 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printSignInFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[로그인 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printSignOutTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[로그아웃 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printSignOutFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[로그아웃 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printSignUpTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[회원가입 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printSignUpFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[회원가입 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printBookTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[예매 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printBookFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[예매 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printBookSYSFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n현재 해당 항공편의 예약은 마감되었습니다...(。・ω・。)\n");
		System.out.println(CommonView.RESET);
	}

	public void printBookChangeTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[예매 변경 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printBookChangeFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[예매 변경 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printCancelTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[예매 취소 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printCancelFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[예매 취소 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printChangePassTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[비밀번호 변경 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printChangePassFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println(CommonView.RESET);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[비밀번호 변경 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
	}

	public void printMdeleteTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println(CommonView.RESET);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[회원 탈퇴 성공]...(。・ω・。)\n");
	}

	public void printMdeleteFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println(CommonView.RESET);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[회원 탈퇴 실패]...(。ㅠωㅠ。)\n");
	}

	public void printDeleteSYSFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n현재 해당 항공편은 이미 출발하였습니다...(。・ω・。)\n");
		System.out.println(CommonView.RESET);
	}

	public void printend() {
		System.out.println("\n프로그램을 종료합니다...\n");
	}

	public void printback() {
		System.out.println("\n이전화면으로 돌아갑니다...\n");
	}

	public void printSearchCFalse() {
		System.out.print(CommonView.FONT_RED);
		System.out.println("\n※둘 중 하나의 조건은 선택해주세요!\n");
		System.out.print(CommonView.RESET);
	}

	public void printTicket(AirBookVO abVO) {

		String str1 = " \t☆ " + abVO.getMemberId() + "님 ";
		String str2 = " \t◇ 항공편명: " + abVO.getAirBooknum() + "번 ";
		String str3 = " \t◇ " + abVO.getAirBookCard() + " ▶ " + abVO.getTmpDate() + " ";
		String str4 = " " + abVO.getAirBookDate() + " " + abVO.getTmpStart() + " ~ " + abVO.getTmpReturn() + " ";

		System.out.println();
		System.out.println(CommonView.FONT_CYAN + "\t\t\t┌───────────[예매내역]───────────┐");
		System.out.println(CommonView.FONT_BLUE + "\t\t\t" + String.format("%-30s", str1) + CommonView.RESET);
		System.out.println(CommonView.FONT_BLUE + "\t\t\t" + String.format("%-30s", str2) + CommonView.RESET);
		System.out.println(CommonView.FONT_BLUE + "\t\t\t" + String.format("%-30s", str3) + CommonView.RESET);
		System.out.println(CommonView.FONT_BLUE + "\t\t\t" + String.format("%-30s", str4) + CommonView.RESET);
		System.out.println(CommonView.FONT_CYAN + "\t\t\t└──────────────────────────────┘" + CommonView.RESET);
		System.out.println();

	}

}