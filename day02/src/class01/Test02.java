package class01;

public class Test02 {

	public static void main(String[] args) {
		/*
		 * 2. 나이가 저장된 변수가있습니다.
		 * 나이가 8~19이면 1000원 20~65이면 2000원
		 * 나머지는 무료! 라고 출력해주세요
		 */
		int age = 24;
		
		if(age>=8 && age<=19) {
			System.out.println("1000원");
		}
		else if(age>=20 && age<=65) {
			System.out.println("2000원");
		}
		else {
			System.out.println("무료");
		}
	}

}
