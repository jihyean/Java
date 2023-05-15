package class06;

public class Test04 {
	//c 유형
	public static String func() {
		System.out.println("func() 동작");
		return "apple";
	}
	
	public static void main(String[] args) {
		//return값은 해당함수를 호출한 자리로 이동
		func();
		
		System.out.println("main() 공간: "+ func());
		//1. println 해주세요
		//2. func() 호출
		//2>>1
		
		String msg =func();				//apple
		//1. = 대입
		//2. func() 호출
		//2>>1
		
		System.out.println("msg: "+msg);//msg: apple
		
		//1. output이 있는 함수들은 
			//a)출력하거나
			//b)변수에 저장하거나
		
		//2. return 값은 함수를 호출한 자리로 이동
	}

}
