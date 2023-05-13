package class01;

public class Test04 {

	public static void main(String[] args) {
		// 학생 n명
		// 총 점수 합
		// 평균점수
		// 1등이 몇번?
		
		int [] stu = new int[5];
		
		stu[0]=10;
		stu[1]=70;
		stu[2]=52;
		stu[3]=80;
		stu[4]=100;
		
		//
		System.out.println("====== 학생 명단 ======");
		for(int i=0; i<stu.length; i++){
			System.out.println("학생"+(i+1)+"번은 "+stu[i]+"점입니다.");
		}
		System.out.println("학생 명단");
		
		//총합
		int sum=0;
		for(int i=0; i<stu.length; i++){
			sum+=stu[i];
		}
		System.out.println("총점은"+sum+"점입니다.");
		
		//평균
		double avg=sum*1.0/stu.length;	//sum을 int에서 double 타입으로 형변환(casting)
		System.out.println("평균은"+avg+"점입니다.");
		
		//최대값
		int max=stu[0];
		int maxIdex=0;
		for(int i=0; i<stu.length; i++){
			max = max<stu[i] ? stu[i] : max;
			maxIdex = max<stu[i] ? i : maxIdex;
			
//			if(max<stu[i]) {
//				max=stu[i]
//				maxIdex = i
//			}
		}
		System.out.println("1등인 학생은 "+maxIdex+"번 학생이며 1등의 점수는 "+max+"점입니다.");
	}
}
