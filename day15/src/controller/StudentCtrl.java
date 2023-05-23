package controller;

import java.util.ArrayList;

import model.StudentDAO;
import model.StudentVO;
import view.StudentView;


// CRUD(비즈니스 로직, 메서드)는 일반적으로 output이 불린임

public class StudentCtrl {
	private StudentView view;
	private StudentDAO dao; //model
	
	public StudentCtrl() {
		this.view = new StudentView();
		this.dao = new StudentDAO();
	}
	
	public void startApp() {
		while(true) {
			//사용자한테 메뉴 보여줘
			view.printMenu();
			// 사용자가 뭐 할지 입력 받아
			int menuNum = view.getMenuNum();
			
			if(menuNum==1) {
				ArrayList<StudentVO> datas = dao.selectAll(); // 학생 목록 데이터를 모델이 가져옴
				view.printStudentList(datas); // 가져온 데이터를 뷰에게 넘겨줌
			}
			else if(menuNum==2) {
				int num = view.getStudentNum(); 
				StudentVO data = dao.selectOne(num);
				view.printStudent(data);
			}
			else if(menuNum==3) {
				int num =view.getStudentNum(); 
				int score = view.getStudentScore();
				dao.update(num, score);
				view.printInfo();
			}
			else if(menuNum==4) {
				view.printInfo_C_Start();
				String name = view.getStudentName();
				int score = view.getStudentScore();
				dao.insert(name, score);
				view.printInfo_C_End();
				// CRUD(비즈니스 로직, 메서드)가 성공했는지 알아야함
			}
			else if(menuNum==5) {
				view.printInfo_D_Start(); 
				int num = view.getStudentNum();
				dao.delete(num);
				view.printInfo();
			}
			else if(menuNum==6) {
				view.printEnd();
				break;
			}
		}
	}
	
	

}




































