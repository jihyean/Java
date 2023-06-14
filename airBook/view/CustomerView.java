package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerView {
	Scanner sc = new Scanner(System.in);
	final static int maxMenuNum = 3;
	final static int maxAirMenuNum = 6;
	final static int maxAirSortMenuNum = 2;
	final static int maxMyPageMenuNum = 6;
	final static int maxAirOptionNum = 3;
	// final static int maxChangeMenuNum = 3; // 비밀번호만 변경하기로

//===[모듈화]====================================================================================

	// 정수 유효성 모듈화
	private int trycatch() {
		while (true) {
			try {
				System.out.println("입력: ");
				int action = sc.nextInt();
				return action;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로 입력해주세요");
			}
		}
	}

	private String stringout() {

		while (true) {
			try {
				System.out.print("입력: ");
				String str = sc.next();
				return str;
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("올바른 형식으로 입력해주세요");
			}
		}

	}

	// 확인 모듈화
	private int ok() {
		while (true) {
			try {
				int action = sc.nextInt();
				// 입력받은 값이 1과 2만 허용
				if (action <= 2 && action >= 1) {
					// 2를 입력받았다면 다시 입력
					if (action == 2) {
						System.out.println("다시 입력해주세요!");
					}
					// 1을 입력받았다면 입력받은 값 리턴해서 코드 계속 진행
					return action;

				}
				// 입력받은 값이 1,2가 아니라면
				// 번호 재입력 시키기
				System.out.println("유효하지 않은 값입니다");
				System.out.println("다시 입력해주세요!");

				// 정수 이외의 값이 들어오면 재입력 시키기
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수로 입력해주세요!");
			}
		}
	}

	// java.lang.StringIndexOutOfBoundsException 처리
	private static Date stringToDate(String str) {
		String HHStr = str.substring(0, str.lastIndexOf(":"));

		int HH = Integer.parseInt(HHStr);

		String mmStr = str.substring(str.lastIndexOf(":") + 1);
		int mm = Integer.parseInt(mmStr);

		if ((HH > 23) || (HH < 00)) {
			return null;
		}

		if ((mm > 59) || (mm < 00)) {
			return null;
		}

		Date date = new Date(0000, 0, 0, HH, mm, 0);
		return date;
	}

//===[메뉴 출력]====================================================================================

	// 메뉴 출력
	public void printStart() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공예약]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}

	public int printMenu() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 프로그램]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 프로그램 종료");

		while (true) {
			int menuNum = trycatch();

			if (menuNum <= maxMenuNum && menuNum > 0) {
				return menuNum;
			}
			System.out.println("프로그램 메뉴중에 선택해주세요");
		}
	}

	public int printAirMenu() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공프로그램]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 항공권 목록 출력");
		System.out.println("2. 정렬 출력(인기순, 날짜순)");
		System.out.println("3. 필터 검색(가격, 날짜)");
		System.out.println("4. 마이페이지");
		System.out.println("5. 로그아웃");

		while (true) {
			int menuNum = trycatch();

			if (menuNum <= maxAirMenuNum && menuNum > 0) {
				return menuNum;
			}
			System.out.println("프로그램 메뉴중에 선택해주세요");
		}
	}

	public int printSortMenu() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 프로그램]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 항공권 날짜순");
		System.out.println("2. 항공권 인기순");

		while (true) {
			int menuNum = trycatch();

			if (menuNum <= maxAirSortMenuNum && menuNum > 0) {
				return menuNum;
			}
			System.out.println("프로그램 메뉴중에 선택해주세요");
		}
	}

	public int printMypageMenu() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 마이페이지]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 예약내역 확인");
		System.out.println("2. 예약 변경");
		System.out.println("3. 예약 취소");
		System.out.println("4. 회원 정보 변경");
		System.out.println("5. 회원 탈퇴");
		System.out.println("6. 이전으로 돌아가기"); // 로그아웃 혹은 항공메뉴로 돌아가기

		while (true) {
			int menuNum = trycatch();

			if (menuNum <= maxMyPageMenuNum && menuNum > 0) {
				return menuNum;
			}
			System.out.println("프로그램 메뉴중에 선택해주세요");
		}
	}

