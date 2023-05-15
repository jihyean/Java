package class02;

import java.util.Random;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int N = 4;// 상품은 4개이다
		String[] mName = new String[N]; // 메뉴이름 배열
		int[] mPrice = new int[N]; // 메뉴 가격 배열
		int[] mCnt = new int[N];

		// 메뉴 입력
		int index = 0;
		while (true) {

			if (index == N) {// 메뉴를 전부 입력시 종료
				break;
			}

			System.out.print((index + 1) + "번째 메뉴명 입력: ");
			mName[index] = sc.next();
			// sc.nextLine() 버퍼 청소

			System.out.println(mName[index] + "이(가) 맞나요?");
			System.out.println("1.YES 2.NO");
			System.out.println();
			int ans = sc.nextInt();

			if (ans != 1) {
				System.out.println("다시 입력하세요");
				continue;
			}
			System.out.println();
			index++; // 올바르게 입력하여 1 답변시 배열 길이 증가
		}

		// 가격 입력
		for (int i = 0; i < mCnt.length; i++) {
			System.out.print((i + 1) + "번째 메뉴 가격 입력: ");
			mPrice[i] = sc.nextInt();
			System.out.println(mName[i] + " 상품 입력 완료");
			System.out.println();
		}

		// 재고 입력
		for (int i = 0; i < mCnt.length; i++) {
			System.out.print((i + 1) + "번째 메뉴 재고 입력: ");
			mCnt[i] = sc.nextInt();
			System.out.println(mName[i] + " 상품 입력 완료");
			System.out.println();
		}

		// 구매
		while (true) {
			System.out.println("1.구매 2.종료");
			System.out.print("입력) ");
			int action = sc.nextInt();

			if (action == 2) {
				System.out.println("종료합니다");
				System.out.println();
				break;
			} else if (action < 1 || 2 < action) { // 유효성 검사 : 1,2도 아니라면
				System.out.println("잘못된 입력값입니다.");
				System.out.println("확인후 다시 이용해주세요!~~");
				System.out.println();
				continue;
			}

			// 구매할 상품 선택
			int num;
			while (true) {
				for (int i = 0; i < mName.length; i++) {
					System.out.println();
					System.out.print((i + 1) + "." + mName[i] + "[");
					if (mCnt[i] == 0) {// 재고가 0인 경우
						System.out.print("재고없음]");
					} else {
						System.out.print(mCnt[i] + "]");
					}
					System.out.println();
				}
				System.out.println("====================");
				System.out.print("구매할 상품의 번호를 입력) ");
				num = sc.nextInt();

				// 올바른 상품 번호 입력
				if ((1 <= num && num <= N) && (mCnt[num - 1] > 0)) {
					break;
				}
				// 없는 상품번호를 입력한 경우
				if (num < 1 || N < num) {
					System.out.print("없는 상품입니다");
				}
				// 구매하려는 상품이 재고가 0일 경우
				else if (mCnt[num - 1] == 0) {
					System.out.print("재고가 없어서 구매가 불가능합니다");
				}

			}

			//재고 확인
			int cnt; // 지역변수의 특성
			while (true) { // 유효성 검사 : 구매할 개수가 음수이거나, 재고보다 많으면 안됨!
				System.out.println("선택한 상품은 " + mName[num - 1] + "입니다.");
				System.out.println("가격: " + mPrice[num - 1] + "원  재고: " + mCnt[num - 1] + "개");
				System.out.print("구매할 개수를 입력) ");
				cnt = sc.nextInt();

				// 올바른 재고값을 입력(재고가 구매할 상품 수량보다 많음)
				if (0 <= cnt && cnt <= mCnt[num - 1]) {
					break;
				}
				// 구매하려는 상품 수가 재고보다 부족할 경우
				System.out.println("잘못된 입력입니다!");
				System.out.println("다시 입력해주세요!~~");
				System.out.println();
			}

			//상품 값 계산
			int res = mPrice[num - 1] * cnt;
			int money;
			System.out.println("금액: " + res + "원");
			while (true) {
				System.out.print("돈 입력) ");
				money = sc.nextInt();
				
				if (res <= money) {//올바른 입력시 종료
					break;
				}
				//잘못된 값일 경우 다시 입력받음
				System.out.println("잘못된 입력입니다!");
				System.out.println("새로 입력해주세요!");
				System.out.println();
			}

			//거스름돈 계산
			res = money - res;
			if (res != 0) {
				System.out.println("거스름돈 " + res + "원 반환 완료!");
			}
			System.out.println("구매 성공!");
			System.out.println();

			//재고 차감
			mCnt[num - 1] -= cnt; // "장바구니 이슈"를 생각해볼것!

		}

	}

}
