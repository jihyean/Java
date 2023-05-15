package class02;

class A{
	int a;	//멤버변수 필드 속성
	//int b;	// 인스턴스 변수, 프로퍼티 등...
	// : 각각의 객체들이 고유한 값을 저장 객체들끼리 값 공유하지 않음
	
	static int b;
	//객체와 무관, 클래스랑만 상관
	// 클래스 변수, 공유자원(애들이 다 쓰니까)
	// 객체끼리 값 공유
	
	void printInfo() {
		System.out.println("a= "+this.a);
		System.out.println("b= "+this.b);
	}
}

public class Test01 {

	public static void main(String[] args) {
		// 얘네가 값이 각각 저장되는 것을 알 수 있다
		A a1 = new A();
		a1.a=10;
		a1.b=10;
		
		A a2 = new A();
		a2.a=10;
		a2.b=10;
		a2.a++;
		a2.b++;
		
		a1.printInfo();
		a2.printInfo();

	}

}
