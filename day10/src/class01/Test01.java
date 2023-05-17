package class01;

// [ 상속 - 심화 ]
class Pokemon{
   String name;
   
   Pokemon(){
      this("포켓몬");
   }
   
   Pokemon(String name){
      this.name=name;
   }
   
   void printInfo() {
      System.out.println("이 포켓몬은 "+this.name+"입니다.");
   }
   
   // 최상위 클래스 Object로부터 상속받은 메서드인 equals()를
   // 살짝 바꿔서 사용하고싶음!
   //  -> 오버라이딩
   
//   void func(double d) {
//	   d =10.0;
//	   int i = (int)d;
//   }
   
   @Override // 어노테이션 : 프로그램이 인지하는 주석
   public boolean equals(Object obj) {
	   
	   Pokemon pokemon = (Pokemon)obj;	// 강제 형변환, 명시적 형변환, 다운 캐스팅
      
      if(this.name.equals(pokemon.name)) {
         return true;
      }
      
      return false;
   }
   
}

class Pika extends Pokemon{
   Pika(){   
      super("피카츄");
   }
}

class Charmander extends Pokemon{
   Charmander(){
      super("파이리");
   }
}

public class Test01 {

   public static void main(String[] args) {
      
      Pika p1=new Pika();
      Pika p2=new Pika();
      Charmander c1=new Charmander();
      
      // p1,c1을 키우미집에 맡겼다!
      // 객체를 비교할때, 두개의 객체가 같은주소야? xxxxx
      // 연산자의 대상이 객체가 될수없음!!!!!
      //  ex) 문자열
      // equals()메서드는 두개의 객체가 같은주소일때 T
      if(p1.equals(c1)) {
         System.out.println("알을 획득했습니다!");
      }
      else {
         System.out.println(".....");
      }
      
      // ★★★ Object 클래스
      //  : JAVA에서 기본제공해주는 최상위 클래스
      
      
   }

}

