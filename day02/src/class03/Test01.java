package class03;

public class Test01 {

	public static void main(String[] args) {
		int a = 10;
		int b = 9;
		
		if(a>b) {//±³È¯
			int tmp;
			tmp=a;
			a=b;
			b=tmp;
		}
		
		int i = a;
		while(i<=b) {
			System.out.println(i+" ");
			i++;
		}

	}

}
