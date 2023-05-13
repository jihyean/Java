package class03;

public class Test03 {

	/*
	 * a부터 b까지 출력
	 * a=33 b=29 29 30 31 32 33
	 * 무한루프를 활용해야함
	 */
	public static void main(String[] args) {
		int a = 33;
		int b = 29;
		
		if(a>b) {//교환
			int tmp;
			tmp=a;
			a=b;
			b=tmp;
		}
		
		int num = a;
		while(true) {
			System.out.print(num+" ");
			num++;
			if(num>b) {
				break;		
			}
		}
		
	}
}
