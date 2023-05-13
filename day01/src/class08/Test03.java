package class08;

public class Test03 {

	public static void main(String[] args) {
		
		int a =4;
		
		//범위가 좁은것부터 넓은 순서대로
		if(a%10 == 0) {
			System.out.println("10의 배수입니다");
		}
		else if(a%2 == 0) {
			System.out.println("짝수입니다");
		}
		else
			System.out.println("홀수입니다");
	}

}
