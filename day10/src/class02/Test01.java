package class02;
// 점 프로그램 원본 (유효성 없음)
import java.util.Scanner;

class Point {
	int x;
	int y;

	Point() { // 기본값 (0,0)
		this(0, 0);
		System.out.println("1");
	}

	Point(int x, int y) { // x, y 사용자에게 입력받아 생성
		this.x = x;
		this.y = y;
		
		System.out.println("2");
	}

	void printInfo() {
		System.out.println("점(" + this.x + "," + this.y + ")");
	}

	void move() {
		this.x++;
		this.y++;
	}

	void move(int x) {
		this.x += x;
		this.y += x;
	}

	void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "점(" + this.x + "," + this.y + ")";
	}
	
	

}

class ColorPoint extends Point {
	String color;

	ColorPoint() {
		this(0, 0);
		System.out.println("3");
	}

	ColorPoint(int x, int y) {
		this("검정", x, y);
		System.out.println("4");
	}

	ColorPoint(String color, int x, int y) {
		super(x, y);
		this.color = color;
		System.out.println("5");
	}
	
	void printInfo() {
		System.out.println(this.color+"(" + this.x + "," + this.y + ")");
	}

	void colorChange(String color) {
		this.color = color;
		System.out.println("색이 " + this.color + "로 변경되었습니다");
	}
	
	@Override
	public String toString() { //printInfo를 만들지 않아도 원하는 방식으로 출력 가능 > 자원 절약
		// TODO Auto-generated method stub
		return this.color+"(" + this.x + "," + this.y + ")";
	}
}

public class Test01 {
	
