package view;

import java.util.ArrayList;

import model.MovieVO;

public class View {
	public void printList(ArrayList<MovieVO> datas) {
		System.out.println();
		System.out.println("=== 영화목록출력 ===");
		for(MovieVO data:datas) {
			System.out.println(data);
		}
		System.out.println();
	}
}
