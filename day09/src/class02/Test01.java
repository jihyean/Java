package class02;

class A{ //기존 클래스, 상위 클래스, 부모 클래스
	int a;
	
//	A(){
//		System.out.println("A() 기본 생성자 생성완료");
//	}
	
	A(int a){
		this.a=a;
		System.out.println("A() 생성자 생성완료");
	}
	
	void funcA() {
		System.out.println("a= "+this.a);
	}
}
// 부모 클래스에서는 자식 클래스의 내용에 접근ㄴㄴ

class B extends A{ // 기존에 존재했던 클래스를 보고 추가로 구현
	//자식
	int b;
	
	B(){
		super(1234); //super() -> 생성자 -> 클래스
		// this와 유사
		// this(): 자기자신의 클래스 생성자
		// super(): 자신의 부모 생성자
		this.b = b;
	}
	void funcB() {
		System.out.println("b= "+this.b);
	}
}
public class Test01 {

	public static void main(String[] args) {
		A aaa = new A(1234); // 객체화(인스턴스화)
		aaa.a = 10; // aaa-> a, funcA()
		
		B bbb = new B(); // 객체화(인스턴스화)
		bbb.b = 20; // bbb-> a, b, funcA(), funcB()
		
		bbb.funcA(); //bbb의 a는 초기화 안해서 0
		bbb.funcB();


	}

}
