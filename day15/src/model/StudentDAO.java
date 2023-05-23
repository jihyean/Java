package model;

import java.util.ArrayList;
// DAO (data access object)
// CRUD 비즈니스 메서드
public class StudentDAO {
	public ArrayList<StudentVO> datas;
	private static int PK = 1001;
	public StudentDAO() {
		this.datas = new ArrayList<StudentVO>();
		this.datas.add(new StudentVO(PK++, "홍길동", 85));
		this.datas.add(new StudentVO(PK++, "아무무", 92));
		this.datas.add(new StudentVO(PK++, "티모", 51));
	}
	
	
	// C
	public boolean insert(String name, int score) {
		this.datas.add(new StudentVO(PK++, name, score)); 
		return true;
	}
	
	// R : 목록 출력
	public ArrayList<StudentVO> selectAll() {
		return this.datas;
		
	}
	
	// R : 
	public StudentVO selectOne(int num) { //PK를 받아서
		for(StudentVO v: this.datas) {
			if(v.getNum()==num) {
				return v;
			}
		}
		System.out.println("로그: model: StudentDAO: selectOne(): 반환할 학생이 없습니다");
		return null; // 해당 PK 가진 학생이 없음
	}
	
	public boolean update(int num, int score) {
		for(int i=0; i<this.datas.size(); i++) {
			if(this.datas.get(i).getNum()==num) {
				this.datas.get(i).setScore(score);
				return true;
			}
		}
		System.out.println("로그: model: StudentDAO: selectOne(): 반환할 학생이 없습니다");
		return false;
	}
	
	
	// D
	public boolean delete(int num) {
		for(int i=0; i<this.datas.size(); i++) {
			if(this.datas.get(i).getNum()==num) {
				this.datas.remove(i);
				return true;
			}
		}
		System.out.println("로그: model: StudentDAO: selectOne(): 제거할 학생이 없습니다");
		return false;
	}


}





































