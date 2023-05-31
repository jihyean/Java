package model;

public class MovieVO {
	private int num;
	private String name;
	private String odate;
	private int cnt;
	public MovieVO(int num,String name,String odate) {
		this.num=num;
		this.name=name;
		this.odate=odate;
		this.cnt=0;
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
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return this.name+"의 조회수: "+this.cnt;
	}
}
