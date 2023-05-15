package class01;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
//+++) 10개의 랜덤정수가 저장된 배열(범위:1~100)
//사용자가 정수를 입력 ex) 50
//50은 [2]에 저장되어있습니다.
//50은 배열에 없습니다!
	public static void fun(int data, int i) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (data == num) {
			System.out.println(data + "은 [" + i + "]에 저장되어 있습니다.");
		} else {
			System.out.println(data + "은 배열에 없습니다!");
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		int N = 10;
		int data[] = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = rand.nextInt(100) + 1;
			System.out.print(data[i] + " ");
		}

		// int num = sc.nextInt();

		int ext = 0;
		int num = sc.nextInt();

		for (int i = 0; i < data.length; i++) {
			fun(data[i],i);
			
		}

	}

}























