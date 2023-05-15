package class06;

public class Test02 {
	public static void func(int a) { //int b로 바꾸면 이해가 쉽다
		a=100;
		System.out.println("func()입니다 a= "+a);
	}
	

	public static void main(String[] args) {
		int a = 10;
		System.out.println("a= "+a);	//출력: a= 10
		func(a);						//출력: a= 100
		System.out.println("a= "+a);	//출력: a= 10
		func(++a);						//출력: a= 100 a=11로 변경
		System.out.println("a= "+a);	//출력: a= 11
		

	}

}
