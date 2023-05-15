package class06;

public class Test05 {
	public static int abs(int num) {
		if(num<0) {
			num*=(-1);
			return num*(-1);
		}else {
			return num;
		}
		//return num>0? num:num*(-1);
	}

	public static void main(String[] args) {
		
		abs(10);
		abs(-10);
	}

}
