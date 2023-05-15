package class01;

import java.util.Random;
import java.util.Scanner;

//[ 과제 ]
//1. main()에서 정수를 10번 입력할예정입니다.
//2. if(짝수야?) a++;
//3. if(음수야?) b++;
//4. 10번 입력완료했습니다. a=ㅁ,b=ㅁ입니다.
//5. 만약, 입력된 정수가 0이라면 프로그램을 종료
//   3번 입력완료했습니다. a=2,b=1입니다.
//+) 함수를 활용해서 해당 과제를 해결해주세요!~~
//   함수는 최대 3개까지 활용할수있습니다.

public class Test01 {
   
   //data[i]값의 짝홀 구분
   public static int test1(int num) {
      if (num % 2 == 0) {
         return 0;
      }
      else {
         return 1;
      }
   }

   public static int test2(int num) {
	   if (num < 0) {
	         return 0;
	      }
	      else {
	         return 1;
	      }
   }
//배열 써서 망했네 ---> 입력값 기억할 이유없음, 중간에 0 입력시 뒤가 빈다
   public static void main(String[] args) {
      Random rand = new Random();
      Scanner sc = new Scanner(System.in);

      int N = 10;
      int data[] = new int[N];

      int a = 0;
      int b = 0;
      for (int i = 0; i < N; i++) {
         data[i] = sc.nextInt();

         if (data[i] == 0) {
            System.out.println("종료합니다");
            break;
         }
         else if (test1(data[i]) == 0) {
            a++; // a++;
         }
         else if(test2(data[i])==0){
            b++; // b++;
         }
      }
      System.out.println((a+b)+"번 입력완료 했습니다.");
      System.out.println("a= " + a + " b= " + b);

   }

}