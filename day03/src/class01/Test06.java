package class01;

import java.util.Random;
//자동임포트(ctrl+shift+o)

public class Test06 {

	public static void main(String[] args) {
		
		//배열 선언
		int[] stu = new int[6];
		
		//랜덤 점수 생성법
		Random rand = new Random();
		
		for(int i=0; i<stu.length;i++) {
			stu[i]=rand.nextInt(101);//0~100
			System.out.print(stu[i]+ " ");
		}
		System.out.println();
		
		//학생들의 점수 데이터 입력
//		stu[0]=29;
//		stu[1]=99;
//		stu[2]=30;
//		stu[3]=22;
//		stu[4]=87;
//		stu[5]=57;
		
		
		//1. 평균
		int sum = 0;
		for(int i=0; i<stu.length; i++) {
			//전체 학생들의 점수 총합
			sum+=stu[i];
		}
		double avg =sum*1.0/stu.length;
		
		//2.평균 넘긴 학생 수
		//5. 평균 못 넘긴 학생들의 번호--->변수에 저장 못하는 이유: 몇명이 못넘길지 모르기 때문
		//	:저장 공간 크기 예상하는법 --->리스크 생김
		//	:나중에 배열 생성
		int num=0;
		for(int i=0; i<stu.length; i++) {
			if(stu[i]>avg) {
				num++;
			}
			else {
				System.out.println((i+1)+"번 학생은 평균을 넘기지 못했습니다.");
			}
		}
		System.out.println("평균을 넘긴 학생 수는 "+num+"명입니다.");
		
		//3. 6등의 번호(최소값 찾기)
		int min=stu[0];
		int minIndex=0;
		for(int i=0; i<stu.length; i++) {
			if(min>stu[i]) {
				min=stu[i];
				minIndex=i;
			}
		}
		System.out.println("6등의 번호는 "+(minIndex+1)+"번입니다.");
		
		//4.짝수번째 학생들의 총점
		int res=0;
		for(int i=0; i<stu.length; i++) {
			if(i%2!=0) {
				res+=stu[i];	
			}
		}
		System.out.println("짝수번째 학생들의 총점은 "+res+"점입니다.");
	}

}
