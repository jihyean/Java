package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.ProductVO;

public class View {
	Scanner sc = new Scanner(System.in);
	final static int MENUNUM = 6;
	
	public int trycatch() {
		
		System.out.println("입력: ");
		int num;
		
		while(true) {			
			try {	
				num = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수만 입력해주세요");
			}
		}
		return num;
	}

	public void printCrawlingInfo() {
		System.out.println("올리브영 데이터 프로그램입니다.");
		System.out.println("샘플 데이터를 크롤링합니다...");
	}
	
	
	public void printMenu() {
		System.out.println("====== 메뉴 ======");
		System.out.println("1. 상품 목록 출력");
		System.out.println("2. 상품 검색");
		System.out.println("3. 상품 이름으로 검색");
		System.out.println("4. 상품 변경");
		System.out.println("5. 상품 삭제");
		System.out.println("6. 프로그램 종료");
	}
	
	public int getMenuNum() {
		System.out.println("실행할 메뉴를 선택해주세요");		
		int menuNum;
		
		while(true) {	
			menuNum = trycatch();
			
			if(menuNum > 0 && menuNum <=MENUNUM) {
				break;
			}
			System.out.println("메뉴 중에 선택해주세요");
		}
		
		return menuNum;
	}

	public void printTrue() {
		System.out.println("작업 성공!");
	}

	public void printFalse() {
		System.out.println("작업 실패.....");
	}

	public void printList(ArrayList<ProductVO> datas) {
		System.out.println();
		
		if(datas.isEmpty()) {
			System.out.println("상품이 없습니다");
		}
		
		System.out.println("============================== 상품목록출력 ==============================");
		for (ProductVO data : datas) {
			System.out.println(data);
		}
		System.out.println();
	}
	
	public int getNum() {
		System.out.println("상품 번호를 입력해주세요");
		int productNum = trycatch();
		
		return productNum;		
	}
	
	public String getName() {
		System.out.println("이름을 입력해주세요");
		System.out.print("입력: ");
		String name = sc.nextLine();
		sc.nextLine();
		
		return name;
	}
	
	public void printNoProduct() {
		System.out.println();
		System.out.println("해당 상품이 없습니다");
	}
	
	public void printProduct(ProductVO pVO) {

		System.out.println(pVO.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
