package class01;

public class Test01 {
	public static void main(String[] args) {
		int month = 0;
		String season;
		
		if(month>0 && month<13) {
			if(month>2 && month<6) {
				season="��";
			}
			else if(month>5 && month<=9) {
				season="����";
			}
			else if(month>8 && month<12) {
				season="����";
			}
			else {
				season="�ܿ�";
			}
			System.out.println("����:"+season);
		}
		else
		System.out.println("�߸��� ���Դϴ�.");
	}

}
