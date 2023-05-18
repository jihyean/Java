package class02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Student {
   private int num; // PK
   private String name;
   private int score;
   
   Student(int num,String name){
      this.num=num;
      this.name=name;
      Random rand=new Random();
      this.score=rand.nextInt(101);
   }
   void test() {
      Random rand=new Random();
      this.score=rand.nextInt(101);
      System.out.println(this.name+"학생은 "+this.score+"점입니다.");
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getScore() {
      return score;
   }
   public void setScore(int score) {
      this.score = score;
   }
   @Override
   public String toString() {
      return this.num+"번 학생 "+this.name+" "+this.score+"점";
   }
}

public class Test01 {
   public static void main(String[] args) {

      Scanner sc=new Scanner(System.in);
      ArrayList<Student> data=new ArrayList<Student>();
      int numPK=1001; // 1001번부터 순서대로 부여
      // PK를 "사용자"로부터 입력받는경우, 반드시 "중복검사"를 해야함!
      // ex) ID
      
      while(true) {
         System.out.println("1. 학생목록출력");
         System.out.println("2. 재시험보기");
         System.out.println("3. 학생추가");
         System.out.println("4. 학생삭제");
         System.out.println("5. 프로그램종료");
         System.out.print("입력) ");
         int action=sc.nextInt();

         if(action==1) {
            for(Student student:data) {
               System.out.println(student);
            }
         }
         else if(action==2) {
        	 System.out.print("학생번호입력) ");
             int num=sc.nextInt();
             
             for(int i =0; i<data.size(); i++) {
            	 if(num == data.get(i).getNum()) {
            		 data.get(i).test();
            		 break;
            	 }
             }
             
             
         }
         else if(action==3) {
            System.out.print("학생이름입력) ");
            String name=sc.next();
            data.add(new Student(numPK++,name));
         }
         else if(action==4) {
        	 System.out.print("학생번호입력) ");
             int num=sc.nextInt();
             
             for(int i =0; i<data.size(); i++) {
            	 if(num == data.get(i).getNum()) {
            		 data.remove(i);
            		 break;
            	 }
             }

         }
         else {
            break;
         }

      }



























   }
}