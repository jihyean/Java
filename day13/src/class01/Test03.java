package class01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// 정상적인 입력을 3번 입력 할때까지
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			try {
				System.out.print("정수 입력: ");
				int num = sc.nextInt();
				System.out.println("num= " + num);
				
			} catch (InputMismatchException e) { // 얘네도 클래스 자바의 util에 존재 (임포트 필요)
				sc.nextLine();//버퍼에 남아있는 쓰레기 값 제거 코드
				System.out.println("정수만 입력해주세요");
			}
		}
		
		int index =0;
		while(index<3) {
			try {
				System.out.print("정수 입력: ");
				int num = sc.nextInt();
				System.out.println("num= " + num);
				index++;
				
			} catch (InputMismatchException e) { // 얘네도 클래스 자바의 util에 존재 (임포트 필요)
				sc.nextLine();//버퍼에 남아있는 쓰레기 값 제거 코드
				System.out.println("정수만 입력해주세요");
			}
		}
	}

}
