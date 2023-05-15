package class00;

import java.util.Random;
import java.util.Scanner;

public class Test03 {
	
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
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		int num = rand.nextInt(1000)+1;
		System.out.println("["+num+"]: ");
		String user = sc.next();
		
		if(check(num,user)) {
			System.out.println("정답입니다");
		}
		else {
			System.out.println("오답입니다");
		}

	}

}































