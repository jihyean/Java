package ctrl;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.View;

public class Ctrl {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private View view;
	private MemberVO member; // 현재 로그인한 회원의 정보를 저장할 변수
	
	final static int SEARCHPRICE = 1;
	final static int NOTSEARCHPRICE = -1;
	
	public Ctrl() {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		view=new View();
		member=null;
	}
	public void startApp() {
		while(true) {
			int action=view.printMenu();
			if(action==1) {
				ProductVO pVO=new ProductVO(0,"",0,0); 	// LIKE 사용을 위해 ""로 보냄
				pVO.setSearchCondition("전체출력");
				
				//pVO.setTmpPrice(NOTSEARCHPRICE);					// tmpPrice가 음수면 가격검색 아님
				view.printList(pDAO.selectAll(pVO));
			}
			else if(action==2) {
				int searchNum = view.searchMenuNum();
				
				if(searchNum == 1) {
					String pName = view.getName();
					ProductVO pVO=new ProductVO(0,pName,0,0); // 검색할 이름 받아서 검색
					
					pVO.setSearchCondition("이름검색");
					
					//pVO.setTmpPrice(NOTSEARCHPRICE); // tmpPrice가 음수면 가격검색 아님
					view.printList(pDAO.selectAll(pVO));
				}
				else if(searchNum == 2) {
					ProductVO pVO = view.getPrice();
					int cnt = pVO.getCnt();
					int price = pVO.getPrice();
					
					ProductVO pVO2=new ProductVO(0,null,cnt,price);
					
					pVO2.setSearchCondition("가격검색");
					//pVO.setTmpPrice(SEARCHPRICE);	// tmpPrice가 양수면 가격검색
					view.printList(pDAO.selectAll(pVO2));
				}
				
				 // 실습(이름,가격으로 검색하기)
			}
			else if(action==3) {
				int proNum=view.getNum();
				ProductVO pVO=new ProductVO(proNum,null,0,0);
				ProductVO pdata=pDAO.selectOne(pVO);
				if(pdata==null) {
					System.out.println(" 로그: 해당상품없음");
					view.printFalse();
					continue;
				}
				if(pdata.getCnt()<=0) {
					System.out.println(" 로그: 상품재고없음");
					view.printFalse();
					continue;
				}
				
				if(!pDAO.update(pdata)) {
					System.out.println(" 로그: P update()안됨");
					view.printFalse();
					continue;
				}
				member.setTmpPrice(pdata.getPrice());
				// 개발 편의성때문에 새로 만든 VO의 멤버변수를 활용한 로직
				if(!mDAO.update(member)) {
					System.out.println(" 로그: M update()안됨");
					view.printFalse();
					continue;
				}
				view.printTrue();
			}
			else if(action==4) {
				if(!mDAO.insert(view.signin())) {
					view.printFalse();
					continue;
				}
				view.printTrue();
			}
			else if(action==5) {
				member=mDAO.selectOne(view.signin());
				if(member==null) {
					view.printFalse();
					continue;
				}
				view.printTrue();
			}
			else if(action==6) {
				member=null;
			}
			else if(action==7) {
				member.setMpw(view.getPass());
				member.setTmpPrice(-1);
				mDAO.update(member);
			}
			else if(action==8) {
				if(member==null) {
					view.printFalse();
					continue;
				}
				
				if(!mDAO.delete(member)) {
					view.printFalse();
					continue;
				}
				member=null;
				view.printTrue();
			}
			else {
				break;
			}
		}
	}
}
