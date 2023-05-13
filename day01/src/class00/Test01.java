package class00;

public class Test01 {

	public static void main(String[] args) {
		
		int month = 6;
		if(month>2 && month<6) {
			System.out.println("봄");
		}
		else if(month>5 && month<=9) {
			System.out.println("여름");
		}
		else if(month>8 && month<=12) {
			System.out.println("가을");
		}
		else
			System.out.println("겨울");
	}

}
