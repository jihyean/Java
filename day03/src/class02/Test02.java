package class02;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		Random rand = new Random();			//랜덤 연산자
		int N = rand.nextInt(3)+3;			//3~5 랜덤 수 생성
		
		int[] data = new int[N];			//데이터 담을 배열 선언
		int[] data2 = new int[N];

		//data 배열이 완성될때까지 계속하는 방식
		int index = 0;	//현재위치를 나타내는 변수
		while(index<data.length) {
			data[index] = rand.nextInt(6)+100;	//랜덤 수 저장
			
			//[ flag ] 알고리즘
			boolean flag =false; //초기상태
			
			//특별한 일(=데이터 중복)이 발생하면
			for(int i=0; i<index; i++) {
				if(data[i]==data[index]) {
					flag = true;
				}
			}
			//중복 있음
			if(flag) {
				continue;
			}
			index++;
		}
		
		//


		/*
		for(int i =0; i<data.length; i++) {
			
			data[i]=rand.nextInt(6)+100;	//100~105 랜덤 수 생성
			for(int k=0; k<i; k++) {		//이미 생성된 만큼 비교 해야되서 k<i이다
				if(data[i]==data[k]) {		//중복 검사 실행
					i--;					//중복시 i--해서 다시 실행하도록 함
				}
			}
		}
		*/
		
		int sum=0;	//홀수 총합
		int sum2=0;	//짝수 총합
		int num=0;	//짝수인 인덱스 갯수
		for(int i=0; i<data.length; i++) {
			if(data[i]%2!=0) {		//홀수들의 합
				sum+=data[i];
			}
			else {					//짝수들의 합
				sum2+=data[i];
				num++;
			}
		}
		
		double avg = sum2*1.0/num;	//짝수인 수들의 평균
		
		System.out.print("[");
		for(int v : data) { 		//향상된 for문 랜덤수들 출력
			System.out.print(" "+v+" ");
		}
		System.out.print("]");
		System.out.println();

		System.out.println("홀수 총합 : "+sum);
		if(!(avg>0)) {				//유효성 검사
			System.out.println("짝수 평균 : 짝수가 생성되지 않았습니다");
		}
		else {
			System.out.println("짝수 평균 : "+avg);
		}

	}

}
