package class06;

public class Test01 {

	public static void main(String[] args) {
		for(int a=0;   a<5; a++) {//�� 5���̹Ƿ� 5�� �ݺ��Ѵ�
			for(int i=0; i<5-a; i++) {//a�� 1�� �����ϰ� i�� ������ �ö�����
				System.out.print("*");//���� �پ��Ƿ� 5��-a����ŭ ���� ������
			}
			System.out.println();
		}
	}
}