//===[메서드]====================================================================================

	// 회원 가입
	public MemberVO printSignUp() {
		String mId;
		String mPw;
		String mName;

		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 회원가입]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		System.out.println("아이디를 입력해주세요");
		while (true) {
			mId = sc.next();

			if (mId.getBytes().length < 25) { // 길이 25바이트까지 varchar(25)
				// return id;
			}
			System.out.println("길이가 너무 깁니다!");
		}

		System.out.println("비밀번호를 입력해주세요");
		while (true) {
			mPw = sc.next();

			if (mPw.getBytes().length < 30) { // 길이 30바이트까지 varchar(30)
				// return passwd;
			}
			System.out.println("길이가 너무 깁니다!");
		}

		System.out.println("이름을 입력해주세요");
		while (true) {
			mName = sc.next();

			if (mName.getBytes().length < 25) { // 길이 30바이트까지 varchar(30)
				// return name;
			}
			System.out.println("길이가 너무 깁니다!");
		}

		MemberVO mVO = new MemberVO(mId, mPw, mName);
		return mVO;
	}

	// 로그인
	public MemberVO signin() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 로그인]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		System.out.print("아이디입력: ");
		String mId = sc.next();
		System.out.print("비밀번호입력: ");
		String mPw = sc.next();
		MemberVO mVO = new MemberVO(mId, mPw, null);
		return mVO;
	}

//===[목록 출력]====================================================================================

	// 전체 목록 출력
	public void printAirList(ArrayList<AirInfoVO> fdatas) {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공권 목록]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("출력할 항공권이 없습니다");
			return;
		}

		for (AirInfoVO v : fdatas) {
			System.out.println(v.toString());
		}
		System.out.println();
		System.out.println("항공권 목록 출력 완료!");
	}

	// 인기순 목록 출력
	public void printAirSortLike(ArrayList<AirInfoVO> fdatas) {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공권 인기순]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("출력할 항공권이 없습니다");
			return;
		}

		for (AirInfoVO v : fdatas) {
			System.out.println(v.toString());
		}
		System.out.println();
		System.out.println("항공권 목록 출력 완료!");
	}

	// 날짜순(시간순) 목록 출력
	public void printAirSortDate(ArrayList<AirInfoVO> fdatas) {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공권 날짜순]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("출력할 항공권이 없습니다");
			return;
		}

		for (AirInfoVO v : fdatas) {
			System.out.println(v.toString());
		}
		System.out.println();
		System.out.println("항공권 목록 출력 완료!");
	}

//===[필터 검색]====================================================================================
	//////////////////////////////////// Date 타입, 리턴
	// 필터검색: 날짜,가격으로 검색하기
	public AirInfoVO getFilterSearch() {
		AirInfoVO aiVO = new AirInfoVO();
		String searchCondition = "";

		System.out.println("Q. 항공 시간으로 검색하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		int num = sc.nextInt();
		if (num == 1) {
			searchCondition += "시간";

			System.out.println("시간을 입력해주세요");
			System.out.println("입력 형식 ex. 13:30");
			String startDate = stringout();
			
			System.out.println("시간을 입력해주세요");
			System.out.println("입력 형식 ex. 13:30");
			String returnDate = stringout();

			aiVO.setAirInfoStart(stringToDate(startDate));
			aiVO.setAirInfoStart(stringToDate(returnDate));
		}

		System.out.println("Q. 가격으로 검색하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		num = sc.nextInt();
		if (num == 1) {
			searchCondition += "가격";
			System.out.print("검색할 최저가격입력: ");
			int min = sc.nextInt();
			System.out.print("검색할 최고가격입력: ");
			int max = sc.nextInt();
			aiVO.setPrice(min);
			aiVO.setTmp(max);
		}
		return aiVO;
	}

//===[항공권 예매]====================================================================================	

	// 예매할 번호 입력
	public int printAbook() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공권 예매]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		System.out.println("예매할 항공 번호를 입력해주세요");
		int airNum = trycatch();

		return airNum;
	}

	// 좌석 등급 선택 ---> 예약 중도 포기시 return 0
	// 1. 이코노미, 2. 비즈니스, 3. 퍼스트
	public int getOptionNum() { // AirDeptVO
		System.out.println("좌석등급을 선택해주세요");

		while (true) {
			int airOptNum = trycatch();
			// 1~3만 선택 가능
			// 1. 이코노미, 2. 비즈니스, 3. 퍼스트
			if (airOptNum > 0 && airOptNum <= maxAirOptionNum) {

				System.out.println("정말 예약하시겠습니까?");
				int action = ok();
				if (action == 1) {
					return airOptNum;
				} else {
					System.out.println("예약을 취소하셨습니다");
					airOptNum = 0;
					return airOptNum;
				}
			}
		}
	}

	// 카드 번호 입력받기
	public String getCardNum() {
		// 16자리 숫자 맞는지
		// 숫자 맞는지
		long cardNum = 0;
		String cardNum2;
		while (true) {
			System.out.println();
			System.out.println("카드 번호를 입력해주세요");
			try {
				cardNum = sc.nextLong();
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("올바르게 입력해주세요");
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("길이를 확인해주세요");
			}

			cardNum2 = String.valueOf(cardNum);
			if (cardNum2.length() == 16) {
				break;
			}
			System.out.println("카드 번호는 16자리의 숫자여야 합니다");
		}
		return cardNum2;
	}

