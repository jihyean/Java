package class01;

import java.util.Random;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
//		[자판기 프로그램 작성하기]
//				1. 상품은 4개
//				2. 이름은 정하되
//				3. 가격,재고 랜덤으로 설정
//				4. 1-구매, 2-종료
//				5. 상품목록을 재고와 함께 출력해주세요!
//				단, '재고가 없는 상품은 출력하지않습니다!'
//				   ex) 1-콜라[3] 2-사이다[재고없음] 3-환타[4]
//				 1 입력시 -> 몇개구매?
//				 2 입력시 -> 재고가없어서 구매가 불가능합니다!
//				 4 입력시 -> 없는 상품입니다!
//				6. 그 외에는 모두 연습문제와 동일하게 진행해주세요!~~

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Random rand = new Random();

		int N = 4; // 메뉴의 개수

		String[] mName = new String[N]; // 메뉴이름 배열
		mName[0] = "아메리카노";
		mName[1] = "카페라떼";
		mName[2] = "아이스티";
		mName[3] = "스무디";

		int[] mPrice = new int[N];

		int[] mCnt = new int[N];
		for (int i = 0; i < mCnt.length; i++) {
			System.out.println((i+1)+"번째 메뉴명을 입력해주세요");
			mName[i]=sc2.next();
			
			mPrice[i] = rand.nextInt(1000) + 2000;
			mCnt[i] = rand.nextInt(3) + 1;
		}

		// 1.구매
		int num;
		while (true) {

			// 1. 출력
			System.out.println("1.구매 2.종료");
			System.out.print("입력) ");
			int action = sc.nextInt();

			// 2-1. 종료
			if (action == 2) { // 종료조건 : 종료하기 버튼을 눌렀다면
				System.out.println("이용해주셔서 감사합니다!");
				System.out.println();
				break; // 무한루프네? 종료조건이 필수다!
			} else if (action < 1 || 2 < action) { // 유효성 검사 : 1,2도 아니라면
				System.out.println("잘못된 입력값입니다.");
				System.out.println("확인후 다시 이용해주세요!~~");
				System.out.println();
				continue;
			}

			System.out.println("=== 메뉴판 ===");
			for (int i = 0; i < mName.length; i++) {

				if (mCnt[i] <= 0) {
					System.out.println((i + 1) + "." + mName[i] + " 재고 없음");
				} else {
					System.out.println((i + 1) + "." + mName[i] + " 재고: " + mCnt[i]);
				}

			}
			System.out.println("============");
			System.out.println("구매할 상품의 번호를 입력)");
			num = sc.nextInt();

			if (1 <= num && num <= N) { // 종료조건 : 제대로 입력했다면
				break;
			}

			System.out.println("없는 상품 번호입니다.");
			System.out.println("다시 입력해주세요");
			System.out.println();
			
			

		}

	}

}
