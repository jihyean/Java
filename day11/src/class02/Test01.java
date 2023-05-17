package class02;

class Player {

	private final static int maxIndex = 3;
	private int preIndex; // 1 생성할때 포켓몬 때문에

	private Pokemon[] data; // new Pokemon[maxIndex] static이 아니라 초기화 불가


	public Pokemon[] getData() {
		return data;
	}

	public void setData(Pokemon[] data) {
		this.data = data;
		
	}

	// 생성자
	Player() {
		this.preIndex = 1;
		this.data = new Pokemon[maxIndex];

		this.data[this.preIndex++] = new Pika();
		//this.data[1] = new Fire();
	}

	void play(Pokemon[] pokemon) {
		 
	}
	
	void addPokemon(int num) {
		
		if(num == 1) {
			this.data[preIndex] = new Pika();
		}
		else if(num==2) {
			this.data[preIndex] = new Fire();
		}
		else if(num==3) {
			this.data[preIndex] = new Meta();
		}
		
		this.preIndex++; // 인덱스++
	}

	@Override
	public boolean equals(Object obj) {
		Player player = (Player) obj;
		
		
		//(player.data[]).getName();
		
		if(1==1) {
			return false;
		}

		return true;
	}
	
	

}

abstract class Pokemon {
	private int win; // 이긴횟수
	private String name;

	Pokemon(String name) {
		this.name = name;
		this.win = 0;
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

	abstract void hello();

	boolean game(Pokemon pokemon) {

		int abs1;
		int abs2;

		// 홀짝
		if (this.win % 2 == 0) {
			abs1 = 1;
		} else {
			abs1 = 0;
		}

		if (pokemon.win % 2 == 0) {
			abs2 = 1;
		} else {
			abs2 = 0;
		}

		// 게임
		if (this.win == pokemon.win) { // 둘이 숫자가 같음

			this.win++;

			System.out.println(this.name + "이 총 " + this.name + "번 이겼습니다");
			return true;
		} else if (abs1 != abs2) { // 둘이 홀짝이 다름
			if (abs1 == 0) {
				this.win++;

				System.out.println(this.name + "이 총 " + this.win + "번 이겼습니다");
				return true;
			} else {

				pokemon.win++;

				System.out.println(pokemon.name + "이 총 " + pokemon.win + "번 이겼습니다");
				return false;
			}
		} else { // 홀짝이 같음
			if ((abs1 == 1 && this.win > pokemon.win) || (abs1 == 0 && this.win < pokemon.win)) {

				this.win++;

				System.out.println(this.name + "이 총 " + this.win + "번 이겼습니다");
				return true;
			} else {

				pokemon.win++;

				System.out.println(pokemon.name + "이 총 " + pokemon.win + "번 이겼습니다");
				return false;
			}
		}

	}

	@Override
	public boolean equals(Object obj) {
		
		Pokemon pokemon = (Pokemon) obj;
		
		if(this.getClass().isInstance(pokemon)) {
			return true;
		}
		
		return false;
	}
	
	

}

class Pika extends Pokemon {

	Pika() {
		super("피카츄");
		System.out.println("피카츄 생성");
	}

	@Override
	void hello() {
		System.out.println("피카피카");
	}
}

class Fire extends Pokemon {

	Fire() {
		super("파이리");
		System.out.println("파이리 생성");
	}

	@Override
	void hello() {
		System.out.println("파이파이");
	}
}

class Meta extends Pokemon {

	Meta() {
		super("메타몽");
		System.out.println("메타몽 생성");
	}

	@Override
	void hello() {
		System.out.println("메타메타");
	}
}

public class Test01 {

	public static void main(String[] args) {

		Player p1 = new Player();
		
		// 일단 지금 생성하고 
		// 저장 어케함???
		
		//p1.setData(null);
		p1.addPokemon(1);
		p1.addPokemon(2);
		
//		p1.getData()[0].getName();
//		p1.getData()[1].getName();
//		p1.getData()[2].getName();
		
		System.out.println(p1.getData()[0].getName());
		System.out.println(p1.getData()[1].getName());
		System.out.println(p1.getData()[2].getName());
		
		
		// 플레이어 멤버 변수 중에 포켓몬 덩어리다 있는데 
		// 그중에서 0번쨰 포켓몬의 이름을 출력하고 싶다
		//p1.getData()[0].getName();
		
		// 그 두 애를 랜덤으로 뽑아서 비교
		//그 Player 객체가 가지고 있는 data(Pokemon 배열) data에 저장된 그 name을 아는법?
		//
		
		
		// name을 알면 그거 둘이 비교 한다음(equals)
		//if
		// 같으면 게임 하지마 > ㄴㄴ
		// 다르면 게임 해 > A.game(B) 형식
		// 여기부터는 아까 한대로 함
		//System.out.println((p1.getData()).getName());
		///????
		
		
		
		if((p1.getData()[0]).equals(p1.getData()[1])) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	

	}

}
