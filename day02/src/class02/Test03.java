package class02;

public class Test03 {

	public static void main(String[] args) {
		int a = 5;
		int b = 9;
		
		int i = a;
		while(i<=b) {
			System.out.println(i);
			i++;
		}
		
		a = -5;
		b = -3;
		
		i = a;
		while(i<=b) {
			System.out.println(i);
			i++;
		}
		
		a = 3;
		b = 1;
		
		i = b;
		while(i<=a) {
			System.out.println(i);
			i++;
		}
	}

}
