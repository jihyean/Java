package class02;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		//N개의 랜덤수
		//랜덤수는 1~10 생성
		//랜덤수 평균 출력
		//평균보다 높은 값 저장, 이후에 출력
		
		//Random 생성
		//N결정
		//N개만큼 랜덤수
		//총합--->평균
		//평균보다 높은 값 저장 공간 생성
		//공간에 값 저장
		//출력
		
		Random rand = new Random();
		int N = rand.nextInt(10)+1;
		System.out.println("N: "+N);
		//rand.nextInt(101) --->>0~100
		//rand.nextInt(10) --->>1~10
		
		//[3]
		//배열을 쓰고 싶다
		// : 배열의 3요소를 만족 사용가능
		
		int[] data = new int[N];
		for(int i =0; i<data.length; i++) {
			data[i]=rand.nextInt(10)+1;
		}
		
		int sum =0;
		for(int i=0; i<data.length; i++) {
			//전체 학생들의 점수 총합
			sum+=data[i];
		}
		for(int v : data) { //향상된 for문
			System.out.println("랜덤수: "+v);
		}
		System.out.println("총합: "+sum);
		
		double avg =sum*1.0/data.length;
		System.out.println("평균: "+avg);
		
		//[5]평균보다 높은값
		//a예상, b확인 후 배열 생성--->>평균보다 높은 것이 몇개일까
		
		int num=0;
		for(int v : data) { //향상된 for문
			if(v>avg) {//평균보다 높은 값들은 몇개?
				num++;
			}
		}
		System.out.println("평균보다 높은 값들은 : "+num+"개");//b완료
		
		int[] data2= new int[num]; //평균보다 높은 값들 저장할 공간 생성 완료
		
		int j =0;//data2 배열에 대한 인덱스
		for(int i=0; i<data.length; i++) {
			if(data[i]>avg) {
				data2[j++]=data[i];
				//-->data[i]를 data2[j]에 입력하고 j가 한칸 이동(탭 느낌)
			}
		}
		//[7]
		System.out.print("평균보다 큰 값은");
		for(int v:data2) {
			System.out.print(v+" ");
		}
		System.out.print("입니다.");
	}
}
