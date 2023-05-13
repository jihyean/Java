package class03;

//while문 일반적으로 무한루프일때 사용
public class Test02 {

	public static void main(String[] args) {

		//무한루프는 위험
		//웹 개발에서 '서버자원' 활용 > 비용증가
		int i=0;
		while(true) {
			System.out.println("안녕");
			i++;
			if(i==3) {
				break;		
			}
			System.out.println("*");
		}//무한루프는 종료조건이 반드시 필요
		
	}
}
