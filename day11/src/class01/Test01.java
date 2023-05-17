package class01;

class Student{
	private String name;
	private int score;
	
	Student(String name, int score){
		this.name = name;
		this.score = score;
		System.out.println(this.name+" 학생 생성 완료");
	}
	
	@Override
	public String toString() {
		return this.name+" 학생은 "+this.score+"점입니다";
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
	
	
//	void setName(String name) {
//		this.name = name;
//	}
//	int setScore() {
//		return this.score;
//	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Student s1 = new Student("아리",89);
		//s1.name = "김효경"; // 데이터 탈취 > 로그에 남지 않아서 위험(함수는 로그에 남는다) 에러!
		s1.setScore(97);
		System.out.println(s1);

	}



}
