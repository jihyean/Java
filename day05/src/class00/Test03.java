package class00;

public class Test03 {
	   public static void func1(int num) {
	      num+=100;
	   }
	   public static int func2(int num) {
	      return num--;
	   }
	   //함수를 호출할때 인자로 배열을 쓰는 경우
	   //(배열 특성상 주소값이 이동하기 때문에)
	   //참조에 의한 호출
	   public static void func3(int[] data) {
	      for(int i=0;i<data.length;i++) {
	         data[i]=123;
	      }
	   }
	   public static void main(String[] args) {

	      int num=10;
	      int[] data=new int[3];
	      for(int i=0;i<data.length;i++) {
	         data[i]=i+1; // [ 1, 2, 3 ]
	      }
	      
	      func1(num);
	      System.out.println("num1= "+num);
	      num = func2(num);
	      System.out.println("num2= "+num);
	      func3(data);
	      System.out.print("[ ");
	      for(int v:data) {
	         System.out.print(v+" ");
	         // [ ?, ?, ? ]
	      }
	      System.out.println("]");
	      
	   }
	}