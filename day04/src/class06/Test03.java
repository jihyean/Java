package class06;

import java.util.Scanner;

//[연습문제]
//1. 점수를 알려주면,
//2. "ㅁㅁ점은 ㅁ등급입니다."라고 출력해주세요!~~
//3. 80~100 A
//   60~79 B
//   0~59 C
//4. printGrade()라는 함수를 선언(정의)해주세요!!!

public class Test03 {
	
	public static void printGrade(int score){
		char grade;
		
		if (score>=80 && score<=100) {
			grade='A';
		}
		else if(score>=60 && score<=79) {
			grade='B';
		}
		else if(score>=0 && score<=59) {
			grade='C';
		}
		else {
			System.out.println(score+"점은 잘못된 점수입니다");
			return;	//함수를 즉시종료 합니다
		}
		System.out.println(score+"점은 "+grade+" 등급입니다");
		
	}
	
	public static void main(String[] args) {
		int score;
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요: ");
		score = sc.nextInt();

		printGrade(score);
	}
}
