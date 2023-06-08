package model;

import java.util.ArrayList;

public class ProductDAO {
	private ArrayList<ProductVO> datas;
	
	public ProductDAO() {
		//this.datas=Crawling.sample();
	}
	
	public boolean insert(ProductVO pVO) {
		return false;
	}
	
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		return datas;
	}
	public ProductVO selectOne(ProductVO pVO) {
		return null;
	}
	
	public boolean update(ProductVO pVO) {
		return false;
	}
	public boolean delete(ProductVO pVO) {
		return false;
	}
}