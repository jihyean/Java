package class02;

import java.util.Random;
import java.util.Scanner;

//강사님 풀이 1번
public class Test02 {
   
   // 메서드 시그니처를 먼저 고려할것
   // INPUT: int 1개, String 1개
   // OUTPUT: boolean
   // 정답과 사용자의 입력값을 비교해서,
   // 맞았는지 틀렸는지를 반환
   public static boolean check(int num,String user) {
      final int NUM=num;
      // final : 상수화
      
      int cnt=0; // 박수 횟수 카운트할 변수
      
      // 1. 진짜 정답을 만들기 String ans
      //////////////////////////////////////////////////
      int n=num/1000; // 1000인 경우, 1을 의미함
      if(n==3 || n==6 || n==9) {
         cnt++;
      }
      
      num=num%1000; // 1312인 경우, 13을 의미하게 되므로 전처리가 필수!
      n=num/100; // 1312->312, 3을 의미함
      if(n==3 || n==6 || n==9) {
         cnt++;
      }
      
      num=num%100;
      n=num/10; // 56인 경우, 5를 의미함
      if(n==3 || n==6 || n==9) {
         cnt++;
      }
      
      num=num%10;
      n=num/1; // 8인 경우, 8을 의미함
      if(n==3 || n==6 || n==9) {
         cnt++;
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
      
      // 1~1000 중에서 랜덤으로 정수 1개 생성
      // int randNum
      // [randNum] : 출력
      // 사용자가 정답을 입력 : 짝,19,22
      // String userAns=sc.next();
      // if(정답)
      //  syso("정답!");
      // else
      //  syso("오답...");
      
      int randNum=rand.nextInt(1000)+1;
      System.out.print("["+randNum+"] : ");
      String userAns=sc.next();
      
      if(check(randNum,userAns)) {
         System.out.println("정답입니다!");
      }
      else {
         System.out.println("오답입니다.....");
      }

   
      
   }

}