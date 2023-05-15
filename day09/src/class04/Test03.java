package class04;

import java.util.Random;

class Animal{ // 동물 클래스
	String name; 	//동물 이름
	int age; 		//동물 나이
	int playTime; 	// 놀아준 시간

	Animal(){ // 이름, 나이 생성 안했을때
		this("동물", 1);
	}
	
	Animal(int age){
		this("동물", age);
	}
	
	Animal(String name, int age){ // 이름, 나이 지정 가능
		this.name =name;
		this.age = age;
		this.playTime = 0; // 무조건 0분
	}
	
	void addAge() { // 나이 1씩 증가
		this.age++;
		System.out.println(this.name +"은/는 나이를 한살 더 먹었습니다");
		System.out.println("나이: "+this.age);
	}
	
	void play(int playTime) { // 사용자에게서 입력받은만큼 놀이 시간 추가
		this.playTime+=playTime;
		System.out.println(this.name+"은/는 "+this.playTime+"분 놀았습니다");
	}
		
}

//강아지 클래스 동물 클래스 상속
class Dog extends Animal{
	
	Dog(){ // 기본값 강아지, 1살
		super("강아지", 1);
	}
	
	Dog(int age){ //사용자가 나이 입력
		super("강아지", age);
	}
	
	Dog(String name, int age){ // 사용자가 이름, 나이 입력
		this.name = name;
		this.age = age;
	}
	
	void play(int playTime) { // 산책으로 오버라이딩
		this.playTime+=playTime;
		System.out.println(this.name+"은/는 산책을 "+this.playTime+"분 했습니다");
	}
	
	
}

// 고양이 클래스 동물 클래스 상속
class Cat extends Animal{
	
	Cat(){ // 기본값 나이 1
		this("고양이",1);
	}
	
	Cat(int age){ // 사용자가 나이 입력
		super("고양이",age);
	}
	
	Cat(String name, int age){ // 사용자가 이름, 나이 입력
		this.name = name;
		this.age = age;
	}
	
	void play(int playTime) { // 낚시 놀이로 오버라이딩
		this.playTime+=playTime;
		System.out.println(this.name+"은/는 낚시 놀이를 "+this.playTime+"분 했습니다");
	}
	
	
}

public class Test03 {
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		Dog[] dogData = new Dog[3]; //객체 배열 강아지 최ㅐ 3마리
		
		dogData[0] = new Dog();
		dogData[1] = new Dog("구름", 4);
		dogData[2] = new Dog(9);
	
		Animal a1 = new Animal();
		Cat c1 = new Cat(2);
		
		a1.addAge();
		a1.play(10);
		System.out.println();
		
		c1.addAge();
		c1.play(60);
		System.out.println();
		
		for(int i=0; i<3; i++) {
			dogData[i].addAge();
			dogData[i].play(rand.nextInt(91)+10); //10~ 100분 사이로 놀아준다
			System.out.println();
		}
		
		
	}
}



























