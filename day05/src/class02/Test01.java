package class02;

import java.util.Random;
import java.util.Scanner;

//★
//1. 369 게임
//9 짝 33 짝짝 939 짝짝짝
//1~1000 중에서 랜덤으로 정수 1개 생성
//[19] : 짝
//정답입니다!
//[19] : 19
//오답입니다.....
//[22] : 22
//정답입니다!

public class Test01 {

	// 인풋: N, 사용자 입력 정답 아웃풋: 불린
	// 기능 삼육구 게임의 정답을 맞췄는가?
	public static boolean game(int N, String ans) {
		int n1 = N % 10;
		int n10 = (N % 100) / 10;
		int n100 = N / 100;
		String rans; // 진짜 답: 짝짝

		int num = 0;
		if ((n100 == 3) || (n100 == 6) || (n100 == 9)) {
			num++;
		}
		if ((n10 == 3) || (n10 == 6) || (n10 == 9)) {
			num++;
		}
		if ((n1 == 3) || (n1 == 6) || (n1 == 9)) {
			num++;
		}

		if (num == 3) {
			rans = "짝짝짝";
		} else if (num == 2) {
			rans = "짝짝";
		} else if (num == 1) {
			rans = "짝";
		} else {
			rans = String.valueOf(N);
		}

//		// String rans="";
//		for (int i = 0; i < num; i++) {
//			rans += "짝";
//		}
//		if (num == 0) {
//			rans = Integer.toString(N);
//		}

		if (rans.equals(ans)) {
			return true;
		}

		return false;

	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		String name[] = new String[5];
		// String name;

		int cnt = 0; 	// 3번 맞추기 세기
		int cnt2 = 0; 	// 5명 상품 줬는지 세기
		
		// 몇번 반복할지 모르니까
		while (true) {

			if (cnt2 >= name.length) {
				break;
			}

			while (true) {

				if (cnt > 2) { 	// 3번 맞추면 상품 증정
					System.out.println("이름입력) ");
					name[cnt2] = sc.next();
					System.out.println(name[cnt2] + "님 축하합니다!~~ 상품드리겠습니다!~~~");
					cnt2++;		// 증정한 사람 카운트
					cnt = 0; 	// 증정 했으니 맞춘 횟수 초기화
					break;
				}

				int N = rand.nextInt(1000) + 1; // 생성 수
				System.out.print("[" + N + "] : ");

				String ans = sc.next(); // 사용자 입력값

				if (game(N, ans)) {
					System.out.println("정답입니다");
					cnt++;
				} else {
					System.out.println("오답입니다.....");
					System.out.println(" - 끝 -");
					break;
				}

			}

			for (int i = 0; i < cnt2; i++) { // 이름이 입력된 숫자만큼 출력
				System.out.println((i + 1) + " " + name[i]);
			}
		}

	}

}
