package class01;

import java.util.HashSet;
import java.util.Set;

public class Test02 {

	public static void main(String[] args) {
		HashSet<Integer> data= new HashSet<Integer>();
		
		data.add(10);
		data.add(10);
		data.add(10);
		data.add(1234);
		data.add(1);
		data.add(2);
		data.add(12);
		data.add(13);
		data.add(11);
		//data.add("apple");
		
		System.out.println(data);

	}

}
