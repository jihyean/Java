package class01;

abstract class Pokemon{
	private String name;
	private int win;
	
	Pokemon(String name){
		this.name = name;
		this.win = 0;
	}
	
	abstract void hello();
	
	boolean game(Pokemon pokemon) {
		
		int abs1;
		int abs2;
		
		//홀짝
		if(this.getWin()%2==0) {
			abs1 = 1;
		}
		else {
			abs1 =0;
		}
		
		if(pokemon.getWin()%2==0) {
			abs2 = 1;
		}
		else {
			abs2 = 0;
		}
		
		// 게임
		if(this.getWin()==pokemon.getWin()) { // 둘이 숫자가 같음
			
			this.win++;
			
			System.out.println(this.getName()+"이 총 "+(this.getWin())+"번 이겼습니다");
			return true;
		}
		else if(abs1!=abs2) { // 둘이 홀짝이 다름
			if(abs1 == 0) {
				this.setWin(this.getWin()+1);
				
				System.out.println(this.getName()+"이 총 "+(this.getWin())+"번 이겼습니다");
				return true;
			}
			else {
				
				pokemon.setWin(pokemon.getWin()+1);
				
				System.out.println(pokemon.getName()+"이 총 "+(pokemon.getWin())+"번 이겼습니다");
				return false;
			}
		}
		else { //홀짝이 같음 
			if((abs1==1 && this.getWin()> pokemon.getWin()) || (abs1==0 && this.getWin()< pokemon.getWin())) {
				
				this.setWin(this.getWin()+1);
				
				System.out.println(this.getName()+"이 총 "+(this.getWin())+"번 이겼습니다");
				return true;
			}
			else {
				
				pokemon.setWin(pokemon.getWin()+1);
				
				System.out.println(pokemon.getName()+"이 총 "+(pokemon.getWin())+"번 이겼습니다");
				return false;
			}
		}
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}
}

class Pika extends Pokemon{

	Pika(String name) {
		super(name);
	}

	@Override
	void hello() {
		System.out.println("피카피카");
		
	}

	@Override
	boolean game(Pokemon pokemon) {
		
		int abs1;
		int abs2;
		
		//홀짝
		if(this.getWin()%2==0) {
			abs1 = 1;
		}
		else {
			abs1 =0;
		}
		
		if(pokemon.getWin()%2==0) {
			abs2 = 1;
		}
		else {
			abs2 = 0;
		}
		
		// 게임
		if(this.getWin()==pokemon.getWin()) { // 둘이 숫자가 같음
			
			this.setWin(this.getWin()+1);
			
			System.out.println(this.getName()+"이 총 "+(this.getWin())+"번 이겼습니다");
			return true;
		}
		else if(abs1!=abs2) { // 둘이 홀짝이 다름
			if(abs1 == 0) {
				this.setWin(this.getWin()+1);
				
				System.out.println(this.getName()+"이 총 "+(this.getWin())+"번 이겼습니다");
				return true;
			}
			else {
				
				pokemon.setWin(pokemon.getWin()+1);
				
				System.out.println(pokemon.getName()+"이 총 "+(pokemon.getWin())+"번 이겼습니다");
				return false;
			}
		}
		else { //홀짝이 같음 
			if((abs1==1 && this.getWin()> pokemon.getWin()) || (abs1==0 && this.getWin()< pokemon.getWin())) {
				
				this.setWin(this.getWin()+1);
				
				System.out.println(this.getName()+"이 총 "+(this.getWin())+"번 이겼습니다");
				return true;
			}
			else {
				
				pokemon.setWin(pokemon.getWin()+1);
				
				System.out.println(pokemon.getName()+"이 총 "+(pokemon.getWin())+"번 이겼습니다");
				return false;
			}
		}
		
		
	}
	
	@Override
	public String toString() {
		return this.getName()+"이 총 "+(this.getWin())+"번 이겼습니다";
	}
	
	
}

public class Test03 {

	public static void main(String[] args) {
		
		Pika p1 = new Pika("피카츄1");
		Pika p2 = new Pika("피카츄2");
		Pika p3 = new Pika("피카츄3");
		Pika p4 = new Pika("피카츄4");
		Pika p5 = new Pika("피카츄5");
		
		
		p2.game(p1);
		p1.game(p2);
		p1.game(p2);
		p1.game(p2);
		System.out.println();
		
		p2.game(p3);
		p4.game(p5);
		System.out.println();
		
		p1.game(p3);
		p1.game(p4);
		p1.game(p5);
		System.out.println();
		
		p3.game(p5);
		
		System.out.println();
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		
		
		
		
		
//		if(p1.game(p2)) {
//			
//		}
//		else {
//			p2.setWin(p2.getWin()+1);
//		}

	}

}






























