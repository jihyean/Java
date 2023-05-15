package class00;

import java.util.Random;
import java.util.Scanner;

public class Test04 {
	
	public static boolean check(int num, String user) {
		final int NUM =num;
		int cnt=0;
		int x =1000;

		while(x>0) {
			int n = num/x;
			if(n==3 || n==6 || n==9) {
				cnt++;
			}
			num=num%x;
			x=x/10;
		}
		
		String ans="";
		for(int i=0; i<cnt; i++) {
			ans+="짝";
		}
		
		if(cnt==0) {
			ans = Integer.toString(NUM);
		}
		
		System.out.println("ans: "+ans);
		System.out.println("user: "+user);
		
		if(ans.equals(user)) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {

		// int num
		// 1~1000 랜덤 정수 1개
		// syso("[num]: ")
		// 사용자가 입력 시도
		//		---> String user 
		// 정답이면 syso ("정답")
		// 오답이면 syso ("오답")
		
		//for(3번)
		//if 3번 다 정답?
		// 이름 입력
		//	입력받은 이름을 출력
		//if 오답? ---> 종료조건
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		final int LV=3;
		int i =0;
		while(i<3) {
			int num = rand.nextInt(1000)+1;
			System.out.println("["+num+"]: ");
			String user = sc.next();
			
			if(check(num,user)) {
				System.out.println("정답입니다");
				i++;
			}
			else {
				System.out.println("오답입니다");
				break;
			}
			
			if(i==LV) {
				System.out.println("이름 입력) ");
				String name = sc.next();
				System.out.println(name+"님 축하합니다");
			}
		}

	}

}































