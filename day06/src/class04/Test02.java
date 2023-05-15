package class04;

class Book {
	// 멤버 변수
	String title;
	int price;
	int salesRate;	//판매량
	
	Book(String title, int price) {
		this.title = title;
		this.price = price;
		salesRate= 0;
		
		System.out.println("판매되지 않은 도서 "+title+" 생성되었습니다");
	}
	
	Book(String title, int price, int salesRate) {
		this.title = title;
		this.price = price;
		this.salesRate = salesRate;
		System.out.println(salesRate+"부 판매된 도서 "+title+" 생성되었습니다");
	}
	
	// 메서드
	void printInfo() {
		System.out.println(title + "은(는) " + price + "원이며 판매량은 "+salesRate+"부입니다");
	}
	
	void sell(){
		salesRate+=10;
		System.out.println(title+"을(를) 10부 판매하였습니다");
	}
}

public class Test02 {
// 총 4개의 함수가 있다
	public static void main(String[] args) { // 함수1
		// 객체
		Book b1 = new Book("어린왕자", 7800); // 생성자(함수)1
		Book b2 = new Book("해리포터", 23000,100); // 생성자(함수)2

		// 생성자 함수
		// 1. 클래스와 이름이 같고
		// 2. 객체를 생성할 수 있으며
		// 3. new 연산자와 함께 사용

		// 선언하지 않아도 기본적으로 생성되는 생성자
		// 기본(디폴트) 생성자 : 인자가 없다

//		b1.title = "어린왕자";
//		b1.price = 7800;
		b1.printInfo(); // 메서드 1개
		b1.sell();
		b1.sell();
		b1.sell();
		
		b1.printInfo();
		
		b2.printInfo(); // 메서드 1개
		b2.sell();
		
		b2.printInfo();
		
		Book b3 = new Book("비전공자를 위한 이해할 수 있는 IT 지식", 16000, 170);

	}

}
