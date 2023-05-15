package class04;

import java.util.Scanner;

// 자바의 기본단위 == class

//임의 생성되어 아래에 있는 public 과 겹치지 않게 
//학생 코딩해줘
class Student {// 클래스는 대문자로
//	상태: 멤버변수, 필드, 속성
	String name;
	int score;

	// 오버로딩은 생성자에서 매우 많이 쓴다
	Student(String name) { // 생성자 오버로딩
		this.name = name;
		this.score = 0;
		System.out.println(name + " 학생 출석부에 입력완료");
	}

	Student(String name, int score) {
		this.name = name;
		this.score = score;
		System.out.println(name + " 학생 출석부에 입력완료");
	}

//	동작(기능)멤버함수, 메서드
//	메서드는 함수에게 주체가 생긴것!
	// public static 없음
	// static == 객체와 무관하게
	void hello() {// a 유형 함수
		System.out.println("안녕, 난 " + name + "(이)야."); // 멤버변수라서 name 선언없이도 오류가 안난다
	}

}

public class Test01 {

	public static void main(String[] args) {

		int num = 10;
		double d = 3.14;
		Scanner sc = new Scanner(System.in);
		String str = new String("apple");
		String str2 = "apple";

		// 얘가 되는 것처럼
		String a = "apple";
		String b = "apple";
		String c = "apple";

		// 얘도 된다
		// 클래스 객체 = new 생성자();
		// 클래스는 자료형, 붕어빵틀
		// 내가 student 라는 자료형을 만든것
		// 객체는 변수, 붕어빵
		// 클래스로부터 객체 생성시 new 생성자()가 반드시 필요
		// 이것을 객체화(인스턴스화)라고 한다
		// 즉, 인스턴스 == "new"해서 나온것
		Student student1 = new Student("홍길동", 97);
		Student student2 = new Student("티모");
		Student student3 = new Student("아리");

		// 전부 다르게 나오며 new를 통해 힙메모리에 있어 주소값이 출력됨
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);

		// . 멤버 접근 연산자
		student1.name = "홍길동";
		student1.score = 97;
		student2.name = "티모";
		student2.score = 13;
		student3.name = "아리";
		student3.score = 56;

		student1.hello();
		student2.hello();
		student3.hello();

		// hello();
//		모두 클래스		
//		String
//		Random
//		Scanner

	}

}
