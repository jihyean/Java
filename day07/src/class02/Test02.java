package class02;

// 1. 객체끼리 값 공유시 클래스 변수 static --->
// 2.


class Game {
	String name; // 모래성 게임 하는 사람 이름
	static int res = 100; // 공유 자원 , 모래성 ---> 공유자원은 괜찮음

	Game(String name) {
		this.name = name;
		System.out.println(this.name + "님 참가!");
	}

	boolean game(int cnt) { // this==자기 자신 객체 static 없음
		res -= cnt;
		if (res <= 0) {
			System.out.println(this.name + "님 패배...");
			return false;
		}
		System.out.println(this.name + "님 성공! 남은 모래: " + res);
		return true;
	}

}

public class Test02 {

	public static void main(String[] args) {
		Game g1 = new Game("아리");
		Game g2 = new Game("아무무");
		Game g3 = new Game("티모");
		Game g4 = new Game("소나");
		// 객체로 만드는 배열 : 객체 배열

		// int[] data = new int[4];
		// data[0]=10;
		Game[] data = new Game[3];
		data[0] = new Game("아리");
		data[1] = new Game("아무무");
		data[2] = new Game("티모");
		data[3] = new Game("소나");

		// 1번 ~마지막번까지 돌아가면서
		// 순서대로 게임
		// 만약 패배시 종료

		int i = 0;
		while (true) {

			if (!data[i].game(5)) {
				break;
			}

			i++;

			if (i == data.length) {
				i = 0;
			}

//		for(int i = 0; i<data.length; i++) {
//			if(!data[i].game(5)) {
//				break;
//			}
//		} 

//			if(!g1.game(5)) {
//				break;
//			}
//			
//			if(!g2.game(5)) {
//				break;
//			}
//			
//			if(!g3.game(5)) {
//				break;
//			}

		}

	}

}
