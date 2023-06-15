package view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminView {
	static Scanner sc = new Scanner(System.in);
	final static int maxAdminMenuNum = 4;

//===[메서드]====================================================================================
	public int getAdminMenu() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 관리자 프로그램]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 항공 정보 변경");
		System.out.println("2. 잔여 좌석 변경");
		System.out.println("3. 항공 상품 삭제");
		System.out.println("4. 프로그램 종료 || 관리자 모드 종료"); // 합의 좀

		while (true) {
			int action = CommonView.trycatch();
			if (action > 0 && action <= maxAdminMenuNum) {
				return action;
			}
		}

	}

	public int getAirChangeNum() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 항공 상품 변경]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		System.out.println("변경할 항공 상품 번호를 입력해주세요");

		int airNum;
		while (true) {
			airNum = CommonView.trycatch();
			if (airNum > 0) {
				break;
			}
			System.out.println("양수로 입력해주세요");
		}

		return airNum;
	}

	public AirInfoVO getFilterChange() {

		AirInfoVO aiVO = new AirInfoVO();
		String searchCondition = "";

		System.out.println("Q. 항공 시간을 변경하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		int num = sc.nextInt();
		if (num == 1) {
			searchCondition += "시간";

			System.out.println("시간을 입력해주세요");
			System.out.println("입력 형식 ex. 13:30");
			String startDate = CommonView.stringout();
			String returnDate;
			while (true) {
				System.out.println("시간을 입력해주세요");
				System.out.println("입력 형식 ex. 13:30");
				returnDate = CommonView.stringout();

				long startT = CommonView.stringToDate(startDate).getTime();
				long returnT = CommonView.stringToDate(returnDate).getTime();

				if (startT < returnT) {
					break;
				}
				System.out.println("~~시간보다 과거는 입력할 수 없습니다");

			}
			// 출발시간, 도착시간 인자에 저장
			aiVO.setAirInfoStart(CommonView.stringToDate(startDate));
			aiVO.setAirInfoStart(CommonView.stringToDate(returnDate));
		}

		System.out.println("Q. 가격을 변경하시겠습니까?");
		System.out.print("1.YES  2.NO ");
		num = CommonView.ok();
		if (num == 1) {
			searchCondition += "가격";
			System.out.print("검색할 최저가격입력: ");
			int price;
			while (true) {
				price = CommonView.trycatch();
				if (price > 0) {
					break;
				}
				System.out.println("예약번호는 양수로 입력해주세요");
			}
			aiVO.setPrice(price);
		}
		return aiVO;

	}

	public int getAirOption() {
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■[TryCatch 잔여 좌석 관리]■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		System.out.println("변경할 잔여 좌석 번호를 입력해주세요");

		int airDeptNum;
		while (true) {
			airDeptNum = CommonView.trycatch();
			if (airDeptNum > 0) {
				break;
			}
			System.out.println("양수로 입력해주세요");
		}

		return airDeptNum;
	}

	// 잔여좌석 변경 실패 혹은 취소시 ---> airCnt==-1
	public int getAirDept() {
		System.out.println("변경할 잔여좌석을 입력해주세요"); // 변경할 양 입력
		System.out.println("(음수 입력시 잔여 좌석이 감소합니다)");

		int airCnt = CommonView.trycatch();

		System.out.println("정말 변경하시겠습니까?");

		int num = CommonView.ok();
		if (num == 1) {
			return airCnt;
		} else {
			System.out.println("잔여좌석 변경을 취소했습니다");
			airCnt = -1;
			return airCnt;
		}
	}

	// 삭제할 상품 입력 받기 실패시 ---> airNum == 0;
	public int getDeleteAirNum() {
		System.out.println("삭제할 항공상품을 입력해주세요"); // 변경할 양 입력

		int airNum = CommonView.trycatch();

		System.out.println("정말 삭제하시겠습니까?");

		int num = CommonView.ok();
		if (num == 1) {
			return airNum;
		} else {
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