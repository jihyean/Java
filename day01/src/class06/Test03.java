package class06;

public class Test03 {

	public static void main(String[] args) {
		System.out.println(10>=10);
		
		int age;
		
		age = 30;
		System.out.println(age>=19 && age<45);
		
		age = 50;
		System.out.println(!(age>=19 && age<45));
		
		int price;
		
		price=1500;
		System.out.println(price<=1000 || price>20000);

		boolean data = true;
		System.out.println(data);
		System.out.println(!(data));
	}

}
