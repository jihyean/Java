package class03;

public class Test03 {

	/*
	 * a���� b���� ���
	 * a=33 b=29 29 30 31 32 33
	 * ���ѷ����� Ȱ���ؾ���
	 */
	public static void main(String[] args) {
		int a = 33;
		int b = 29;
		
		if(a>b) {//��ȯ
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
