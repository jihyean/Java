package model;

public class ProductVO {
	private int num;
	private String name;
	private int price;
	private int discount;
	
	public ProductVO(int num, String name, int price, int discount) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.discount = discount;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return this.num + "." + this.name + "\n" +this.price +"원 할인율: "+this.discount +"%\n";
	}
	
	

}
