package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.DrinkVO;

public class DrinkView {
	private static final int maxMenuNum = 4; //메뉴가 4개
	private static Scanner sc = new Scanner(System.in); //스캐너
	
	public void printMenu() {
		System.out.println("===자판기 프로그램===");
		System.out.println("1. 음료 추가");
		System.out.println("2. 음료 목록 출력");
		System.out.println("3. 음료 구매");
		System.out.println("4. 음료 삭제");
	}
	
	public int checkInput() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				int input = sc.nextInt();
				return input;
			}
			 catch(InputMismatchException e) {
				 sc.nextLine();
				 System.out.println("정수로 입력해주세요");
			 }
		}
	}
	
	// 사용자 입력 저장
	public int getMenuNum() {
		int menuNum;
		while (true) {
			try {
				System.out.println("입력: ");
				menuNum = sc.nextInt();
				break;
				
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println();
			}
		}
		if (1 <= menuNum && menuNum <= 4) {
			return menuNum;
		}
		return menuNum;
	}

	// 음료 목록 출력
	public void printDrinkList(ArrayList<DrinkVO> datas) {
		System.out.println("===음료 목록 출력===");
	      for(DrinkVO v:datas) {
	         System.out.println(v);
	      }
	}

	// 사용자가 입력한 번호 저장
	public int getDrinkNum() {
		System.out.println("번호 입력: ");
		int num = checkInput();
		return num;
	}

	// 사용자가 입력한 이름 저장
	public String getDrinkName() {
		System.out.println("이름 입력: ");
		String name = sc.next();
		return name;
	}

	// 사용자가 입력한 가격 저장
	public int getDrinkPrice() {
		System.out.println("가격 입력: ");
		int price = checkInput();
		return price;
	}

	// 사용자가 입력한 재고 저장
	public int getDrinkCnt() {
		System.out.println("재고 입력: ");
		int cnt = checkInput();
		return cnt;
	}

	// 음료 추가 시작멘트
	public void printInfo_C_Start() {
		System.out.println("음료 추가를 시작합니다");
	}

	// 음료 추가 종료 멘트
	public void printInfo_C_End() {
		System.out.println("음료가 추가를 종료합니다");
	}

	// 음료 구매 시작멘트
	public void printInfo_S_Start() {
		System.out.println("음료가 구매가 시작됩니다");
	}

	// 음료 구매 종료 멘트
	public void printInfo_S_End() {
		System.out.println("음료가 구매되었습니다");
	}

	// 음료 삭제 시작멘트
	public void printInfo_D_Start() {
		System.out.println("음료 삭제를 시작합니다");
	}

	// 음료 삭제 종료 멘트
	public void printInfo_D_End() {
		System.out.println("음료 삭제되었습니다");
	}

}
