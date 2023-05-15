package class00;

class Point {
   int x;
   int y;

   Point() {
      this(0,0);
   }

   Point(int x) {
      this(x, x);
   }

   Point(int x, int y) {
      this.x = x;
      this.y = y;
   }

   void printInfo() {
      System.out.println("현재 위치는 (" + x + "," + y + ")입니다");
   }
   
   void move() {
      this.x+=1;
      this.y+=1;
   }
   
   void move(int x) {
      this.x+=x;
      this.y+=x;
   }

   void move(int x, int y) {
      this.x +=x;
      this.y +=y;

   }
}

public class Test01 {

   public static void main(String[] args) {
      Point point1 = new Point();
      Point point2 = new Point(10);
      Point point3 = new Point(2,3);
      
      point1.move();
      point2.move(3);
      point3.move(4,5);
      
      point1.printInfo();
      point2.printInfo();
      point3.printInfo();
   }

}