package class07;

public class Test01 {

	public static void main(String[] args) {
		int data = 10>5 ? 1 : 2;
		System.out.println(data);
		
		int a = 100;
		int b = 200;
		int c = 9;
		
		int res1 = a>b ? a : b;
		System.out.println(res1);
		
		char res2 = (c%2)==0 ? 'E' : '0';
		System.out.println(res2);
	}

}
