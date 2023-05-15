package class06;

import java.util.Random;

public class Test06 {
	
	//test1 함수
	public static void test1() {//메서드 시그니처
		Random rand = new Random();
		int N = rand.nextInt(11)+10;	//10~20
		System.out.println("랜덤수: "+N);
		
		int sum=0;
		for(int i=1; i<=N; i++) {
			sum+=i;
		}
		System.out.println(N+"까지의 총합: "+sum);
	}
	
	//test2 함수
	public static int test2(int a, int b) {
		int num=0;
		for(int i=a; i<=b; i++) {
			if(i%2==0) {
				num++;
			}
		}
		return num;
	}
	
	//test3 함수
	public static String test3(int N) {
		String msg;
		
		if(N>10) {
			msg="apple";
		}
		else {
			msg="banana";
		}
		
		return msg;
	}
	

	public static void main(String[] args) {
		
		test1();
		test2(1,5);
		test3(10);
		System.out.println("짝수의 개수: "+test2(1,5));
		System.out.println(test3(10));

	}

}	