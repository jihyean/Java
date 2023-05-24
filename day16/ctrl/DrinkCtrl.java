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

			System.out.println(" �α�: ����ڰ� ���� �����մϴ�.");
			// �α�
			//  : Ȯ���� ���� ��
			//  : ���� ���񽺿����� ��� xxx
			ArrayList<DrinkVO> cart=new ArrayList<DrinkVO>();

			while(true) {
				int action=view.printMenu();

				if(action==1) {
					String name=view.getDrinkName();
					int price=view.getDrinkPrice();
					int cnt=view.getDrinkCnt();
					DrinkVO vo=new DrinkVO(0,name,price,cnt);
					System.out.println("CTRL: vo: "+vo);
					// DAO�� CRUD���� �����ؾ��ϴ� ���� ����
					// ���������ʾƵ��Ǵ� ������ 0,null ������ ����
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
						// ���ſ� �������������� ��ٱ��Ͽ� �ش� ��ǰ�� �߰�

						DrinkVO data=dao.selectOne(vo);
						data.setCnt(cnt); // PK,name,price�� ���Ǳ⿡ ����� ��ǰ ������ ����������,
						// cnt�� ����ڰ� �Է��ߴ� ������ �����ؾ���!
						
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
							cart.add(data); // ��ٱ���.add(���� ������ ��ǰ);
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

			System.out.println(" �α�: ����ڰ� �����߽��ϴ�.");
			cart.clear();

		}
	}
}
