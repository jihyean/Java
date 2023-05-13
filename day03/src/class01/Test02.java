package class01;

public class Test02 {

	public static void main(String[] args) {
		
		int[] stu = new int[3];
		//new 연산 : 메모리 공간에 생성해줘 --->함수 아님
		
		stu[0]=20;
		stu[1]=50;
		stu[2]=75;
		
		for(int i=0; i<3; i++) {
		System.out.println("학생"+i+"의 점수는 "+stu[i]+"점입니다.");
		}
		

	}

}
