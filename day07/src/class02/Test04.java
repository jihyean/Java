package class02;
//원본
import java.util.Random;
import java.util.Scanner;

class Pokemon {
	Random rand = new Random();

	String name;
	int lv;
	int exp;

	Pokemon(String name, int lv, int exp) {
		this.name = name;
		this.lv = lv;
		this.exp = exp;
	}

	void game() {
		int win = rand.nextInt(2); // 승 패 0 or 1

		if (win == 0) {// 실패
			this.exp += 10;
			System.out.println(this.name + " 패배");
		} else {
			this.exp += rand.nextInt(101) + 50;
			System.out.println("성공");
		}

//		if (this.exp >= 100) {
//			this.exp -= 100;
//			
//			if(this.exp>=100) {
//				this.lv++;
//			}
//			
//			this.lv++;
//			System.out.println(this.name + ", 레벨업!");
//			this.printInfo();
//		}
		
		while(this.exp >=100) {
			this.exp -= 100;
			this.lv++;
			System.out.println(this.name + ", 레벨업!");
		}
		this.printInfo();
		System.out.println();

	}

	void printInfo() {
		System.out.print(this.name + " Lv" + this.lv + ". [" + this.exp + "/100]");
		System.out.println();
	}

}

public class Test04 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		// 포켓몬 객체 배열
		Pokemon[] po = new Pokemon[3];

		// 포켓몬 입력받기
		System.out.println("사용할 포켓몬을 입력해주세요");
		int cnt = 0;
		while (cnt < po.length) {

			System.out.print("포켓몬 이름) ");
			String name = sc.next();
			
			System.out.println(name+" 입력하였습니다");
			System.out.println("1.계속하기 2.수정하기");
			int action = sc.nextInt();
			
			
			if(action == 2) {
				System.out.println("다시 입력하기를 선택하셨습니다");
				break;
			}
			else if(action == 1) {
				System.out.println("계속 입력하기를 선택하셨습니다");
			}
			else {
				System.out.println("잘못된 입력입니다! 다시 입력해주세요!!");
				break;
			}
			

			

			System.out.print("포켓몬 레벨) ");
			int lv = sc.nextInt();

			if (lv >= 0) {
				int exp = rand.nextInt(11);
				po[cnt] = new Pokemon(name, lv, exp);
				cnt++;
				System.out.println("포켓몬 입력 성공!");
			} else {
				System.out.println("잘못된 입력입니다! 다시 입력해주세요!!");
			}

		}
		// 포켓몬 리스트 출력
		System.out.println("===== 입력된 포켓몬 리스트 =====");
		for (int i = 0; i < po.length; i++) {
			System.out.print((i + 1) + ". ");
			po[i].printInfo();
			System.out.println();
		}
		System.out.println();

		// int cnt=0;
		while (true) {
			System.out.println("사용할 포켓몬을 입력해주세요!");
			System.out.print("사용할 포켓몬) ");
			int i = sc.nextInt();

			if (i >= 1 && i <= 3) {
				System.out.println();
				po[i - 1].game();
			}
			else {
				System.out.println("잘못된 입력입니다! 다시 입력해주세요!!");

			}


//			cnt++;
//			
//			if(cnt==po.length) { //3마리 순서대로
//				cnt=0;
//			}
		}

	}

}
