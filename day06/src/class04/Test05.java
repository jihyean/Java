package class04;

class Car{
	String name; //차주 이름
	final int speedLimit;	//최대 속도
	int speedNow; //현재 속도
	
	// this() == 생성자 함수
	Car(){
		
		this("무명",120);
		
		System.out.println("차가 생성되었습니다");
		System.out.println("차주: "+this.name+" 최대속도: "+this.speedLimit);
	}
	
	Car(String name){
		this(name,120);
		
		System.out.println("차가 생성되었습니다");
		System.out.println("차주: "+this.name+" 최대속도: "+this.speedLimit);
	}
	
	Car(String name, int speedLimit){
		this.name = name;
		this.speedLimit = speedLimit;
		this.speedNow = 0;
		
		System.out.println("차가 생성되었습니다");
		System.out.println("차주: "+this.name+" 최대속도: "+this.speedLimit);
	}
	
	void printInfo(){
		System.out.println(name+"님의 차는 ["+speedNow+"/"+speedLimit+"]입니다.");
	}
	
	void speedUp(int speed) {
		if(speedNow<=(speedLimit-speed)) {
			speedNow+=speed;
			System.out.println(name+"님의 차 속도를 "+speed+"만큼 올렸습니다");
		}
		else {
			speedNow = speedLimit;
			System.out.println(name+"님의 차가 과속입니다!");
		}
	}
	
	void speedDown(int speed) {
		if((speedNow-speed)<=0) {
			speedNow = 0;
			System.out.println(name+"님의 차를 정지합니다...");
		}
		else {
			speedNow-=speed;
			System.out.println(name+"님의 차 속도를"+speed+"만큼 내렸습니다");
		}
	}
	
	
}

public class Test05 {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("홍길동");
		Car car3 = new Car("아무무", 200);
		
		car1.printInfo();
		car2.printInfo();
		car3.printInfo();
		
		car1.speedUp(10);
		car1.speedUp(30);
		
		car2.speedDown(40);
		
		car3.speedUp(200);
		car3.speedUp(100);
		car3.speedDown(40);
		car3.speedDown(27);
		
		car1.printInfo();
		car2.printInfo();
		car3.printInfo();

	}

}



