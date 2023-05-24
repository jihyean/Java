package ctrl;

import java.util.ArrayList;

import model.DrinkDAO;
import model.DrinkVO;
import view.DrinkView;

public class DrinkCtrl {
	private DrinkView view;
	private DrinkDAO dao;
	public DrinkCtrl() {
		view=new DrinkView();
		dao=new DrinkDAO();
	}

	public void startApp() {
		while(true) {

			System.out.println(" 로그: 사용자가 새로 입장합니다.");
			// 로그
			//  : 확인을 위한 것
			//  : 실제 서비스에서는 출력 xxx
			ArrayList<DrinkVO> cart=new ArrayList<DrinkVO>();

			while(true) {
				int action=view.printMenu();

				if(action==1) {
					String name=view.getDrinkName();
					int price=view.getDrinkPrice();
					int cnt=view.getDrinkCnt();
					DrinkVO vo=new DrinkVO(0,name,price,cnt);
					System.out.println("CTRL: vo: "+vo);
					// DAO의 CRUD에게 전달해야하는 값만 설정
					// 전달하지않아도되는 값들은 0,null 등으로 설정
					if(dao.insert(vo)) {
						view.printTrue();
					}
					else { 
						view.printFalse();
					}
				}
				else if(action==2) {
					ArrayList<DrinkVO> datas=dao.selectAll(new DrinkVO(0,null,0,0));
					view.printDrinkList(datas);
				}
				else if(action==3) {
					int num=view.getDrinkNum();
					int cnt=1;
					DrinkVO vo=new DrinkVO(num,null,0,-cnt);
					if(dao.update(vo)) {
						// 구매에 성공했을때에만 장바구니에 해당 상품을 추가

						DrinkVO data=dao.selectOne(vo);
						data.setCnt(cnt); // PK,name,price는 자판기에 저장된 상품 정보로 가능하지만,
						// cnt는 사용자가 입력했던 정보로 변경해야함!
						
						boolean flag=false;
						int index=0;
						for(int i=0;i<cart.size();i++) {
							if(data.equals(cart.get(i))) {
								index=i;
								flag=true;
							}
						}
						if(flag) {
							cart.get(index).setCnt(cart.get(index).getCnt()+cnt);
						}
						else {
							cart.add(data); // 장바구니.add(내가 구매한 상품);
						}

						view.printDrinkList(cart);

						view.printTrue();
					}
					else {
						view.printFalse();
					}
				}
				else if(action==4) {
					int num=view.getDrinkNum();
					DrinkVO vo=new DrinkVO(num,null,0,0);
					if(dao.delete(vo)) {
						view.printTrue();
					}
					else {
						view.printFalse();
					}
				}
				else if(action==5) {
					int num=view.getDrinkNum();
					int cnt=view.getDrinkCnt();
					DrinkVO vo=new DrinkVO(num,null,0,cnt);
					if(dao.update(vo)) {
						view.printTrue();
					}
					else {
						view.printFalse();
					}
				}
				else if(action==6) {
					String name=view.getDrinkName();
					ArrayList<DrinkVO> datas=dao.selectAll(new DrinkVO(0,name,0,0));
					view.printDrinkList(datas);
				}
				else if(action==7) {
					view.printEnd();
					break;
				}
			}

			System.out.println(" 로그: 사용자가 종료했습니다.");
			cart.clear();

		}
	}
}
