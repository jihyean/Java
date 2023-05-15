package class00;

import java.util.Random;
import java.util.Scanner;

//+++) 10개의 랜덤정수가 저장된 배열(범위:1~100)
//사용자가 정수를 입력 ex) 50
//50은 [2]에 저장되어있습니다.
//50은 배열에 없습니다!

public class Test02 {

	// 인풋: int[] 아웃풋: (boolean, )int
	// 기능: 배열에 특정 정수가 있는지, 있다면 몇번인덱스인지
	// => 2개 이상 반환 불가
	// int 값 의미 부여
	public static int checkNum(int data[], int num) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == num) {
				return i;
			}
		}
		return -1; // false를 의미
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int data[] = new int[10];	//10개의 정수 입력 받을 것이기 때문

		//10개의 랜덤정수 생성
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100) + 1;
		}
		
		//10개의 랜덤정수 출력
		System.out.print("[");
		for (int v : data) {
			System.out.print(v + " ");
		}
		System.out.print("]");
		System.out.println();

		System.out.println("정수 입력) ");
		int num = sc.nextInt();
		int index = checkNum(data, num);// 함수를 적게 호출하기 위함

		if (index < 0) {
			System.out.println(num + "은 배열에 없습니다");
		} else {
			System.out.println(num + "은 [" + index + "]에 저장되어 있습니다.");
		}

	}

}
