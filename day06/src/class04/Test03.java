package class04;

class Circle {
	String name;
	int radius;
	final double PI;
	double area; // 클래스 멤버변수에 대입하지 말 것 -->생성자 정의나 해라 (순서 랜덤)

	// 생성자 아웃풋은 무조건 객체라서 안씀 그래서 인풋만 쓴다
	// 생성자 함수명==클래스명
	// 생성자 존재 이유
	// : 멤버 변수의 값들을 초기화하기 위해
	Circle(String name, int radius) {
		this.name = name;
		this.radius = radius;
		PI = 3.14;
		area = radius * radius * PI;
		System.out.println(name + "생성 완료");
	}

	void printInfo() {
		// 갈색 == 지역 변수
		// 파랑 == 멤버 변수
		// double area = r*r*3.14;
		System.out.println(name + "의 넓이는 " + area + "입니다.");
	}

}

public class Test03 {

	public static void main(String[] args) {

		// 생성자가 1개라도 제작하게 되면
		// 기본 생성자는 제공되지 않습니다
		Circle c1 = new Circle("피자", 10);
		Circle c2 = new Circle("도넛", 1);

		// 얘는 왜 초기화 안되냐
		c1.name = "도넛";
		c1.radius = 3;

		c2.name = "피자";
		c2.radius = 5;

		c1.printInfo();
		c2.printInfo();

	}

}
