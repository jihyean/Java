package class01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// int 타입만 저장 가능
		ArrayList<Integer> data = new ArrayList<>();

		// 정상적입력 10번
		final int CNT =10;
		while (data.size() < CNT) {
			int num;
			try {
				System.out.print("정수 입력: ");
				num = sc.nextInt();
				System.out.println("입력한 수: " + num);

			} catch (InputMismatchException e) { // 얘네도 클래스 자바의 util에 존재 (임포트 필요)
				sc.nextLine();// 버퍼에 남아있는 쓰레기 값 제거 코드
				System.out.println("정수만 입력해주세요");
				continue;
			}
			data.add(num);
		}

		// 입력한 정수들 출력
		System.out.println(data);

		// 0 이하 제거
		int index = 0;
		while (index < data.size()) {
			if (data.get(index) <= 0) {
				data.remove(index);
				continue;
			}

			index++;
		}

		// 0 제거한 data 값 출력
		System.out.println(data);

		
		// 최대값 찾기, sum 구하기
		int max = data.get(0);
		int sum = 0;

		int i =0;
		index =0;
		for (i = 0; i<data.size(); i++) {
			if (data.get(i) > max) {
				max = data.get(i);
				index = i;
			}
			sum+=data.get(i);
		}
		
		System.out.println("가장 큰 정수가 입력된 인덱스: ["+index+"]번");
		sum -=max; // 총 합에서 최대값 제거
		
		double avg = (sum*1.0)/(data.size()-1); // 최대값 제거했기 때문에 개수-1
		
		System.out.println("합: "+sum+" 평균: "+avg);
		
		
		
	}

}