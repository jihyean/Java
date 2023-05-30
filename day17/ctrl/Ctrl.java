package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.AdminView;
import view.ClientView;

public class Ctrl {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private AdminView admin;
	private ClientView client;

	public Ctrl() {
		mDAO = new MemberDAO();
		pDAO = new ProductDAO();
		admin = new AdminView();
		client = new ClientView();
	}

	public void startApp() {
		while (true) {
			int action = client.printClientMenu01(); // 1.2.3.
			if (action == 1234) {
				while (true) {
					action = admin.printAdminMenu();
					if (action == 1) { // 회원목록출력 1.2.

						ArrayList<MemberVO> datas = mDAO.selectAll(null); // 3.4.5.
						// 7. 6.
						admin.printMemberList(datas);
						// 8.

						// 1. 사용자가 관리자인상황.
						// 2. 관리자가 회원목록볼래~
						// 3. V가 C한테 말합니다. 회원목록보겠다는데?
						// 4. C가 아, 회원목록데이터가 필요하구나? ㅇㅋ
						// 5. M한테 회원목록 좀 줘~
						// 6. M이 selectAll()합니다.
						// 7. AL<MVO>가 반환되고 C는 그걸-
						// 8. -V한테 줍니다.

						// admin.printMemberList(mDAO.selectAll(null));

					} else if (action == 2) {
						admin.printAdminEnd();
						break;
					}
				}
			} else if (action == 1) {

				MemberVO mVO = client.signUp();

				boolean flag = mDAO.insert(mVO);

				if (flag) {
					client.signUpTrue();
				} else {
					client.signUpFalse();
				}

				// 1. 사용자가 console에 회원가입할래~ 1번입력
				// 2. V는 입력한 값을 C한테 전달
				// 3. C는 아~ 회원가입하고싶구나? ㅇㅋ
				// 4. C는 V한테 회원가입할 정보를 입력받아오라고 지시
				// 5. V는 사용자한테 회원가입창 보여줌
				// 6. 사용자는 정보를 입력
				// 7. V는 사용자가 입력한 정보를 C한테 전달
				// 8. C는 이 정보를 M한테 전달
				// 9. M은 회원가입을 수행
				// 10. M은 insert()가 잘되었는지아닌지를 T,F를 반환
				// 11. C는 결과에따라 맞는 V화면을 보여줄수있도록 지시
				// 12. 사용자는 V가 보여주는 화면을 보게됨

//				if (mDAO.insert(client.signUp())) {
//					client.signUpTrue();
//				} else {
//					client.signUpFalse();
//				}

			} else if (action == 2) {
				if (true) { //mDAO.selectOne(client.signIn()) != null
					client.signInTrue();
					while (true) {

						action = client.printClientMenu02();

						if (action == 1) {

							client.logout();
							client.printClientEnd02();

							break;

						} else if (action == 2) {

						} else if (action == 3) {

							client.printClientEnd02();

							break;

						} else if (action == 4) { // 상품 목록 출력

							ArrayList<ProductVO> pdatas = pDAO.selectAll(null);
							client.printProductList(pdatas);

						} else if (action == 5) { // 이름으로 검색

							String name = client.getSearchContent();
							ProductVO pVO = new ProductVO(0, name, 0, 0);
							ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
							client.printProductList(pdatas);

						} else if (action == 6) {

							int action2 = client.printClientMenu03();
							if (action2 == 1) {
								
								ProductVO pVO = new ProductVO(0, "최고가", 0, 0);
								ProductVO data = pDAO.selectOne(pVO);
								client.printProduct(data);
								
//								//int price = client.getSearchPrice();
//								ProductVO pVO=new ProductVO(0,"비싼상품",0,0);
//								ProductVO data = pDAO.selectOne(pVO);
//								//data.setName("비싼상품");
//								//ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
//								//client.printProductList(pdatas);

							} else if (action2 == 2) {
								
								ProductVO pVO=new ProductVO(0,"최저가",0,0);
								ProductVO data = pDAO.selectOne(pVO);
								
								//int price = client.getSearchPrice();
//								ProductVO pVO = new ProductVO(0, "싼상품", 0, 0);
//								ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
//								client.printProductList(pdatas);

							} else if (action2 == 3) {
								
								int price = client.getSearchPrice();
								ProductVO pVO = new ProductVO(0, "비싼상품", price, 0);
								ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
								client.printProductList(pdatas);

							} else if (action2 == 4) {
								
								int price = client.getSearchPrice();
								ProductVO pVO = new ProductVO(0, "싼상품", price, 0);
								ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
								client.printProductList(pdatas);

							} else if (action2 == 5) {
//								int price = client.getSearchPrice();
//								int price2 = client.getSearchPrice();
//								ProductVO pVO = new ProductVO(0, "필터", price, price2);
								ProductVO pVO = client.getSearchFilter();
								ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
								client.printProductList(pdatas);
							}

						}
					}
				} else {
					client.signInFalse();
				}
			} else if (action == 3) {
				client.printClientEnd01();
				break;
			}
		}
	}
}
