package class01;

public class Test02 {

	public static void main(String[] args) {
		/*
		 * 2. ���̰� ����� �������ֽ��ϴ�.
		 * ���̰� 8~19�̸� 1000�� 20~65�̸� 2000��
		 * �������� ����! ��� ������ּ���
		 */
		int age = 24;
		
		if(age>=8 && age<=19) {
			System.out.println("1000��");
		}
		else if(age>=20 && age<=65) {
			System.out.println("2000��");
		}
		else {
			System.out.println("����");
		}
	}

}
