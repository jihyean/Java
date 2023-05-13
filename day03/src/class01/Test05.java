package class01;

public class Test05 {
	public static void main(String[] args) {
		//배열 선언
		int [] stu = new int[6];
		//학생들의 점수 데이터 입력
		stu[0]=29;
		stu[1]=99;
		stu[2]=30;
		stu[3]=22;
		stu[4]=87;
		stu[5]=57;
		
		int sum=0;
		int sum2=0;
		int min=stu[0];
		int minIndex=0;
		int count=0;
		double avg;
		for(int i=0; i<stu.length; i++) {
			//전체 학생들의 점수 총합
			sum+=stu[i];
			
			//짝수번째 학생들의 점수 총합
			if(i%2!=0) {
				sum2+=stu[i];	
			}
			
			//꼴등 구하기
			if(min>stu[i]) {
				min=stu[i];
				minIndex=i;
			}
			
		}
		//평균
		avg =sum*1.0/stu.length;
		
		//평균을 넘겼는지 각 학생들을 체크
		for(int i =0; i<stu.length; i++) {
			if(avg<stu[i]) {
				count+=1;
			}
			else {
				System.out.println((i+1)+"번 학생은 평균을 넘기지 못했습니다.");
			}
		}
		
		System.out.println("학생들의 평균은 "+avg+"점입니다.");
		System.out.println("평균을 넘긴 학생 수는 "+count+"명입니다.");
		System.out.println("6등의 번호는 "+(minIndex+1)+"번입니다.");
		System.out.println("짝수번째 학생들의 총점은 "+sum2+"점입니다.");		
	}
	
 
}
