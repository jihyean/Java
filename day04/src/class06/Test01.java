package class06;

public class Test01 {

	// 공개범위: public
	// static: "객체와 무관한"
	// void: 아무것도 없는
	// a 유형
	public static void hello() {// 기능을 유추할 수 있도록 지어야 함
		System.out.println("안녕하세요! :D");
	}// 함수 정의 선언

	// b 유형
	public static void printStar(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println("*");
		}
	}

	public static void main(String[] args) {

		System.out.println("메인함수");
		// 함수 호출(사용)
		hello();
		printStar(5); // 함수 호출시 입출력 값 정확히
		
		//함수끼리 메모리 공간을 공유하지 않는다

		System.out.println("입력");
		System.out.println("메뉴 나왔습니다");
		printStar(3);
		System.out.println("먹고? 포장?");
		hello();
		printStar(2);
	}

}
