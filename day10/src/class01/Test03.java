package class01;

class Point { // 점 클래스
	int x;
	int y;

	// 생성자 x, y 모두 입력받음
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 오버라이딩
	@Override
	public boolean equals(Object obj) {
		Point point = (Point) obj;	// 명시적 형변환

		if ((this.x == point.x) && (this.y == point.y)) { // 같으면 true
			return true;
		}
			
		return false;
	}
}

//색깔 점 클래스 (점 클래스 상속)
class ColorPoint extends Point {
	String color;	// 부모에 없는 멤버변수

	//생성자 x, y, 색깔 모두 입력 받음
	ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	// 오버라이딩
	@Override
	public boolean equals(Object obj) {
		ColorPoint colorPoint = (ColorPoint) obj; // 명시적 형변환

		// x, y, 색깔 모두 같으면 true
		if ((this.x == colorPoint.x) && (this.y == colorPoint.y) && (this.color.equals(colorPoint.color))) {
			return true;
		}
		return false;
	}
}

public class Test03 {

	public static void main(String[] args) {
		//점 클래스 객체 배열
		Point[] data = new Point[3];
		data[0] = new Point(10, 20);
		data[1] = new Point(123, 20);
		data[2] = new Point(10, 20);

		//색깔 점 클래스 객체 배열
		ColorPoint[] data2 = new ColorPoint[3];
		data2[0] = new ColorPoint(10, 20, "blue");
		data2[1] = new ColorPoint(10, 20, "blue");
		data2[2] = new ColorPoint(10, 20, "red");
		

		// 점 객체 비교
		if (data[0].equals(data[1])) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}

		if (data[0].equals(data[2])) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		

		// 색깔 점 객체 비교
		if (data2[0].equals(data2[1])) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}

		if (data2[0].equals(data2[2])) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}

	}

}



















