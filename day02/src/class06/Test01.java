package class06;

public class Test01 {

	public static void main(String[] args) {
		for(int a=0;   a<5; a++) {//총 5줄이므로 5번 반복한다
			for(int i=0; i<5-a; i++) {//a는 1씩 증가하고 i는 한줄이 늘때마다
				System.out.print("*");//별이 줄어드므로 5줄-a개만큼 별이 찍힌다
			}
			System.out.println();
		}
	}
}
