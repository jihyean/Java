package view;

import java.util.ArrayList;

import model.ProductVO;

public class View {
	public void printList(ArrayList<ProductVO> datas) {
		System.out.println();
		System.out.println("=== 상품목록출력 ===");
		for (ProductVO data : datas) {
			System.out.println(data);
		}
		System.out.println();
	}
}