//===[예매 내역 목록 출력]====================================================================================
	public void printAirBookList(ArrayList<AirBookVO> fdatas) {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공권 예매내역]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("출력할 항공권이 없습니다");
			return;
		}

		for (AirBookVO v : fdatas) {
			System.out.println(v.toString());
		}
		System.out.println();
		System.out.println("항공권 목록 출력 완료!");
	}

//===[예매 취소]====================================================================================	

	// 예매 취소할 예약 번호 입력
	// airNum을 0으로 설정 ---> 비정상 종료
	public int printAbookCancel(ArrayList<AirBookVO> fdatas) {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공권 예매취소]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		int airNum = 0;

		// 예매내역 없을시 취소 진행X
		// airNum을 0으로 설정 ---> 이거 뷰에서 막는 거 맞음? ---> 컨트롤러?
		// 컨트롤러에서 하면 DAO에서 받아온 배열리스트가 널이면 예매실패 출력을 뷰에 요청?
		if (fdatas.isEmpty()) {
			System.out.println();
			System.out.println("예매된 항공권이 없습니다");

			return airNum;
		}

		System.out.println("취소할 예약번호를 입력해주세요");
		airNum = trycatch();

		System.out.println("정말 취소하시겠습니까?");
		System.out.println("1. 예 2. 아니오");
		System.out.print("입력: ");
		int num = ok();
		if (num == 1) { // 1번 선택시 최종 선택된 name
			return airNum;
		}

		airNum = 0;
		return airNum;
	}

//===[회원 정보 변경 / 탈퇴]====================================================================================
	public String checkPasswd(MemberVO mVO) {
		// A. 현재 로그인한 ____님,
		// 비번입력해보세요!~~ (확인절차)
		System.out.println(mVO.getMName() + "님 비번입력) ");
		String mpw = sc.next();
		return mpw;
	}

	// 변경할 비밀번호 입력받기
	public String getNewPasswd(String mpw) {
		// B. 비번불일치시, 실패
		// 비번일치시, 비번변경가능!
		while (true) {
			System.out.println("변경할 비밀번호를 입력해주세요");
			System.out.print("입력: ");
			String newMpw = sc.next();
			if (!newMpw.equals(mpw)) {
				return newMpw;
			}
		}
	}
	
	// 불린 반환 요청시 수정
	public boolean checkMdelete() {
		System.out.println("정말 탈퇴 하시겠습니까?");
		System.out.println("1. 예 2. 아니오");
		System.out.print("입력: ");
		int num = ok();
		if (num == 1) { // 1번 선택시 최종 선택된 name
			return true;
		}
		return false;
	}
	
	

//===[성공 / 실패 메서드]====================================================================================

	public void printSignInTrue() {
		System.out.println("로그인 성공");
	}

	public void printSignInFalse() {
		System.out.println("로그인 실패");
	}

	public void printSignUpTrue() {
		System.out.println("회원가입 성공");
	}

	public void printSignUpFalse() {
		System.out.println("회원가입 실패");
	}

	public void printBookTrue() {
		System.out.println("예매 성공");
	}

	public void printBookFalse() {
		System.out.println("예매 실패");
	}

	public void printBookChangeTrue() {
		System.out.println("예매내역 변경 성공");
	}

	public void printBookChangeFalse() {
		System.out.println("예매내역 변경 실패");
	}

	public void printCancelTrue() {
		System.out.println("예매취소 성공");
	}

	public void printCancelFalse() {
		System.out.println("예매취소 실패");
	}

	public void printChangePassTrue() {
		System.out.println("비밀번호 변경 성공");
	}

	public void printChangePassFalse() {
		System.out.println("비밀번호 변경 실패");
	}

	public void printMdeleteTrue() {
		System.out.println("회원 탈퇴 성공");
	}

	public void printMdeleteFalse() {
		System.out.println("회원 탈퇴 실패");
	}
	
	public void printend() {
		System.out.println("프로그램을 종료합니다");
	}

}
