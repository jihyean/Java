package class01;

// 이미 자바에서 구현한 스래드 클래스 가져다가 사용
// 코드를 재사용할 예정
// 상속
class Th01 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i<=10; i++) {
			System.out.println("Thread 01 " +i);
		}
	}
	
}

class Th02 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i<=10; i++) {
			System.out.println("Thread 02 " +i);
		}
	}
	
} 

public class Test01 {

	public static void main(String[] args) {
		// 생성
		Th01 t1 = new Th01();
		Th02 t2 = new Th02();
		
		//Thread t3 = new Thread();
		
		//수행
		t1.start(); // 스레드 실행 -> run()메서드 실행
		t2.start(); 
		// 스레드 객체들은 현재 독립적으로 일을 수행하고 있다
		// start()로 인해 run()수행하게 되고 주어진 상태에서 run()을 다 수행시
		//데드 상태가 된다
		
		// 블록: 자원(메모리)을 할당받지 못하도록 막아둔 상태
		
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 1000 == 1초
		}
		
	}
}































