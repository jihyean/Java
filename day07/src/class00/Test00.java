package class00;

import java.util.Scanner;

class Student1 {
	
	String name;
	int score;		

	Student1(String name/*(메인에서 스캐너로 입력받은 학생이름)*/, int score) {
		this.name = name;
		this.score = score;
		
		
	}
	

	// 학생 생성 메소드)
	// 스캐너로 학생이름, 점수 입력 받음
	// 변수: 학생이름, 점수
	// 출력: "저장!"
	
	// 목록 출력 메소드)
	// 
	
	// 학생 1명 출력 메소드)
	// 메인에서 스캐너로 입력받은 학생 번호를 인자값으로 가짐
	//	 ex) 메소드 이름(int i)
	// 
}

public class Test00 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 프로그램 출력
		// 프로그램 번호 입력 받을 변수, 스캐너사용
		// 학생 객체 배열 선언[3]
		Student1[] data = new Student1[3];
		
		String name = sc.next(); // 이름 입력받음
								//-> 생성자의 인자값 들어가면 알아서 배열 처리가 됨
		int score = sc.nextInt(); // 점수 입력받음
		
		
		
		// 프로그램 번호 입력 받음
		// while(true){
		//
		// 	if(1이면),{
		// 	 	String name = sc.next(); // 이름 입력받음
		//-> 생성자의 인자값 들어가면 알아서 배열 처리가 됨
		//int score = sc.nextInt(); // 점수 입력받음
		// 출력 "생성완료!"

		// 	2이면, 인포 출력
		// 	3이면, 출력하고 싶은 학생 번호 입력 받고
		//				해당 인덱스 학생 정보출력
		//		입력받은 학생 번호로 인덱스 뽑아내[번호+1].info();
		// 	4이면, 출력하고 싶은 학생 번호 입력 받고
		//			해당 학생 정보 수정 후 저장
		// 	5이면, break;
	}

}
