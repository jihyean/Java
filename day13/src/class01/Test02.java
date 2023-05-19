package class01;

public class Test02 {

	public static void main(String[] args) {
		int data[] = new int[3];
		for(int i =0; i<3; i++) {
			data[i] = i+1;
		}

		try {
			System.out.println(data[3]/data[0]);
		}
		catch(ArithmeticException e){
			System.out.println("0으로는 나눌 수 없습니다");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("해당 인덱스는 없는 인덱스입니다");
		}
		finally {
			System.out.println("예외발생여부 무관하게 수행되는 코드");
		}
	}

}
