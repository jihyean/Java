package class02;

import java.util.Random;

//[연습문제]
//1. Home의 구성원 객체들을 3명 생성할예정
//2. 각 객체들은 고유한 이름(name)을 가짐
//3. Home의 구성원 객체들이 공유하는 계좌가 있음
//         == money
//4. money에 10000원있음
//5. person.use(5000);
//   money를 100~5000원만큼 사용
//6. 여러번 사용할 예정
//7. money을 0원이하로 만든사람의 이름을 출력해주세요!~~
//※ 인스턴스 변수 vs 클래스 변수
//※ 멤버변수,메서드(+생성자) 고려할것
//※ 객체배열

class Home{
	String name;
	static int money = 10000;
	
	Home(String name){
		this.name = name;
		System.out.println("집에 "+this.name+"님이 왔습니다");
	}
	
	boolean use(int money) {
		if(Home.money<=money) {
			System.out.println(this.name+"님이 과소비중입니다.");
			return false;
		}
		Home.money-=money;	// 클래스 변수는 클래스명.변수;
		System.out.println(this.name+"님이 돈을 "+money+"원 사용했습니다. 잔액: "+Home.money);
		return true;
	}
}

public class Test03 {

	public static void main(String[] args) {
		Home[] person = new Home[3];
		person[0] = new Home("철수");
		person[1] = new Home("영희");
		person[2] = new Home("민재");
		
		Random rand = new Random();
		
		int i =0;
		while(true) {
			int randMoney = (rand.nextInt(50)+1)*100;
			
			if(!person[i++].use(randMoney)) { // 종료조건
				break;
			}
			if(i==person.length) {
				i=0;
			}
		}

	}

}






















