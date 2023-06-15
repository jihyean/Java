package view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonView {
	
	static Scanner sc = new Scanner(System.in);
	
// ===[모듈화]====================================================================================

	// 정수 유효성 모듈화
	public static int trycatch() {
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

	public static String stringout() {
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
	public static int ok() {
		while (true) {
			try {
				int action = trycatch();
				// 입력받은 값이 1과 2만 허용
				if (action == 1 || action == 2) {
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
	public static Date stringToDate(String str) {
		String HHStr = str.substring(0, str.lastIndexOf(":"));

		int HH = Integer.parseInt(HHStr);

		String mmStr = str.substring(str.lastIndexOf(":") + 1);
		int mm = Integer.parseInt(mmStr);

		// 사용자가 23시 초과 혹은 음수로 시간(Hours)를 입력시 유효성
		if ((HH > 23) || (HH < 00)) {
			return null;
		}
		
		// 사용자가 59분 초과 혹은 음수로 분(Time)을 입력시 유효성
		if ((mm > 59) || (mm < 00)) {
			return null;
		}

		Date date = new Date(0000, 0, 0, HH, mm, 0);
		return date;
	}
}
