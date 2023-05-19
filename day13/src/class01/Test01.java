package class01;

// [예외와 예외처리]

public class Test01 {

	public static void main(String[] args) {
		int a=10;
		int b=0; // 정수/정수 자체는 문제없음 >실행하려고 보니까 0
		

		try {
		System.out.println(a/b);
			
		}
		catch(ArithmeticException e) {
			System.out.println(a/1);
		}
	}

}
