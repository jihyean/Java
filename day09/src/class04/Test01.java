package class04;

class Shape{
	String name;
	double area;
	
	Shape(String name){
		this.name = name;
		this.area = 0.0;
	}
	
	void print() {
		System.out.println(this.name+"의 넓이는 "+this.area+"입니다");
	}
}

class Rect extends Shape{
	int x;
	int y;
	
	Rect(int x, int y){
		super("네모");
		this.x = x;
		this.y = y;
		this.area = this.x*this.y;
	}
}
	
public class Test01 {

	public static void main(String[] args) {


	}

}
