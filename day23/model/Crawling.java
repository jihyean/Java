package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {

	public static ArrayList<ProductVO> sample() {
    
		final String url = "https://www.oliveyoung.co.kr/store/main/getBestList.do";

		Connection conn = Jsoup.connect(url);
		Document doc = null;
        
		try {
			doc = conn.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements elems = doc.select("p.tx_name");
		Elements elems2 = doc.select("p.prd_price > span.tx_cur > span.tx_num");
		Elements elems3 = doc.select("p.prd_price");

		Iterator<Element> itr = elems.iterator();
		Iterator<Element> itr2 = elems2.iterator();
		Iterator<Element> itr3 = elems3.iterator();

		//////////////////////////////
		ArrayList<ProductVO> mdatas = new ArrayList<ProductVO>();
		int PK = 1001;
		//////////////////////////////

		while (itr.hasNext()) {
			String str = itr.next().text();
			String str2 = itr2.next().text();
			String str3 = itr3.next().text();

			str2 = str2.replaceAll("[^0-9]", "");
			str3 = str3.replaceAll("[^0-9]", "");

			if(str3.equals(str2)) {
				str3 = "-1";
			}
			else {
				str3 = str3.replace(str2, "");		
			}

			int price1 = Integer.parseInt(str2);
			int price2 = Integer.parseInt(str3);

			if(price2<0) {
				price2 = 0;
			}
			else {
				// 할인률: 100-((원가격/할인가)*100)
				double tmp = 100-((price1*1.0/price2*1.0)*100.0);
				price2 = (int) tmp;
			}

			//System.out.println(price2);
			
			mdatas.add(new ProductVO(PK++, str, price1, price2));
		}

		return mdatas;
	}

}