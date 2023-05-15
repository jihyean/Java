package class01;

class A{ //기존 클래스, 상위 클래스, 부모 클래스
	int a;
	
	A(){
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
		System.out.println("B() 생성자 생성완료");
	}
	void funcB() {
		System.out.println("b= "+this.b);
	}
}
public class Test01 {

	public static void main(String[] args) {
		A aaa = new A(); // 객체화(인스턴스화)
		aaa.a = 10; // aaa-> a, funcA()
		
		B bbb = new B(); // 객체화(인스턴스화)
		bbb.b = 20; // bbb-> a, b, funcA(), funcB()
		
		bbb.funcA(); //bbb의 a는 초기화 안해서 0
		bbb.funcB();
//결과: 3번 나옴
		

	}

}
