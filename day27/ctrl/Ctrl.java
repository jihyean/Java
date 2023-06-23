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
				view.printList(pDAO.selectAll(new ProductVO()));
			}
			else if(action==2) {
				view.printList(pDAO.selectAll(view.funcC()));
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
				member.setAction("토탈변경");
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
				if(member==null){
					view.printFalse();
					continue;
				}
				
				String mpw=view.funcA(member);
				if(!member.getMpw().equals(mpw)) {
					view.printFalse();
					continue;
				}
				// C가 "현재 로그인한 회원의 정보"를 알고있기때문!
				
				String newMpw=view.funcB(member.getMpw());
				member.setTmpMpw(newMpw);
				member.setAction("비번변경");
				if(!mDAO.update(member)) {
					view.printFalse();
					continue;
				}
				member=null;
				view.printTrue();
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
