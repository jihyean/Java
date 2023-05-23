package controller;

import java.util.ArrayList;

import model.DrinkDAO;
import model.DrinkVO;
import view.DrinkView;

public class DrinkCtrl {
	private DrinkView view;
	private DrinkDAO dao; // model

	public DrinkCtrl() {
		this.view = new DrinkView();
		this.dao = new DrinkDAO();
	}

	public void menu() {
		ArrayList<DrinkVO> datas = dao.selectAll(); // 학생 목록 데이터를 모델이 가져옴
		view.printDrinkList(datas); // 가져온 데이터를 뷰에게 넘겨줌
	}

	public void startApp() {
		while (true) {
			// 사용자한테 메뉴 보여줘
			view.printMenu();
			// 사용자가 뭐 할지 입력 받아
			int menuNum = view.getMenuNum();

			// 추가
			if (menuNum == 1) {
				menu();

				view.printInfo_C_Start();
				String name = view.getDrinkName();
				int price = view.getDrinkPrice();
				int cnt = view.getDrinkCnt();
				if(dao.insert(name, price, cnt)) {
					view.printInfo_C_End();
				}
			}
			else if (menuNum == 2) { // 음료 목록 출력
				menu();
			}
			else if (menuNum == 3) { // 구매
				menu();

				view.printInfo_S_Start();
				int num = view.getDrinkNum();
				int cnt = view.getDrinkCnt();
				if(dao.update(num, cnt)) {
					view.printInfo_S_End();
				}
			} else if (menuNum == 4) { // 음료 삭제
				menu();

				view.printInfo_D_Start();
				int num = view.getDrinkNum();
				if(dao.delete(num)) {
					view.printInfo_D_End();
				}
			}
		}

	}
}
