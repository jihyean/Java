package class01;

import java.util.Scanner;

class Product {
	// 1. 멤버변수
	int num; // PK
	String name;
	int cnt;
	int price;

	// 생성자
	Product(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.cnt = 5; // 재고 디폴트 5
		this.price = price;
	}

	// 2. 메서드
	// 1) 기능 파악
	// : 사용자가 n개 구매할건데 구매 가능?
	// 가능: 재고 마이너스 불가능 구매실패
	// 2) 메서드 시그니처
	// INPUT -> int 구매할 상품의 개수
	// OTPUT -> int 총 가격, boolean
	// -> int 총 가격(구매실패시 0원)
	// 3) 기능구현
	//
	int sell(int cnt) {
		int sum = 0;
		if (this.cnt >= cnt) {
			this.cnt = cnt;
			sum = cnt * this.price; // 총가격
			System.out.println("총금액: " + sum);
			return sum;
		}
		System.out.println("재고부족");
		return sum;
	}

	// 1) 관리자가 000원으로 가격 변경
	// 변경되었습니다
	// 2) INPUT -> int 가격
	// Output -> void

	void setPrice(int price) { // 멤버변수의 값을 새로 정의하는 것 set
		this.price = price;
		System.out.println("가격변경 완료");
	}

	void printInfo() {
		System.out.println(this.name + "[" + this.cnt + "] " + this.price + "원");
	}
	// 3. 생성자
}

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Product[] data = new Product[3];
		// 현재 상품배열 data[]에 저장된 상품의 개수는 0개

		int index = 0;
		while (true) {
			System.out.println("===== 자판기 =====");
			// System.out.println("1. 메뉴추가");
			System.out.println("1. 메뉴출력");
			System.out.println("2. 메뉴구매");
			// System.out.println("4. 가격변경");
			System.out.println("3. 프로그램 종료");
			System.out.println("================");
			System.out.println();

			System.out.println("번호 입력) ");

			int action = sc.nextInt();

			if (action == 5) {
				System.out.println("프로그램 종료");
				break;
			} else if (action == 1) { // Read
				// 상품배열에 저장되어 있는 만큼
				for (int i = 0; i < index; i++) {
					// System.out.println((i+1)+". "+data[i].name+"["+data[i].cnt+"] 가격:
					// "+data[i].price);\
					// main()에서 접근시 ---> 안정성 떨어짐
					System.out.print((i + 1) + ". ");
					data[i].printInfo();

				}
			} else if (action == 2) {
				System.out.println("구매할 상품의 번호 입력) ");
				int num = sc.nextInt();

				System.out.println("구매할 상품의 개수 입력) ");
				int cnt = sc.nextInt();
				data[num - 1].sell(cnt);

			}

			else if (action == 1234) {
				System.out.println("관리자 모드 실행");
				System.out.println();
				
				System.out.println("===== 관리자 =====");
				System.out.println("1. 메뉴추가");
				System.out.println("2. 가격변경");
				System.out.println("================");
				System.out.println();
				
				System.out.println("번호 입력) ");
				action = sc.nextInt();

				if (action == 1) { // C
					System.out.println("생성할 상품의 이름 입력) ");
					String name = sc.next();

					System.out.println("생성할 상품의 가격 입력) ");
					int price = sc.nextInt();
					// 상품 객체를 생성해서 배열에 저장
					data[index++] = new Product(index, name, price);

				}
				else if (action == 2) { // U

					if (index <= 0) {
						System.out.println("저장된 상품이 없습니다");
						continue;
					}

					System.out.println("변경할 상품의 번호 입력) ");
					int num = sc.nextInt();

					if (num <= 0 || index < num) {
						// 경계값 분석
						System.out.println("존재하지 않는 상품입니다");
						continue;
					}

					System.out.println("얼마로 변경하시겠습니까? ");
					System.out.println("입력) ");
					int price = sc.nextInt();

					data[num - 1].setPrice(price);
				}
				else {
					System.out.println("잘못된 번호");
				}

			} else {
				System.out.println("잘못된 번호");
			}

		}

	}

}
