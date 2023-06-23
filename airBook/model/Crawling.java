package model;

import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	public static ArrayList<AirInfoVO> sample() {
		// 크롤링 할 주소 문자열로 상수화
		final String url = "https://luciusfox.tistory.com/112";
		// 상수화 시킨 문자열 주소화
		Connection conn = Jsoup.connect(url);
		Document doc = null;
		// 주소화된 페이지 연결
		try {
			doc = conn.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 페이지에서 항공정보에 해당하는 각 요소들의 코드를 변수에 초기화
		Elements elemsAirline = doc.select("tr > td:nth-child(1)");
		Elements elemsLocation = doc.select("tr > td:nth-child(2)");
		Elements elemsStartTime = doc.select("tr > td:nth-child(3)");
		Elements elemsReturnTime = doc.select("tr > td:nth-child(4)");
		Elements elemsPrice = doc.select("tr > td:nth-child(5)");
		
		// 해당하는 모든 요소들을 Iterator에 저장
		Iterator<Element> itrAirline = elemsAirline.iterator();
		Iterator<Element> itrLocation = elemsLocation.iterator();
		Iterator<Element> itrStartTime = elemsStartTime.iterator();
		Iterator<Element> itrReturnTime = elemsReturnTime.iterator();
		Iterator<Element> itrPrice = elemsPrice.iterator();
		
		// 크롤링한 항공정보들을 저장할 ArrayList생성
		ArrayList<AirInfoVO> aiList = new ArrayList<AirInfoVO>();
		// hasNext를 이용하여 남은 요소가 있을 때 까지 반복문 실행
		while(itrAirline.hasNext() && itrLocation.hasNext() && itrStartTime.hasNext() && itrReturnTime.hasNext() && itrPrice.hasNext()) {
			String airline = itrAirline.next().text();
			String location = itrLocation.next().text();
			String startTime = itrStartTime.next().text();
			String returnTime = itrReturnTime.next().text();
			int price = Integer.parseInt(itrPrice.next().text());
			AirInfoVO aiVO = new AirInfoVO(airline, location, Util.stringToDate(startTime), Util.stringToDate(returnTime), price);
			aiList.add(aiVO);
		}
		return aiList;
	}
}