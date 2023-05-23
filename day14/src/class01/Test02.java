package class01;

// 스레드는 독립적으로 실행되기 때문에
// 공유자원을 어떤 스레드가 점유하고 있을때'
// 다른 스레드의 접근을 막아야 한다.


class Person extends Thread {
	Ticketting t = new Ticketting(); // 설명을 위해 클래스내에서 선언
	
	@Override
	public void run() {
		t.pay();
	}
	
}

class Ticketting {
	static int ticket = 2; // 공유자원, 클래스 변수
	synchronized void pay() {
		if(ticket>0) {
			System.out.println(Thread.currentThread().getName()+" 구매 성공!");
			ticket--;
		}
		else {
			System.out.println(Thread.currentThread().getName()+" 구매 실패");
		}
		System.out.println("남은 티켓: "+ticket);
	}
}

public class Test02 {

	public static void main(String[] args) {
		Person p =new Person();
		Thread t1 = new Thread(p, "홍길동"); //각 사람마다 2개로 보임 
		Thread t2 = new Thread(p, "아무무");
		Thread t3 = new Thread(p, "티모");
		
		t1.start();
		t2.start();
		t3.start();


	}

}
















