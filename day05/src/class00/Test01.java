package class00;

import java.util.Scanner;

//[ 과제 ]
//1. main()에서 정수를 10번 입력할예정입니다.
//2. if(짝수야?) a++;
//3. if(음수야?) b++;
//4. 10번 입력완료했습니다. a=ㅁ,b=ㅁ입니다.
//5. 만약, 입력된 정수가 0이라면 프로그램을 종료
// 3번 입력완료했습니다. a=2,b=1입니다.
//+) 함수를 활용해서 해당 과제를 해결해주세요!~~
// 함수는 최대 3개까지 활용할수있습니다.
public class Test01 {

	// 1. 메서드 시그니처 먼저 만들기
	// 2. 기능을 먼저

	// [1] 90퍼
	// Q1) 어떤 정수가 입력되었을때 짝수인지 판별하는 함수
	// input: 정수 output: T/F 기능: 짝수 판별

	public static boolean isEven(int num) {
		if (num % 2 == 0) {
			return true;	//함수 즉시종료
		}
		return false;
	}

	// [2]
	// Q2) 어떤 정수가 입력되었을때 음수인지 판별하는 함수
	// main에 이미 있는 기능을 뜯어서 func()에 넣고 시작
	public static int checkMinus(int num, int b) {
		if (num < 0) {// 음수
			b++;
		}
		return b;
	}
	// 완성된 기능들의 묶음을 하나하나 분리해내는 작업
	// == 모듈화, 컴포넌트 화
	// : 코드 재사용성 증가
	// 유지보수
	
	//[1] 방식
	// Q3) 어떤 정수가 입력되었을때 0인지 판별 ---> 종료 안내 함수
	// input: 정수 output: T/F 기능: 종료 안내
	public static boolean check(int num) {
		if (num==0) {
			System.out.println("0이 입력되어 종료합니다...");
			System.out.println();
//			printBye();
			return true;
		}
		return false;
	}
	
//	public static void printBye() {
//		System.out.println("0이 입력되어 종료합니다...");
//		System.out.println();
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 몇번 입력할지 모르기 때문
		int cnt = 0;
		int a = 0;// 짝수의 개수
		int b = 0;// 음수의 개수
		while (cnt < 10) {// 10번 입력할때까지
			System.out.println((cnt + 1) + "번째 정수를 입력하세요"); // 사용자 편의, UI
			System.out.println("입력) ");
			int num = sc.nextInt();

			if (check(num)) {// 0 입력시 종료
				break;
			}
			cnt++;

			if (isEven(num)) {// 짝수
				a++;
			}

			if (num < 0) {// 음수
				b=checkMinus(num,b);
			}

		}
		System.out.println(cnt + "번 입력완료 되었습니다.");
		System.out.println("짝수: " + a + "개");
		System.out.println("음수: " + b + "개");

	}

}
