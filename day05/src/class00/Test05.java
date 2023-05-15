package class00;

//[오버로딩]
//기능은 같지만
//메서드 시그니처가 다른 경우에는
//(인자의 개수 자료형)
//함수명 중복 정의를 허용

//이는 자동완성 기능을 켜고 봐도 알 수 있다


public class Test05 {

	public static int plus01(int a, int b) {

		return a + b;
	}

	public static int plus02(int a, int b, int c) {

		return a + b + c;
	}
	
	public static double plus001(double a, double b) {

		return a + b;
	}
	
	public static double plus002(double a, double b, double c) {

		return a + b + c;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

























