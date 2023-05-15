package class00;

import java.util.Random;
import java.util.Scanner;

// flag 알고리즘
// : 특정상황이 T/F인지 판단
// 특정상황이 반복문 함수 등처럼
// 시간이 좀 흘러야 범위를 모두 확인해야 알 수 있을때
// 단순 입력값ㄴㄴ


public class Test01 {

	public static void main(String[] args) {
		int [] data = new int[5];
		Random rand = new Random();
		for (int i=0; i<data.length; i++) {
			data[i]=rand.nextInt();

		}
		
		for(int v:data) {
			System.out.print(v+ " ");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력) ");
		
		int num =sc.nextInt();
		
		boolean flag = false; //배열에 num이 없는 상황=false
		int index=-1;
		
		for(int i =0; i<data.length; i++){
			if(data[i]==num) {
				flag=true;	//배열에 num이 있어서 true가 됨
				index=i;
			}
		}
		
		if(flag) {
			System.out.println(num+"은 ["+index+"]에 존재합니다.");
		}
		else {
			System.out.println(num+"은 존재하지 않습니다.");
		}
		}
		

	}

