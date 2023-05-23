package model;
// VO(value object)
public class StudentVO {
	private int num;
	private String name;
	private int score;
	
	StudentVO(int num, String name, int score) {
		this.num = num;
		this.name = name;
		this.score = score;
		System.out.println(this.name +"생성 완료");
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
		// TODO Auto-generated method stub
		return this.name + this.score;
	}
	

}
































