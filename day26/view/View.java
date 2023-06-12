package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.ProductVO;

public class View {
	private static Scanner sc=new Scanner(System.in);
	
	// 어떤기능이 가능한지 보여주기
	public int printMenu() {
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 상품목록출력");
		System.out.println("2. 상품검색"); // 실습(이름,가격으로 검색하기)
		System.out.println("3. 상품구매");
		System.out.println("4. 회원가입");
		System.out.println("5. 로그인");
		System.out.println("6. 로그아웃");
		System.out.println("7. 회원비번변경"); // 실습
		System.out.println("8. 회원탈퇴");
		System.out.println("9. 프로그램 종료");
		System.out.print("입력) ");
		int action=sc.nextInt();
		return action;
	}
	
	// 상품목록출력
	public void printList(ArrayList<ProductVO> pdatas) {
		System.out.println("=== 목록출력 ===");
		if(pdatas.isEmpty()) {
			System.out.println("출력할 리스트 없음!");
			return;
		}
		for(ProductVO pdata:pdatas) {
			System.out.println(pdata);
		}
	}
	
	// 상품선택
	public int getNum() {
		System.out.print("상품번호입력) ");
		int num=sc.nextInt();
		return num;
	}
	public void printData(ProductVO pdata) {
		if(pdata==null) {
			System.out.println("출력할 데이터 없음!");
			return;
		}
		System.out.println(pdata);
	}
	
	public void printTrue() {
		System.out.println("성공!");
	}
	public void printFalse() {
		System.out.println("실패.....");
	}
	
	// 회원가입
	// 로그인
	public MemberVO signin() {
		System.out.print("아이디입력) ");
		String mid=sc.next();
		System.out.print("비밀번호입력) ");
		String mpw=sc.next();
		MemberVO mVO=new MemberVO(mid,mpw);
		return mVO;
	}

	public String getPass() {
		System.out.print("비밀번호입력) ");
		String mpw=sc.next();
		return mpw;
	}
	
	public int searchMenuNum() {
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 이름으로 검색");
		System.out.println("2. 가격으로 검색");
		
		int menuNum = sc.nextInt();
		
		return menuNum;
	}
	
	public String getName() {
		System.out.println("검색할 상품이름을 입력해주세요");
		System.out.print("입력: ");
		String pName = sc.next();
		
		return pName;
	}
	
	public ProductVO getPrice() {
		System.out.println("검색할 상품 가격을 입력해주세요");
		System.out.print("입력: ");
		int price = sc.nextInt();
		System.out.print("입력: ");
		int cnt = sc.nextInt();
		
		if(price < cnt) {
			int tmp = price;
			price = cnt;
			cnt = tmp;
		}
		
		ProductVO pVO = new ProductVO(0, null, cnt, price);
		return pVO;
	}
}
















