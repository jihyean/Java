package class04;

import java.util.Random;

// 포켓몬 클래스
class Pokemon {
	static Random rand = new Random(); 

	String name;
	int lv;
	int exp;
	String voice;

	Pokemon() { // 이름 지정하지 않는 경우 디폴트로 "포켓몬"
		this.name = "포켓몬";
		this.lv = 5; // 디폴트 레벨 5
		this.exp = 0; // 디폴트 경험치 0
		this.voice = "포켓몬";

	}

	Pokemon(String name) { // 이름 사용자 지정
		this(name, 5, 0);

	}

	Pokemon(String name, int lv, int exp) { // 이름, 레벨, 경험치 사용자가 입력
		this.name = name;
		this.lv = lv;
		this.exp = exp;
		this.voice = "포켓몬";

	}

	// 게임 확률 50퍼
	void game() {
		int win = rand.nextInt(2);

		win(win);
		levelUp();
	}

	// 대화 메서드
	void talk() {
		System.out.println(this.name + ": "+this.voice);
	}

	// 정보 출력 메서드
	void printInfo() {
		System.out.println(this.name + "는 LV." + this.lv + "[" + this.exp + "/100]");
	}

	void win(int win) {
		
		if (win == 0) {
			this.exp += rand.nextInt(40) + 10;
			System.out.println(this.name+" 성공!");
		} else {
			this.exp += 10;
			System.out.println(this.name+" 실패...");
		}
	}

	void levelUp() {
		while (this.exp >= 100) {
			this.lv++;
			this.exp -= 100;
			System.out.println(this.name + " 레벨업!");
		}
	}

}

// 피카츄 포켓몬 상속
class Pika extends Pokemon {

	// 기본 생성자
	Pika() {
		this(5, 0);
	}

	// 이름만 입력
	Pika(String name) {
		this(name, 5, 0);
	}
	
	Pika(int lv){
		super("피카츄");
		this.lv = lv;
	}

	// 레벨, 경험치 입력 받았을때
	Pika(int lv, int exp) {
		super("피카츄");
		this.lv = lv;
		this.exp = exp;
	}

	Pika(String name, int lv, int exp) {
		this.name = name;
		this.lv = lv;
		this.exp = exp;
	}

	// 게임 확률 100퍼 오버라이딩
	void game() {

		int win = rand.nextInt(1);

		win(win);
		levelUp();

	}

	// 대화 오버라이딩
	void talk() {
		System.out.println(this.name + ": 피카피카");
	}

	void printInfo() {
		System.out.println(this.name + "는 LV." + this.lv + "[" + this.exp + "/100]");
	}
}

// 파이리 클래스 상속
class Fire extends Pokemon {

	// 기본 생성자
	Fire() {
		this(5, 0);
	}

	// 이름만 입력
	Fire(String name) {
		this(name, 5, 0);
	}
	
	Fire(int lv){
		super("파이리");
		this.lv = lv;
	}

	// 파이리 경험치, 레벨 입력
	Fire(int lv, int exp) {
		this("파이리", lv, exp);
	}

	// 전부 다 입력
	Fire(String name, int lv, int exp) {
		this.name = name;
		this.lv = lv;
		this.exp = exp;

	}

	// 게임확률 20퍼 오버라이딩
	void game() {
		int win = rand.nextInt(5);

		win(win);
		levelUp();
	}

	// 대화 오버라이딩
	void talk() {
		System.out.println(this.name + ": 파이파이");
	}

	// 정보 출력 오버라이딩
	void printInfo() {
		System.out.println(this.name + "는 LV." + this.lv + "[" + this.exp + "/100]");
	}
}

public class Test02 {

	public static void main(String[] args) {

		Pika p1 = new Pika(3, 23);
		Pika p2 = new Pika();

		Fire f1 = new Fire("파이리1", 36, 99);

		for (int i = 0; i < 10; i++) {
			p1.game();
			p2.game();
			f1.game();
		}

		p1.talk();
		p2.talk();
		f1.talk();

		p1.printInfo();
		p2.printInfo();
		f1.printInfo();
	}

}
