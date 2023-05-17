package class01;

class A {
	int num;
	A(int num){
		this.num = num;
	}
	
	void printInfo() {
		
	}

	@Override
	public boolean equals(Object obj) {
		A a = (A)obj;
		
		if(this.num == a.num) {
			return true;
		}
		return false;
	}
	
	
}

class B extends A{
	B(int num){
		super(num);
	}
}

class C extends A{
	C(int num){
		super(num);
	}
}

public class Test02 {

	public static void main(String[] args) {
		B b1 = new B(1); //B 클래스는 모두 1
		B b2 = new B(1);
		
		C c1 = new C(2); //C 클래스는 모두 1
		
		if(b1.equals(b2)) {
			System.out.println("O");
		}
		else {
			System.out.println("X");
		}

	}

}






















