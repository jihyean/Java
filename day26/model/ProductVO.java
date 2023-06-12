package model;

public class ProductVO {
	private int num;
	private String name;
	private int cnt;
	private int price;
	private int tmpPrice;
	private String searchCondition;


	public ProductVO(int num,String name,int cnt,int price) {
		this.num=num;
		this.name=name;
		this.cnt=cnt;
		this.price=price;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getTmpPrice() {
		return tmpPrice;
	}
	public void setTmpPrice(int tmpPrice) {
		this.tmpPrice = tmpPrice;
	}
	
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	@Override
	public String toString() {
		return num+"번 상품 "+name+" 재고 ["+cnt+"] 가격 ["+price+"]";
	}
}
