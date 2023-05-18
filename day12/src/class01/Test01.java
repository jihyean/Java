package class01;

import java.util.ArrayList;

public class Test01 {

	public static void main(String[] args) {
		
		ArrayList<Integer> data = new ArrayList<>();
		data.add(10);
		data.add(0,20);
		data.add(0,30);
		data.add(0,30);
		data.add(1,40);
		data.remove(0);
		data.clear();
		
		
		System.out.println(data); 
		System.out.println(data.isEmpty()); 
		//System.out.println(data.get(0)); 
		
		//data.add("사과");
		data.add(10);
		//data.add(3.14);
		System.out.println(data);
		

	}

}



















