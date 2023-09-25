package Hisse;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HisseFinder {
	
	private final static String URL = "https://bigpara.hurriyet.com.tr/borsa/canli-borsa/tum-hisseler/";
	
	public static Hisse findHisse(String name) {
		try {
			final Document document = Jsoup.connect(URL).get();
			for (Element element : document.select("#sortable > ul.live-stock-item")) {
				String hisseName = element.select("li:nth-child(1) > a:nth-child(2)").text();
				
				if (hisseName.equals(name)) {
					double price = Double.parseDouble(element.select("#h_td_fiyat_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.')); 
					double yesterdayPrice = Double.parseDouble(element.select("#h_td_dunkapanis_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.'));
					double change = Double.parseDouble(element.select("#h_td_yuzde_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.'));
					double tavan = Double.parseDouble(element.select("#h_td_tavan_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.'));
					double taban = Double.parseDouble(element.select("#h_td_taban_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.'));
					return new Hisse(name, price, yesterdayPrice, change, tavan, taban);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}
	
	public static void updateHisse(Hisse hisse) {
		String name = hisse.getNAME();
		try {
			final Document document = Jsoup.connect(URL).get();
			for (Element element : document.select("#sortable > ul.live-stock-item")) {
				String hisseName = element.select("li:nth-child(1) > a:nth-child(2)").text();
				
				if (hisseName.equals(name)) {
					hisse.setPrice(Double.parseDouble(element.select("#h_td_fiyat_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.')));
					hisse.setYesterdaysPrice(Double.parseDouble(element.select("#h_td_dunkapanis_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.')));
					hisse.setChange(Double.parseDouble(element.select("#h_td_yuzde_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.')));
					hisse.setTavan(Double.parseDouble(element.select("#h_td_tavan_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.')));
					hisse.setTaban(Double.parseDouble(element.select("#h_td_taban_id_" + name).text().replaceAll(Pattern.quote("."), "").replace(',', '.')));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	public static String[] getHisseList() {
		ArrayList<String> hisseArrayList = new ArrayList<>();
		try {
			final Document document = Jsoup.connect(URL).get();
			for (Element element : document.select("#sortable > ul.live-stock-item")) {
				String hisseName = element.select("li:nth-child(1) > a:nth-child(2)").text();
				hisseArrayList.add(hisseName);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return hisseArrayList.toArray(new String[hisseArrayList.size()]);
	}
}
