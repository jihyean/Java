package class00;

public class Test03 {

	public static void main(String[] args) {
		//1시간 20분 전 시간 출력
		int a = 3;
		int b = 40;
		
		if(a<=1) {
			a = a+12;
		}
		else if(a>1) {
			a = a-1;
		}
		
		if(b<=20) {
			b = b+40;
			a = a-1;
		}
		else if(b>20) {
			b = b-20;
		}
		
		System.out.println("1시간20분전 시각은 "+a+"시"+b+"분입니다.");
		

	}

}
