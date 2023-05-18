package class01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		// 해시 set 집합, arrayList 선언
		HashSet<Integer> data= new HashSet<Integer>();
		ArrayList<Integer> data2 = new ArrayList<Integer>();
		
		// 10번 랜덤 수 생성해서 data 집합에 추가
		for(int i=0; i<10; i++) {
			int num = rand.nextInt(15)+1;
			data.add(num);
		}
		
		System.out.println("랜덤 수는 "+data.size()+"개 생성되었습니다");
		System.out.println(data);
		
		// 집합에는 인덱스가 없으므로 배열로 변환
		Integer[] arr = data.toArray(new Integer[0]);
		
		int sum1 = 0;	// 랜덤 생성된 수의 합
		for(int i=0; i<arr.length; i++) {
			sum1+=arr[i];
		}
		
		int sum2 = 0;	// 입력한 수의 합을 저장할 변수
		int cnt = 0;	// 입력한 수의 개수
		while(true) {
			System.out.println("정수를 입력해주세요");
			int num = sc.nextInt();
			
			if(num==0) { // 0일시 종료
				System.out.println("프로그램을 종료합니다");
				break;
			}
			
			// 0이 아니면
			cnt++;				// 개수 +1
			data2.add(num);		// arrayList에 저장
			sum2+=num;			// 합에 더하기
			
			if(num%2!=0) {		// 홀수일시
				data2.remove(data2.size()-1); //맨 마지막 위치(홀수)를 삭제
			}
		}
		
		double avg = ((sum1+sum2)*1.0)/(cnt+data.size()); // 1번과2번 합을 더하고 총 개수로 나눔
		System.out.println(data2);
		System.out.println("입력된 정수, 랜덤수들의 평균:"+avg);
		System.out.println("입력된 짝수의 수:"+data2.size());

	}

}



















