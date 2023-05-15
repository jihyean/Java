package class00;

import java.util.Random;
import java.util.Scanner;

//메서드 시그니처
//설계시 중요

//함수의 3요소
//input output 기능

//함수 제작 1,2

public class Test02 {
	
	public static void printRandNum(int L, int H) {	//Low High
		Random rand = new Random();
		int randNum = rand.nextInt(H-L+1)+L;
		System.out.println("랜덤 수) "+randNum);
	}
	
	public static int makeRandNum(int L, int H) {
		Random rand = new Random();
		int randNum = rand.nextInt(H-L+1)+L;
		return randNum;
	}
	

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);
		int start = 10;
		int end = 20;
		
		
		printRandNum(start, end);
		
		int randNum = makeRandNum(10,20);
		System.out.println("랜덤 수) "+randNum);
		
	}

}

























