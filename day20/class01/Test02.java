package class01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 웹 크롤링
public class Test02 {
	public static void main(String[] args) {
		// 웹 페이지 url 링크
		final String url = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
		
		// 1. 웹페이지 코드를자바로 가져오기
		// a) 해당 url의 페이지 코드를 받아오기 위해, 연결통로(스트림)를 open
		// connect() 해야함
		// b) connect()가 정상적으로 수행되었다면 get()을 통하여
		// 해당 페이지의 코드를 받아옴
		Connection conn = Jsoup.connect(url);
		Document doc = null;
		try {
			doc = conn.get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. 페이지 스크랩핑 완료
		// System.out.println(doc);
		// 스캐너나 랜덤 어레이리스트 등은 자바에서 제공하는 클래스지만
		// 자바에서 기본 제공하지 않는 클래스

		// 3. 페이지를 분석
		// a) DOM 문서 분석
		// <></>태그(요소,element)단위로 분석
		// 속성을 가질 수있으며
		// 분석할때에 가장 대표적으로 활용되는 속성이
		// id(유일한 요소), class(여러개의 공통점을 가진 요소들)

		// Elements elems = doc.select("span.ContentTitle__title--e3qXt > span.txt");
		Elements elems = doc.select("strong.title");
		Elements elems2 = doc.select("strong.percent> span");
		
		// 영화 제목, 예매율 배열리스트에 저장
		ArrayList<String> title =new ArrayList<String>();
		ArrayList<String> rate =new ArrayList<String>();
		
//		System.out.println(elems);
//		System.out.println(elems2);
		// 태그명#id명
		// 태그명.clss명
		// 상위 태그명>하위태그명
		// --->파싱

		// 4. 분석하여 추출 완료한 데이터를 콘솔화면에 출력
		// Iterator 이터레이터
		// : 거대한 컬렉션(elems)에 있는 데이터를 작은 단위의 컬렉션(elem)으로 나눠저장할수있도록 해주는 컬렉션
		Iterator<Element> itr = elems.iterator();
		Iterator<Element> itr2 = elems2.iterator();
		
//		ArrayList<itr>title = ArrayList<E>
		// itr는 hasNext(),next()
		// 다음 요소가 있어?,그럼 다음거보여줘~
		while (itr.hasNext()) {
			String str = itr.next().toString();
			// 5. 데이터를 가공
			int index = str.indexOf(">");
			str=str.substring(index+1);
			index = str.indexOf("<");
			str=str.substring(0,index);

			title.add(str); //제목 배열리스트에 저장
		}
		
		while (itr2.hasNext()) {
			String str2 = itr2.next().toString();
			// 5. 데이터를 가공
			int index = str2.indexOf(">");
			str2=str2.substring(index+1);
			index = str2.indexOf("<");
			str2=str2.substring(0,index);
			
			rate.add(str2); // 예매율 배열리스트에 저장
		}
		
		// 처음부터 끝까지 목록 출력
		for(int i = 0; i<title.size(); i++) {	
			System.out.println();
			System.out.print(title.get(i)+"\n");
			System.out.println("예매율: " +rate.get(i));
			System.out.println();
		}
		

	}

}

























