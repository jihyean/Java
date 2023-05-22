package class02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Product {
   static Scanner sc = new Scanner(System.in);

   private int num; // 상품 PK
   private String name;// 상품명
   private int price; // 상품 가격
   private int cnt; // 상품 재고

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

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getCnt() {
      return cnt;
   }

   public void setCnt(int cnt) {
      this.cnt = cnt;
   }

   // 생성자 이름, 가격을 사용자가 입력
   Product(int num, String name, int price) {
      this(num, name, price, 0);
   }

   // 생성자 이름, 가격, 재고를 사용자가 입력
   Product(int num, String name, int price, int cnt) {
      this.num = num;
      this.name = name;
      this.price = price;
      this.cnt = cnt;
   }

   // 구매 메서드
   boolean sell(int cnt) {

      // 재고가 구매량보다 많으면
      if (this.cnt >= cnt) {
         System.out.println("가격은 " + (this.price * cnt) + "원 입니다");
         System.out.println("돈을 입력해주세요");

         while (true) { // 올바르게 돈을 입력할때까지 반복
            int money = -1;
            try { // 돈 입력에 정수 예외처리
               System.out.println("입력: ");
               money = sc.nextInt();
            } catch (InputMismatchException e) {
               sc.nextLine();
               System.out.println("숫자로 입력해주세요");
               continue;
            }

            if (money >= (this.price * cnt)) { // 돈을 총 가격보다 많이 내면
               System.out.println("잔돈: " + (money - (this.price * cnt)));
               this.cnt -= cnt;
               System.out.println("구매완료");
               break;

            } else { // 입력된 돈이 부족한 경우
               System.out.println("다시 입력해주세요");
            }
         }
         return true; // 정상 지불 완료
      }
      // 재고가 부족할시
      else {
         System.out.println("재고가 부족합니다");
         return false;
      }
   }

   // 재고 변경 메서드
   void changeCnt(int cnt) {

      if ((this.cnt + cnt) < 0) {
         System.out.println("올바르게 입력해주세요\n" + "현재 재고: " + this.cnt);
      } else {
         this.cnt += cnt;
         System.out.println("재고가 변경되었습니다\n" + "현재 재고: " + this.cnt);
      }
   }

   @Override
   public String toString() { // toString 오버라이딩

      if (this.cnt <= 0) {
         return this.num + ". " + this.name + " 가격: " + this.price + "원 재고: " + "[품절]";
      }

      return this.num + ". " + this.name + " 가격: " + this.price + "원 재고: " + this.cnt + "개";
   }

}

public class Test01 {

   // 입력 번호의 상품이 있는지 검사
   public static int checkNum(ArrayList<Product> data) {
      Scanner sc = new Scanner(System.in);

      int num;
      boolean flag = false;
      boolean flag2 = false;
      while (true) {
         num = checkAction(); // 숫자만 입력(예외처리)
         int i;
         for (i = 0; i < data.size(); i++) {
            if (num == data.get(i).getNum()) {
               flag = true;
               return i; // 상품 존재시 해당상품 인덱스 반환
            }
         }
         System.out.println("존재하지 않는 상품입니다");
         System.out.println("다시 입력해주세요");
      }

   }

