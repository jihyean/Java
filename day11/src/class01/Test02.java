package class01;

abstract class Shape{
	String name;
	double area;
	abstract void draw(); //추상 메서드
	
}

class Rect extends Shape{

	@Override
	void draw() {// 오버라이딩을 하지 않으면 에러 발생
		System.out.println("네모 그리기");
	}
}

class Circle extends Shape{
	@Override
	void draw() {
		System.out.println("원 그리기");
	}
}

class Tri extends Shape{	
	@Override
	void draw() {
		System.out.println("사각형 그리기");
	}	
}

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
