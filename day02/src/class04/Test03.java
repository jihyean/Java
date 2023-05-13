package class04;

public class Test03 {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 3;
		
		if(a>b) {//±³È¯
			int tmp;
			tmp=a;
			a=b;
			b=tmp;
		}
		
		for(int i=a; i<=b; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		a=1;
		b=10;
		for(int i=a; i<=b; i++) {
			if(i%2!=0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
		for(int i=a; i<=b; i++) {
			if(i%2==0) {
				continue;
			}
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}

}