	public static void addPoint(Point point1, Point point2) {
		Point resPoint = new Point();
		resPoint.x = point1.x + point2.x;
		resPoint.y = point1.y + point2.y;
		
		System.out.println(point1);
		System.out.println(point2);
		System.out.println(resPoint.x + resPoint.y);
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String menu = "====== 메뉴 ======\n" + "1. 점 생성\n" + "2. 점 목록 출력\n" + "3. 점 1개 출력\n" + "4. 점 이동\n" + "5. 색 변경\n"
				+ "6. 점 합치기\n" + "7. 프로그램 종료\n" + "==================\n " + "\n" + "번호 입력 : ";

		Point[] data = new Point[3];
		
		int index = 0;
		while(true) {
			
			System.out.println(menu);

			int action = sc.nextInt();
			
		if (action == 1) {
			System.out.println("원하는 점을 선택하세요");
			System.out.println("1.점\n"+"2.색깔이 있는 점");
			System.out.println("입력: ");
			action = sc.nextInt();
			
			if(action==1) {
				System.out.println("1.생성할 좌표를 알고있는 경우\n"+"2.모르는 경우");
				System.out.println("입력: ");
				action = sc.nextInt();
				
				if(action == 1) {
					System.out.println("x좌표 입력: ");
					int x =sc.nextInt();
					
					System.out.println("y좌표 입력: ");
					int y =sc.nextInt();
					
					
					data[index++] = new Point(x, y);
					System.out.println("점("+x+","+y+")이 생성되었습니다");
					
				}
				else if(action == 2) {
					data[index++] = new Point();
					System.out.println("점 (0,0)이 생성되었습니다");
				}
				
			}
			else if(action==2) {
				System.out.println("1.생성할 좌표와 색깔을 모두 알고있는 경우\n"+"2.좌표만 아는 경우\n"+"3.모르는 경우");
				System.out.println("입력: ");
				action = sc.nextInt();
				
				if(action == 1) {
					
					System.out.println("색깔 입력: ");
					String color = sc.next();
					
					System.out.println("x좌표 입력: ");
					int x =sc.nextInt();
					
					System.out.println("y좌표 입력: ");
					int y =sc.nextInt();
					
					data[index] = new ColorPoint(color, x, y);
					index++;
					System.out.println(color+"("+x+","+y+")이 생성되었습니다");
				}
				else if(action == 2) {
					
					System.out.println("x좌표 입력: ");
					int x =sc.nextInt();
					
					System.out.println("y좌표 입력: ");
					int y =sc.nextInt();
					
					data[index] = new ColorPoint(x, y);
					index++;
					System.out.println("검정("+x+","+y+")이 생성되었습니다");
					
				}
				else if(action == 3) {
					data[index] = new ColorPoint();
					index++;
					System.out.println("검정(0,0)이 생성되었습니다");
				}
				
			}
			
			
		}
		else if (action == 2) {
			
			System.out.println("===== 점 목록 =====");
			for(int i=0; i<index; i++) {
				data[i].printInfo();
			}
			System.out.println("=================");
			
//			다른 방식
//			for(Point point:data) {
//				if(point==null) {
//					break;
//				}
//				System.out.println(point);
//				///// == System.out.println(point.toString()); 둘이 같다
//			}
			
		}
		else if (action == 3) {
			
			System.out.println("출력을 원하는 점 번호를 입력해주세요");
			System.out.println("점 번호 입력: ");
			int num = sc.nextInt();
			
			data[num-1].printInfo();
			
		}
		else if (action == 4) {
			System.out.println("이동을 원하는 점 번호를 입력해주세요");
			System.out.println("점 번호 입력: ");
			int num = sc.nextInt();
			
			System.out.println("1.x, y 각각 이동\n"+"2.x,y 같은 값만큼 이동\n"+"3.모두 1씩 이동");
			action = sc.nextInt();
			
			if(action==1) {
				System.out.println("x좌표 입력: ");
				int x =sc.nextInt();
				
				System.out.println("y좌표 입력: ");
				int y =sc.nextInt();
				
				data[num-1].move(x,y);
				data[num-1].printInfo();
			}
			else if(action==2) {
				System.out.println("x좌표 입력: ");
				int x =sc.nextInt();
				
				data[num-1].move(x);
				data[num-1].printInfo();
			}
			else if(action==3) {
				data[num-1].move();
				data[num-1].printInfo();
			}
			
			
		}
		else if (action == 5) {
			
//			객체 instanceof 클래스
//			객체가 클래스 것인지
//			점 instanceof Point T
//			색깔점 instanceof Point T
			
			 System.out.print("index 번호 입력) ");
	            action=sc.nextInt();
	            if(data[action] instanceof ColorPoint) { // data[action]이 색깔점이야?
	               ColorPoint cp=(ColorPoint)data[action];
	               System.out.print("색 입력) ");
	               String color=sc.next();
	               cp.colorChange(color);
	            }
	            else {
	               System.out.println("색 변경 불가능!");
	            }
	            System.out.println(data[action]);
	            System.out.println();

					
			
//			System.out.println("색 변경을 원하는 점 번호를 입력해주세요");
//			System.out.println("점 번호 입력: ");
//			int num = sc.nextInt();
//			
//			System.out.println("무슨 색으로 변경할까요?");
//			String color = sc.next();
//			
//			
//			((ColorPoint) data[num-1]).colorChange(color); //컬러가 없을 경우 오버라이딩
//			

		}
		else if (action == 6) {
			System.out.println("합치고 싶은 점 번호를 입력해주세요");
			System.out.println("첫번째 점 번호 입력: ");
			int num1 =sc.nextInt();
			
			System.out.println("두번째 점 번호 입력: ");
			int num2 =sc.nextInt();
			
//			int x1 = data[num1-1].x;
//			int x2 = data[num1-1].x;
//			
//			add(x1, x2, y1, y2);
//			점A와 점B를 더해줘 > O
//			점A야 점B를 더해줘 > X 점, 즉 객체들은 주체가 아니다
//			기능을 개발할때는 주어(주체)가 누구인지를 고민해야 한다
			
			addPoint(data[num1-1], data[num2-1]);
			//System.out.println((data[num1-1].x+data[num2-1].x)+","+(data[num1-1].y+data[num2-1].y));
			
		}
		else if (action == 7) { //프로그램 종료
			break;
		}
		else {
			
		}
		
	}

	}

}
