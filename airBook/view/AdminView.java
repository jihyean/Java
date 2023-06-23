package view;

import java.util.Scanner;

import model.AirInfoVO;

public class AdminView {
	static Scanner sc = new Scanner(System.in);
	final static int maxAdminMenuNum = 4;

//===[메서드]====================================================================================
	public int getAdminMenu() {

		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■[TryCatch  관리자 프로그램]■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		System.out.println(CommonView.FONT_BLUE);
		System.out.printf("%20s %15s %15s %15s", "[1]항공 정보 변경", "[2]잔여 좌석 변경", "[3]항공 상품 삭제", "[4]관리자 모드 종료\n");
		System.out.println(CommonView.RESET);

		while (true) {
			int action = CommonView.trycatch();
			if (action > 0 && action <= maxAdminMenuNum) {
				return action;
			}
		}

	}

	public int getAirChangeNum() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■[TryCatch 항공 상품 변경]■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		System.out.println("\t변경할 항공 상품 번호를 입력해주세요");

		int airNum;
		while (true) {
			airNum = CommonView.trycatch();
			if (airNum > 0) {
				break;
			}
			System.out.println(CommonView.FONT_RED);
			System.out.println("※양수로 입력해주세요");
			System.out.println(CommonView.RESET);
		}

		return airNum;
	}

	public AirInfoVO getFilterChange() {

		AirInfoVO aiVO = new AirInfoVO();
		String searchCondition = "";

		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\tQ. 항공 시간을 변경하시겠습니까?");
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);

		int num = CommonView.ok();
		if (num == 1) {
			searchCondition += "시간";

			System.out.println("\t출발 시간을 입력해주세요");
			System.out.println("\t[입력 형식 ex. 13:30]");

			String startDate;
			while (true) {
				startDate = CommonView.stringout();

				if (CommonView.stringToDate(startDate) != null) {
					break;
				}
				System.out.println(CommonView.FONT_RED);
				System.out.println("※올바른 형식으로 입력해주세요");
				System.out.println(CommonView.RESET);
			}

			String returnDate;
			while (true) {
				System.out.println("\t도착 시간을 입력해주세요");
				System.out.println("\t[입력 형식 ex. 13:30]");

				while (true) {
					returnDate = CommonView.stringout();
					if (CommonView.stringToDate(returnDate) != null) {
						break;
					}
					System.out.println(CommonView.FONT_RED);
					System.out.println("※올바른 형식으로 입력해주세요");
					System.out.println(CommonView.RESET);
				}

				long startT = CommonView.stringToDate(startDate).getTime();
				long returnT = CommonView.stringToDate(returnDate).getTime();

				if (startT < returnT) {
					break;
				}
				System.out.println(CommonView.FONT_RED);
				System.out.println("※~~시간보다 과거는 입력할 수 없습니다");
				System.out.println(CommonView.RESET);

			}
			// 출발시간, 도착시간 인자에 저장
			aiVO.setAirInfoStart(CommonView.stringToDate(startDate));
			aiVO.setAirInfoReturn(CommonView.stringToDate(returnDate));
		}

		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\tQ. 가격을 변경하시겠습니까?");
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);

		num = CommonView.ok();
		if (num == 1) {
			searchCondition += "가격";
			System.out.println("\t변경할 가격을 입력해주세요 ");

			int price;
			while (true) {
				price = CommonView.trycatch();
				if (price > 0) {
					break;
				}
				System.out.println(CommonView.FONT_RED);
				System.out.println("※가격은 양수로 입력해주세요");
				System.out.println(CommonView.RESET);
			}
			aiVO.setTmpPrice(price);
		}

		aiVO.setTmpAirSC(searchCondition);
		return aiVO;

	}

	public int getAirOption() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■[TryCatch 잔여 좌석 관리]■■■■■■■■■■■■■■");
		System.out.println("\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(CommonView.RESET);

		System.out.println("\t잔여 좌석을 변경할 항공상세 번호를 입력해주세요");

		int airDeptNum;
		while (true) {
			airDeptNum = CommonView.trycatch();
			if (airDeptNum > 0) {
				break;
			}
			System.out.println(CommonView.FONT_RED);
			System.out.println("※양수로 입력해주세요");
			System.out.println(CommonView.RESET);
		}

		return airDeptNum;
	}

	// 잔여좌석 변경 실패 혹은 취소시 ---> airCnt==-1
	public int getAirDept() {
		System.out.println("\t변경할 잔여좌석을 입력해주세요"); // 변경할 양 입력
		System.out.println(CommonView.FONT_RED);
		System.out.println("\t※음수 입력시 잔여 좌석이 감소합니다");
		System.out.println(CommonView.RESET);

		int airCnt = CommonView.trycatch();

		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\t정말 변경하시겠습니까?");
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);

		int num = CommonView.ok();
		if (num == 1) {
			return airCnt;
		} else {
			System.out.println(CommonView.FONT_RED);
			System.out.println("※잔여좌석 변경을 취소했습니다");
			System.out.println(CommonView.RESET);
			airCnt = 0;
			return airCnt;
		}
	}

	// 삭제할 상품 입력 받기 실패시 ---> airNum == 0;
	public int getDeleteAirNum() {
		System.out.println("\t삭제할 항공상품을 입력해주세요"); // 변경할 양 입력

		int airNum;
		while (true) {
			airNum = CommonView.trycatch();
			if (airNum > 0) {
				break;
			}
			System.out.println(CommonView.FONT_RED);
			System.out.println("※음수는 입력할 수 없습니다");
			System.out.println(CommonView.RESET);
		}

		System.out.println(CommonView.FONT_BLUE);
		System.out.println("\t정말 삭제하시겠습니까?");
		System.out.printf("%20s %15s", "[1]YES", "[2]NO\n");
		System.out.println(CommonView.RESET);

		int num = CommonView.ok();
		if (num == 1) {
			return airNum;
		} else {
			System.out.println(CommonView.FONT_RED);
			System.out.println("※항공 상품 삭제를 취소했습니다");
			System.out.println(CommonView.RESET);
			airNum = 0;
			return airNum;
		}
	}
//===[성공 / 실패 메서드]====================================================================================

	public void printAirChangeTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[항공 상품 변경 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printAirChangeFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[항공 상품 변경 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printAirCntTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[잔여 좌석 변경 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printAirCntFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[잔여 좌석 변경 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printAirDeleteTrue() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[항공 상품 삭제 성공]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printAirDeleteFalse() {
		System.out.println(CommonView.FONT_CYAN);
		System.out.println("\n\t。★˚。★˙☆*。★☆*。★˚[항공 상품 삭제 실패]☆*。★☆。˙＊☆★。☆˚*。\n");
		System.out.println(CommonView.RESET);
	}

	public void printend() {
		System.out.println("관리자 모드를 종료합니다...");
	}

}