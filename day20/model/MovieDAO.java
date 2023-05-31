package model;

import java.util.ArrayList;

public class MovieDAO {
	private ArrayList<MovieVO> datas;
	public MovieDAO() {
		this.datas=Crawling.sample();
	}
	
	public ArrayList<MovieVO> selectAll(MovieVO mVO){
		return datas;
	}
	public MovieVO selectOne(MovieVO mVO) {
		return null;
	}
	
	public boolean insert(MovieVO mVO) {
		return false;
	}
	public boolean update(MovieVO mVO) {
		return false;
	}
	public boolean delete(MovieVO mVO) {
		return false;
	}
}
