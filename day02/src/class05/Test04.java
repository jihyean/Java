package class05;

public class Test04 {
	public static void main(String[] args) {
		for(int a=0; a<5; a++) {//총 5줄이므로 5번 반복한다
			for(int i=0; i<5-a; i++) {
				if(a>i) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}