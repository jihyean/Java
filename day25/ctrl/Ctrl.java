package ctrl;

import java.util.ArrayList;

import model.Crawling;
import model.ProductDAO;
import model.ProductVO;
import view.View;

public class Ctrl {
	View view;
	ProductDAO pDAO;

	public Ctrl() { // 생성자
		this.view = new View();
		this.pDAO = new ProductDAO();

	}

	public void startApp() {
		ArrayList<ProductVO> pList; // 상품 목록 저장할 변수
		ProductVO pVO = null; // 상품 정보 저장할 변수
		
		// 시용자에게 크롤링한다고 출력
		// 크롤링
		// 성공/실패 여부
		view.printCrawlingInfo();
//크롤링 ==============================================================
		ArrayList<ProductVO> mdatas = Crawling.sample();
		
		for (int i = 0; i < mdatas.size(); i++) {
			ProductVO mdata = mdatas.get(i);
			boolean flag = pDAO.insert(mdata);
			if (!flag) {
				view.printFalse();
				return;
			}
		}
 //크롤링 ==============================================================
		
		while (true) {
			view.printMenu();
			int action = view.getMenuNum();

			// 상품 전체 목록 출력
			if (action == 1) {
				
				pVO = new ProductVO(0, "", 0, 0);
				pList = pDAO.selectAll(pVO); // 상품 목록 받아옴
				view.printList(pList); // 상품 목록 출력 요청
			}
			// 상품 검색
			else if (action == 2) {
				int productNum = view.getNum();
				pVO = new ProductVO(productNum, null, 0, 0);

				pVO = pDAO.selectOne(pVO);

				if (pVO.getNum() == -1) {
					view.printNoProduct();
				} else {
					view.printProduct(pVO);
				}
			}
			// 상품 이름 검색
			else if (action == 3) {
				String name = view.getName();
				pVO = new ProductVO(0, name, 0, 0);
				pList = pDAO.selectAll(pVO); // 상품 목록 받아옴
				view.printList(pList); // 상품 목록 출력 요청
			}
			// 변경
			else if (action == 4) {
				int productNum = view.getNum();
				String name = view.getName();
				
				pVO = new ProductVO(productNum, name, 0, 0);

				if(pDAO.update(pVO)) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			// 삭제
			else if (action == 5) {
				int productNum = view.getNum();
				pVO = new ProductVO(productNum, null, 0, 0);

				if(pDAO.delete(pVO)) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}

			}
			// 프로그램 종료
			else if (action == 6) {
				break;
			}
		}
	}

}
