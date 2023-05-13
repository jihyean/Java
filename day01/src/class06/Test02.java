package class06;

public class Test02 {
	public static void main(String[] args) {
	
		int x = 10;
		int y;
		
		y=++x;
		System.out.println("1. data="+x);
		System.out.println("1. data="+y);
		
		y=x++;
		System.out.println("2. data="+x);
		System.out.println("2. data="+y);
		
		System.out.println("3. data="+x);
		System.out.println("3. data="+y);
		
		int a=10;
		int b=20;
		int c=++a - b--;
		int d=a-- * ++c;
		
		System.out.println(a);
		
	}
}
