package class01;

public class Test03 {

	public static void main(String[] args) {
		
		int[] data = new int[4];
		
		data[0]=5;
		data[1]=2;
		data[2]=3;
		data[3]=100;
		
		for(int i=0; i<data.length; i++)
		{
			System.out.println("음료"+(i+1)+"은 "+data[i]+"개 있습니다.");
		}
	}

}
