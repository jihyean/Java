package ctrl;

import model.ProductDAO;
import view.View;


public class Ctrl {
	View View;
	ProductDAO mDAO;

	public Ctrl() { // 생성자
		View = new View();
		mDAO = new ProductDAO();

	}

	public void startApp() { // (메인 메서드)
		
	}
}
