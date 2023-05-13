package class04;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		//자판기
		String[] mName = new String[3];
		mName[0]="아메리카노";
		mName[1]="카푸치노";
		mName[2]="아이스티";
		
		int[] mPrice = new int[3];
		mPrice[0]=2500;
		mPrice[1]=4500;
		mPrice[2]=3000;
		
		int[] mCnt = new int[3];
		mCnt[0]=100;
		mCnt[1]=10;
		mCnt[2]=2;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {//종료조건 일부러 안넣음
			System.out.println("===== 메뉴판 =====");
			for(String v:mName) {
				System.out.println(v);
			}
			System.out.println("==================");
			
			System.out.println("먹고싶은 메뉴를 선택하세요");
			int uNum=sc.nextInt();		//아메리카노
			int uCnt=10;	//10개 구매
			
			if(uCnt>mCnt[uNum-1]) {
				System.out.println("재고가 부족합니다");
				break;
			}
			
			System.out.println(mName[uNum-1]+"메뉴를 구매했습니다");
			System.out.println(uCnt+"개 구매했습니다");
			System.out.println("총 금액: "+uCnt*mPrice[uNum-1]);
			mCnt[uNum-1]-=uCnt;
			
			
			
		}
	}

}
