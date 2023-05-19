package class01;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
	static Scanner sc = new Scanner(System.in);

	private int num; 	// 상품 PK
	private String name;// 상품명
	private int price; 	// 상품 가격
	private int cnt; 	// 상품 재고

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	// 생성자 이름, 가격을 사용자가 입력
	Product(int num, String name, int price) {
		this(num, name, price, 0);
	}

	// 생성자 이름, 가격, 재고를 사용자가 입력
	Product(int num, String name, int price, int cnt) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	// 구매 메서드
	boolean sell(int cnt) {

		// 재고가 구매량보다 많으면
		if (this.cnt >= cnt) {
			System.out.println("가격은 " + (this.price * cnt) + "원 입니다");
			System.out.println("돈을 입력해주세요");

			while (true) { // 올바르게 돈을 입력할때까지 반복
				System.out.println("입력: ");
				int money = sc.nextInt();
				
				if (money >= (this.price * cnt)) { // 돈을 총 가격보다 많이 내면
					System.out.println("잔돈: " + (money - (this.price * cnt)));
					this.cnt -= cnt;
					System.out.println("구매완료");
					break;
					
				} else { // 입력된 돈이 부족한 경우
					System.out.println("다시 입력해주세요");
				}	
			}
			return true; // 정상 지불 완료
		}
		// 재고가 부족할시
		else {
			System.out.println("재고가 부족합니다");
			return false;
		}
	}
	
	// 재고 변경 메서드
	void changeCnt(int cnt) {
		
		this.cnt += cnt;
		System.out.println("재고가 변경되었습니다\n" + "현재 재고: "+cnt);
	}

	@Override
	public String toString() { // toString 오버라이딩

		if (this.cnt <= 0) {
			return this.num + ". " + this.name + " 가격: " + this.price + "원 재고: " + "[품절]";
		}

		return this.num + ". " + this.name + " 가격: " + this.price + "원 재고: " + this.cnt + "개";
	}

}

public class Test01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Product> data = new ArrayList<Product>(); //상품 배열리스트
		int numPK = 1001; // 1001번부터 순서대로 부여

		// 유저 선택창
		String userMsg = "1. 상품목록출력\n" + "2. 구매하기\n" + "3. 프로그램종료\n";

		// 관리자 선택창
		String managerMsg = "1. 상품추가\n" + "2. 상품재고변경\n" + "3. 상품삭제\n" + "4. 관리자모드종료\n";

		while (true) { // 종료할때까지 반복

			System.out.println(userMsg);
			System.out.print("입력: ");
			int action = sc.nextInt(); // 사용자의 행동을 입력받을 변수

			// 사용자 모드 기능1 선택
			// 상품 목록 출력
			if (action == 1) {
				System.out.println("1. 상품목록출력");
				for (Product product : data) {
					System.out.println(product);
				}

			}
			// 사용자 모드 기능2 선택
			// 상품 번호와 구매수량을 입력 받아 구매
			else if (action == 2) {
				System.out.println("2. 구매하기");
				System.out.println("구매하실 상품 번호를 입력해주세요");
				System.out.print("입력: ");
				int num = sc.nextInt();

				System.out.println("얼마나 구매하시겠습니까?");
				System.out.print("입력: ");
				int cnt = sc.nextInt();

				// 입력받은 수와 PK가 같으면 구매 메서드 실행
				for (int i = 0; i < data.size(); i++) {
					if (num == data.get(i).getNum()) {
						data.get(i).sell(cnt);
					}

				}
			}
			// 사용자 모드 기능3 선택
			// 프로그램 종료
			else if (action == 3) { // break로 프로그램 종료
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			// 숨겨진 코드 1234 입력시, 관리자모드 이동
			else if (action == 1234) { // 관리자 모드 진입
				
				System.out.println("관리자 모드 비밀번호를 입력해주세요");
				System.out.print("입력: ");
				action = sc.nextInt();

				if (action != 5678) {
					System.out.println("비밀번호가 일치하지 않습니다");
					continue;
				}

				while (true) { // 관리자 모드 종료을 선택하지 않으면 반복

					System.out.println(managerMsg); //관리자 모드 목록 출력
					System.out.print("입력: ");
					action = sc.nextInt();

					for (Product product : data) {
						System.out.println(product);
					}

					// 관리자 모드 기능 1
					// 상품 추가 PK는 자동입력
					if (action == 1) {
						System.out.println("1. 상품추가");
						System.out.println("추가하실 상품 이름을 입력해주세요");
						System.out.print("입력: ");
						String name = sc.next();

						System.out.println("해당 상품의 가격을 입력해주세요");
						System.out.print("입력: ");
						int price = sc.nextInt();

						System.out.println("재고도 입력하시겠습니까?");
						System.out.println("1. 재고 입력 없음 2. 재고 입력");
						action = sc.nextInt();

						
						// 재고 입력 안함 선택 ---> 재고: 0
						if (action == 1) {

							data.add(new Product(numPK++, name, price));
							System.out.println(data);
						}
						// 재고 입력 선택
						else if (action == 2) { // 사용자가 입력한 값으로 등록
							System.out.println("해당 상품의 재고를 입력해주세요");
							System.out.print("입력: ");
							int cnt = sc.nextInt();

							data.add(new Product(numPK++, name, price, cnt));
							System.out.println("추가되었습니다");
						}

					}
					// 관리자 모드 기능2
					// 상품 재고 변경
					else if (action == 2) {
						System.out.println("2. 상품재고변경");
						System.out.println("재고를 변경하실 상품의 번호를 입력해주세요");
						System.out.print("입력: ");
						int num = sc.nextInt();
						
						System.out.println("재고를 얼마나 변경하시겠습니까?");
						System.out.println("음수 입력시 재고가 감소됩니다");
						System.out.println("입력: ");
						int cnt = sc.nextInt();

						for (int i = 0; i < data.size(); i++) {
							if (num == data.get(i).getNum()) {
								data.get(i).changeCnt(cnt);
								System.out.println("변경되었습니다");
								break;
							}
						}

					}
					// 관리자 모드 기능 3
					// 상품 삭제
					else if (action == 3) {
						System.out.println("3. 상품삭제");
						System.out.println("삭제하실 상품의 번호를 입력해주세요");
						System.out.print("입력: ");
						int num = sc.nextInt();

						for (int i = 0; i < data.size(); i++) {
							if (num == data.get(i).getNum()) {
								data.remove(i);
								System.out.println("삭제되었습니다");
								break;
							}
						}

					}
					// 관리자 모드 기능4
					// 관리자 모드 종료 ---> 사용자 모드로 이동
					else if (action == 4) {
						System.out.println("4. 관리자모드종료");
						System.out.println("관리자 모드를 종료합니다...");
						break;
					} // 관리자 모드 if 닫힘

				} // 관리자 모드 반복 while 닫힘

			}
			else {
				System.out.println("목록 중에 선택해주세요");
			} // 사용자 모드 if 닫힘

		} // 전체 반복 while문 닫힘
	}

}
