package class02;

import java.util.Random;
import java.util.Scanner;

public class Test03 {

   /*
   명예의 전당
   2의 게임을 통과한 사람들의 목록을 출력해주세요!~~

   1. 홍길동
   2. 임꺽정
   3. 티모
   4. 아트록스
   5. 모르가나

   최대 5명
   5명 찰때까지 계---속
    */

   // [2]의 게임을 시작하기전에,
   // for(명예의 전당에 저장된 사람의 수만큼)
   // 배열 OK! String[] data=new String[5];

   public static boolean check(int num,String user) {
      final int NUM=num;
      // final : 상수화

      int cnt=0; // 박수 횟수 카운트할 변수

      // 1. 진짜 정답을 만들기 String ans
      //////////////////////////////////////////////////
      int x=1000;
      while(x>0) {
         int n=num/x; // 1000인 경우, 1을 의미함
         if(n==3 || n==6 || n==9) {
            cnt++;
         }

         num%=x; // 1312인 경우, 13을 의미하게 되므로 전처리가 필수!
         x/=10;
      }
      //////////////////////////////////////////////////

      String ans="";
      for(int i=0;i<cnt;i++) {
         ans+="짝";
      }
      if(cnt==0) {
         // 형변환(casting)
         // 최초의 num값을 기억해줄 변수가 필요하구나!
         ans=Integer.toString(NUM);
      }      

      // 2. ans와 user를 비교
      System.out.println("ans: "+ans);
      System.out.println("user: "+user);
      if(ans.equals(user)) {
         return true;
      }
      return false;
      // 연산자는 기본 자료형(원시타입)에게만 적용되는 문법
      // 클래스(객체)들은 연산자로 비교불가능
   }

   public static void main(String[] args) {

      Scanner sc=new Scanner(System.in);
      Random rand=new Random();


      	String[] data=new String[5];
      	
//      //null 대신 "____________" 표시
//      for(int i=0;i<data.length;i++) {
//         data[i]="_____";
//      }
      
      int dataCnt=0; // 명예의 전당에 저장된 사람의 수

      //5명이 다 차지 않으면 계속
      while(dataCnt<data.length) {

    	 //명예의 전당 출력(입력된 이름 만큼)
         for(int i=0;i<dataCnt;i++) {
            System.out.println((i+1)+". "+data[i]);
         }
         System.out.println("--------------------");

         int i=0;
         while(i<3) {// 세번 맞추면 명예의 전당 입력 가능

            int randNum=rand.nextInt(1000)+1;
            System.out.print("["+randNum+"] : ");
            String userAns=sc.next();

            if(!check(randNum,userAns)) {//오답시 종료
               System.out.println("오답입니다.....");
               break;
            }
            System.out.println("정답입니다!");
            i++;

         }

         //명예의 전당에 이름 입력
         if(i==3) {
            System.out.print("명예의 전당에 올릴 이름을 입력) ");
            data[dataCnt]=sc.next();
            System.out.println(data[dataCnt]+"님, 축하합니다! :D");
            dataCnt++;
         }

      }

   }

}