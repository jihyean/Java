package class01;

class Family extends Thread {
	Account a = new Account();

	@Override
	public void run() {
		a.pay();
	}
}

class Account {
	static int money = 10000;
	synchronized void pay() {
		if(money>5000) {
			money-=5000;
			 System.out.println(Thread.currentThread().getName() + " 결제 성공");
		}
		else {
			System.out.println(Thread.currentThread().getName() + " 결제 실패");
		}
	}
}

public class Test03 {

	public static void main(String[] args) {
		Family p =new Family();
		Thread t1 = new Thread(p, "홍길동"); //각 사람마다 2개로 보임 
		Thread t2 = new Thread(p, "아무무");
		Thread t3 = new Thread(p, "티모");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
