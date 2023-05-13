package class01;

public class Test01 {
	public static void main(String[] args) {
		int month = 0;
		String season;
		
		if(month>0 && month<13) {
			if(month>2 && month<6) {
				season="봄";
			}
			else if(month>5 && month<=9) {
				season="여름";
			}
			else if(month>8 && month<12) {
				season="가을";
			}
			else {
				season="겨울";
			}
			System.out.println("현재:"+season);
		}
		else
		System.out.println("잘못된 값입니다.");
	}

}
