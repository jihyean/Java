package class06;

public class Test02 {

	public static void main(String[] args) {
		for(int a=0; a<5; a++) {
			for(int i=0; i<4-a; i++) {
			System.out.print(" ");
			}
			for(int k=0; k<a+1; k++) {
			System.out.print("*");
			}
		System.out.println();
		}
		
	}

}