   public static int checkAction() { // 숫자만 입력처리(예외)
      Scanner sc = new Scanner(System.in);

      int action = 0;

      while (true) {
         try {
            System.out.print("입력: ");
            action = sc.nextInt(); // 사용자의 행동을 입력받을 변수
            return action;
         } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("숫자로 입력해주세요");
            // continue;
         }
      }
   }

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      ArrayList<Product> data = new ArrayList<Product>(); // 상품 배열리스트
      int numPK = 1001; // 1001번부터 순서대로 부여

      boolean flag = false; // 유효성 검사를 위한 변수
      boolean flag2 = false;// 프로그램 완전 종료를 위한 변수

      // 유저 선택창
      String userMsg = "\n1. 상품목록출력\n" + "2. 구매하기\n" + "3. 프로그램종료\n";

      // 관리자 선택창
      String managerMsg = "\n1. 상품추가\n" + "2. 상품재고변경\n" + "3. 상품삭제\n" + "4. 관리자모드종료\n" + "5. 프로그램종료\n";

      while (true) { // 종료할때까지 반복

         int action = 0;

         System.out.println(userMsg);
         action = checkAction();

         // 사용자 모드 기능1 선택
         // 상품 목록 출력
         if (action == 1) {
            System.out.println("1. 상품목록출력");

            // 출력할 상품이 없을시
            if (data.size() <= 0) {
               System.out.println("등록된 상품이 없습니다");
               continue;
            }

            for (Product product : data) {
               System.out.println(product);
            }

         }
         // 사용자 모드 기능2 선택
         // 상품 번호와 구매수량을 입력 받아 구매
         else if (action == 2) {
            System.out.println("2. 구매하기");

            if (data.size() <= 0) {
               System.out.println("등록된 상품이 없습니다");
               continue;
            }

            System.out.println("구매하실 상품 번호를 입력해주세요");

            // 존재하는지 검사
            int index = checkNum(data);

            System.out.println("얼마나 구매하시겠습니까?");

            int cnt;
            
            while (true) {
               cnt = checkAction(); // 숫자만 입력 예외처리

               if (cnt < 0) {
                  System.out.println("0보다 큰 수를 입력해주세요");
                  continue;
               }

               data.get(index).sell(cnt);
               break;
            }
         }
         // 사용자 모드 기능3 선택
         // 프로그램 종료
         else if (action == 3) { // break로 프로그램 종료
            System.out.println("프로그램을 종료합니다...");
            break;
         }
         // 숨겨진 코드 1234 입력시, 관리자모드 이동
         else if (action == 1234) { // 관리자 모드 진입

            System.out.println("관리자 모드 비밀번호를 입력해주세요");
            action = checkAction(); // 숫자만 입력

            if (action != 5678) {
               System.out.println("비밀번호가 일치하지 않습니다");
               continue;
            }

            while (true) { // 관리자 모드 종료을 선택하지 않으면 반복

               System.out.println(managerMsg); // 관리자 모드 목록 출력
//               System.out.print("입력: ");
//               action = sc.nextInt();

               action = checkAction(); // 숫자만 입력

               for (Product product : data) {
                  System.out.println(product);
               }

               // 관리자 모드 기능 1
               // 상품 추가 PK는 자동입력
               if (action == 1) {
                  System.out.println("1. 상품추가");
                  System.out.println("추가하실 상품 이름을 입력해주세요");

                  flag = false;
                  String name;
                  while (true) { // 이름 확인
                     System.out.print("입력: ");
                     name = sc.next();

                     System.out.println("정말 " + name + "(으)로 하시겠습니까?");
                     System.out.println("1.예 2.아니오");

                     action = checkAction(); // 숫자만 입력
                     if (action == 1) {
                        flag = true;
                     } else {
                        System.out.println("다시 입력해주세요");
                     }

                     if (flag) {
                        break;
                     }
                  }

                  System.out.println("해당 상품의 가격을 입력해주세요");

                  int price;
                  flag = false;
                  while (true) {
                     price = checkAction(); // 숫자만 입력

                     if (price < 0) {
                        System.out.println("가격은 양수로 입력해주세요");
                        continue;
                     }

                     System.out.println("정말 " + price + "으로 하시겠습니까?");
                     System.out.println("1.예 2.아니오");

                     action = checkAction(); // 숫자만 입력

                     if (action == 1) {
                        flag = true;
                     } else {
                        System.out.println("다시 입력해주세요");
                     }

                     if (flag) {
                        break;
                     }
                  }

                  System.out.println("재고도 입력하시겠습니까?");
                  System.out.println("1. 재고 입력 없음 2. 재고 입력");
                  action = checkAction(); // 숫자만 입력

                  // 재고 입력 안함 선택 ---> 재고: 0
                  if (action != 2) {

                     data.add(new Product(numPK++, name, price));
                     System.out.println(data);
                  }
                  // 재고 입력 선택
                  else if (action == 2) { // 사용자가 입력한 값으로 등록
                     System.out.println("해당 상품의 재고를 입력해주세요");

                     flag = false;
                     while (true) { // 재고 0이상 입력 유효성 검사
                        int cnt = checkAction();
                        if (cnt >= 0) {
                           flag = true;
                           data.add(new Product(numPK++, name, price, cnt));
                           System.out.println("추가되었습니다");
                        } else {
                           System.out.println("0 이상의 숫자를 입력해주세요");
                        }

                        if (flag) {
                           break;
                        }
                     }

                  }
                  // else 추가 할것

               }
               // 관리자 모드 기능2
               // 상품 재고 변경
               else if (action == 2) {
                  System.out.println("2. 상품재고변경");

                  if (data.size() <= 0) {
                     System.out.println("등록된 상품이 없습니다.\n");
                     continue;
                  }

                  System.out.println("재고를 변경하실 상품의 번호를 입력해주세요");

                  int index = checkNum(data); // 존재하는 상품인지 검사

                  System.out.println("재고를 얼마나 변경하시겠습니까?");
                  System.out.println("음수 입력시 재고가 감소됩니다");
                  int cnt = checkAction(); // 숫자만 입력

                  System.out.println("정말 변경하시겠습니까?");

                  while (true) {
                     System.out.println("1.예 2.아니오");
                     action = checkAction(); //숫자만 입력

                     if (action == 1) {
                        data.get(index).changeCnt(cnt);
                        break;
                     } else if (action == 2) {
                        System.out.println("변경 취소 되었습니다.");
                        break;
                     } else {
                        System.out.println("1과 2중에 선택 해주세요");
                     }
                  }

               }
               // 관리자 모드 기능 3
               // 상품 삭제
               else if (action == 3) {
                  System.out.println("3. 상품삭제");

                  if (data.size() <= 0) {
                     System.out.println("등록된 상품이 없습니다.\n");
                     continue;
                  }

                  System.out.println("삭제하실 상품의 번호를 입력해주세요");

                  int index = checkNum(data); // 존재하는 상품인지 검사

                  System.out.println("정말 삭제하시겠습니까?");

                  while (true) {
                     System.out.println("1.예 2.아니오");
                     action = checkAction(); // 숫자만 입력

                     if (action == 1) {
                        data.remove(index);
                        System.out.println("삭제되었습니다");
                        break;
                     } else if (action == 2) {
                        System.out.println("삭제 취소되었습니다.");
                        break;
                     } else {
                        System.out.println("1과 2중에 골라주세요");
                     }
                  }
               }
               // 관리자 모드 기능4
               // 관리자 모드 종료 ---> 사용자 모드로 이동
               else if (action == 4) {
                  System.out.println("4. 관리자모드종료");
                  System.out.println("관리자 모드를 종료합니다...");
                  break;
               } 
               else if (action == 5) {
                  System.out.println("5. 프로그램 종료");
                  System.out.println("프로그램을 완전 종료합니다...");
                  flag2 = true;
                  break;
               }
               else {
                  System.out.println("목록 중에 선택해주세요");
               } // 관리자 모드 if 닫힘

            } // 관리자 모드 반복 while 닫힘

         } else {
            System.out.println("목록 중에 선택해주세요");
         } // 사용자 모드 if 닫힘
         
         if(flag2) {
            break;
         }

      } // 전체 반복 while문 닫힘
   }

}
