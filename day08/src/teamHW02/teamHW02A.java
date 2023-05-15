package teamHW02;

import java.util.Scanner;

class Student1A {

	String name;
	int score;      

	Student1A(String name, int score) {//(메인에서 스캐너로 입력받은 학생이름), int score) {
		this.name = name;
		this.score = score;
		
	}
	// 학생 생성 메소드)
	// 스캐너로 학생이름, 점수 입력 받음
	// 변수: 학생이름, 점수
	// 출력: "저장!"
	void saveStu(String name, int score) {
		this.name=name;
		this.score=score;
		
	}
	// 목록 출력 메소드)
	void printList() {
		System.out.println(this.name +"학생 "+ this.score+"점");
	}
}

public class teamHW02A {
	public static void main(String[] args) {
		String msg = "=== 학생부 프로그램 ===\n" 
				+ "1. 학생 생성\n" 
				+ "2. 학생목록 출력\n" 
				+ "3. 학생 1명 출력\n"
				+ "4. 학생점수 변경\n"
				+ "5. 프로그램 종료\n"
				+ "입력 >> ";
		Scanner sc = new Scanner(System.in);
		// 프로그램 출력
		// 프로그램 번호 입력 받을 변수, 스캐너사용
		// 학생 객체 배열 선언[3]
		Student1A[] data = new Student1A[3]; //학생 리스트 최대 3명까지 
		String name=""; // 학생이름 받을 변수
		int score = 0; // 학생점수 받을 변수
		
		int i = 0;
		while(true) {
			System.out.print(msg); // 학생부 프로그램 메시지 (1. 학생생성 2. 핵생목록출력 3. 학생 1명 출력 4. 학생점수 변경 5. 프로그램 종료)
			int user = sc.nextInt(); // 사용자의 1~5 선택을 받을 변수 
			if(user==1) { // 유저가 1번 학생생성을 선택했을때
				while(i<data.length) { // (i+1) == 1번째, 2번째, 3번째 

					System.out.println((i+1)+"번 학생 '이름'을 입력 하세요 : ");
					name = sc.next(); // 이름 입력받음
					System.out.println(name+"이(가) 정확한 이름 이야? (1-YES,2-NO) : "); //유효성검사
					int action=sc.nextInt();
					if(action!=1) {
						continue;
					}else {
						System.out.println(name+ " 학생의 '점수'를 입력하세요 : ");
						score = sc.nextInt(); // 점수 입력받음
						data[i] = new Student1A(name, score); // 저장!!!!!!!!!!!!!!!!!!
						System.out.println((i+1)+"번째 "+name+" 학생 생성완료!\n");
						i++; // 수정을 눌렀을때 증가 안되게 안으로 넣었습니다 //2번째 인덱스가 아닌 2번 입력했다는듯
					}
					//i++; // 1번째 학생 이름과 점수 입력 받고 다시 메뉴창 나온뒤 또 1번 학생 생성 선택하면 2번째 학생으로 이름, 점수 입력 시작
					//System.out.println(i);
					break;
				}
			
			} 
			else if(user==2) {
				int k =0;
				System.out.println("=== 학생 목록 ===");
				while(true) {
					data[k].printList();
					if(k>=2) {
						break;
					}
					k++;
				}
			} 

			//			else if(user==3) {
			//				
			//			} else if(user==4) {
			//				
			//			} else if(user==5) {
			//				
			//			} else {
			//				System.out.println("오바르게 입력해 주세요");
			//				continue;
			//			}

		}

		// 프로그램 번호 입력 받음
		// while(true){
		//
		//    if(1이면),{
		//        String name = sc.next(); // 이름 입력받음
		//-> 생성자의 인자값 들어가면 알아서 배열 처리가 됨
		//int score = sc.nextInt(); // 점수 입력받음
		// 출력 "생성완료!"

		//    2이면, 인포 출력
		//    3이면, 출력하고 싶은 학생 번호 입력 받고
		//            해당 인덱스 학생 정보출력
		//      입력받은 학생 번호로 인덱스 뽑아내[번호+1].info();
		//    4이면, 출력하고 싶은 학생 번호 입력 받고
		//         해당 학생 정보 수정 후 저장
		//    5이면, break;
	}

}
