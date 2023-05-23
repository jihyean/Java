package model;

import java.util.ArrayList;

public class DrinkDAO {
	public ArrayList<DrinkVO> datas;
	private static int PK = 1001;

	public DrinkDAO() {
		this.datas = new ArrayList<DrinkVO>();
		this.datas.add(new DrinkVO(PK++, "콜라", 2000, 20));
		this.datas.add(new DrinkVO(PK++, "사이다", 1800, 12));
		this.datas.add(new DrinkVO(PK++, "물", 1200, 44));
	}

	// C
	public boolean insert(String name, int price, int cnt) {
		this.datas.add(new DrinkVO(PK++, name, price, cnt));
		return true;
	}

	// R
	public ArrayList<DrinkVO> selectAll() {
		return this.datas;
	}

	// U
	public boolean update(int num, int cnt) {
		for (int i = 0; i < this.datas.size(); i++) {
			if (this.datas.get(i).getNum() == num) {
				int cnt2 = this.datas.get(i).getCnt()-cnt;
				this.datas.get(i).setCnt(cnt2);
				System.out.println("가격은 "+this.datas.get(i).getPrice()*cnt);
				return true;
			}
		}
		System.out.println("로그: model: StudentDAO: sell(): 없는 상품입니다");
		return false;
	}

	// D
	public boolean delete(int num) {
		for (int i = 0; i < this.datas.size(); i++) {
			if (this.datas.get(i).getNum() == num) {
				this.datas.remove(i);
				return true;
			}
		}
		System.out.println("로그: model: DrinkDAO: delete(): 삭제할 음료가 없습니다");
		return false;
	}

}
