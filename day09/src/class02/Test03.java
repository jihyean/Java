package class02;
// 상속 도형 예제
class Shape{
	String name;
	double area;
	
	Shape(String name){
		this(name, 0.0);
	}
	
	Shape(String name, double area){
		this.name = name;
		this.area = area;
	}
	
	void printArea() {
		System.out.println(this.name+"의 넓이는 "+this.area+"입니다");
	}
	
}

class Circle extends Shape{
	int r;
	final static double PI = 3.14;
	
	Circle(int r){
		this("원", r);
	}
	
	Circle(String name, int r){
		super(name);
		this.r =r;
		this.area = this.r*this.r*Circle.PI;	
	}
	
}

class Rect extends Shape{
	int x;
	int y;
	
	Rect(int x, int y){
		this("사각형", x, y);
	}
	
	Rect(String name, int x, int y){
		super(name);
		this.x = x;
		this.y = y;
		this.area = this.x*this.y;
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		Circle c1 = new Circle(1);
		Rect rect1 = new Rect("정사각형",4, 4);
		
		c1.printArea();
		rect1.printArea();
		
		System.out.println(c1.name+"의 반지름: "+c1.r);
		System.out.println(rect1.name+"의 가로: "+rect1.x);
		System.out.println(rect1.name+"의 세로: "+rect1.y);

	}

}
