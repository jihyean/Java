package class07;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
	public static int test1(int a, int b, int num) {

		if(num%2==0) {
			return a++;
		}
		else {
			return b++;
		}
	}

	public static int test2(int num) {

		return 1;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		int N = 10;
		int data[] = new int[N];

		int a = 0;
		int b = 0;
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();

			if (data[i] == 0) {
				break;
			} else if(data[i]%2 == 0){
				a++;	//a++;
			} else {
				b++;	//b++;
			}
		}
		System.out.println(N + "번 입력완료 했습니다.");
		System.out.println("a= " + a + " b= " + b);

	}

}
