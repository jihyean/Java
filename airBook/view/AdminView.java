package view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminView {
	Scanner sc = new Scanner(System.in);
	final static int maxAdminMenuNum = 4;
	
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

//===[메서드]====================================================================================
	public int printAdminMenu() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 관리자 프로그램]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 항공 정보 변경");
		System.out.println("2. 잔여 좌석 변경");
		System.out.println("3. 항공 상품 삭제");
		System.out.println("4. 프로그램 종료 || 관리자 모드 종료"); // 합의 좀
		
		while(true) {		
			int action = trycatch();
			if(action > 0 && action <= maxAdminMenuNum) {
				return action;
			}
		}
		
	}
	
	public int printAirChange() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공 상품 변경]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		System.out.println("변경할 항공 상품 번호를 입력해주세요");
		
		int airNum = trycatch();
		
		return airNum;
	}
	
	public AirInfoVO getAirNum() {
		
		AirInfoVO aiVO = new AirInfoVO();
		String searchCondition = "";

		System.out.println("Q. 항공 시간으로 검색하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		int num = sc.nextInt();
		if (num == 1) {
			searchCondition += "시간";

			System.out.println("변경할 출발 시간을 입력해주세요");
			System.out.println("입력 형식 ex. 13:30");
			String startDate = stringout();
			
			// 유효성 ---> 출발이 더 과거여야 함
			System.out.println("변경할 도착 시간을 입력해주세요");
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
			int price = sc.nextInt();
			aiVO.setPrice(price);
		}
		return aiVO;
		
	}
	
	public int printAirOption() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 잔여 좌석 관리]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		System.out.println("변경할 잔여 좌석 번호를 입력해주세요");
		
		int airDeptNum = trycatch();
		
		return airDeptNum;
	}
	
	// 잔여좌석 변경 실패 혹은 취소시 ---> airCnt==-1
	public int getAirDept() {
		System.out.println("변경할 잔여좌석을 입력해주세요"); // 변경할 양 입력
		System.out.println("(음수 입력시 잔여 좌석이 감소합니다)");
		
		int airCnt = trycatch();
		
		System.out.println("정말 변경하시겠습니까?");
		
		int num = ok();
		if (num == 1) {
			return airCnt;
		}
		else {
			System.out.println("잔여좌석 변경을 취소했습니다");
			airCnt = -1;
			return airCnt;
		}
	}
	
	// 삭제할 상품 입력 받기 실패시 ---> airNum == 0;
	public int getDeleteAirNum() {
		System.out.println("삭제할 항공상품을 입력해주세요"); // 변경할 양 입력
		
		int airNum = trycatch();
		
		System.out.println("정말 삭제하시겠습니까?");
		
		int num = ok();
		if (num == 1) {
			return airNum;
		}
		else {
			System.out.println("항공 상품 삭제를 취소했습니다");
			airNum = 0;
			return airNum;
		}
	}
//===[성공 / 실패 메서드]====================================================================================

	public void printAirChangeTrue() {
		System.out.println("항공 상품 변경 성공");
	}

	public void printAirChangeFalse() {
		System.out.println("항공 상품 변경 실패");
	}
	
	public void printAirCntTrue() {
		System.out.println("잔여 좌석 변경 성공");
	}

	public void printAirCntFalse() {
		System.out.println("잔여 좌석 변경 실패");
	}
	
	public void printAirDeleteTrue() {
		System.out.println("항공 상품 삭제 성공");
	}

	public void printAirDeleteFalse() {
		System.out.println("항공 상품 삭제 실패");
	}
	
	public void printend() {
		System.out.println("관리자 모드를 종료합니다");
	}
	

}
