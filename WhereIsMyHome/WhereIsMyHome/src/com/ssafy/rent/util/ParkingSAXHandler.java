package com.ssafy.rent.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomeInfo;

/**
 *  AptDealHistory.xml 파일에서 아파트 거래 정보를 읽어 파싱하는 핸들러 클래스 
 */
public class ParkingSAXHandler extends DefaultHandler {
	/**
	 * 아파트 거래 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 
	 * 현재 버전에서는 0번부터 순차 부여한다. 
	 */
	private int no;
	/**아파트 거래 정보를 담는다 */
	private Map<String,Integer> homes;
	/**파상힌 아파트 거래 정보*/
	private HomeInfo home;
	/**태그 바디 정보를 임시로 저장*/
	private String temp;
	
	public ParkingSAXHandler(){
		homes = new HashMap<String,Integer>();
	}
	public void startElement(String uri, String localName
			                           , String qName, Attributes att ){
		
		
		if(qName.equals("row")){
			home = new HomeInfo(no++);
		}
	}
//	public void endElement(String uri, String localName, String qName){
//
//		
//		if(qName.equals("SF_TEAM_NM")) {
//			System.out.println("TT");
//			System.out.println(temp.trim());
//			home.setDong(temp.trim());
//		}
		
//		if(qName.equals("지역코드")) { 
//			home.setCode(Integer.parseInt(temp));
//		}else if(qName.equals("아파트")) { 
//			home.setAptName(temp.trim());
//		}else if(qName.equals("법정동")) { 
//			home.setDong(temp.trim());
//		}else if(qName.equals("img")) { 
//			home.setImg(temp);
//		}else if(qName.equals("건축년도")) { 
//			home.setBuildYear(Integer.parseInt(temp));
//		}else if(qName.equals("지번")) { 
//			home.setJibun(temp);
//		}
//	else if(qName.equals("row")) {
//			homes.put(home.getDong(), home);
//		}
		
//	}
	@Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException {
		
        if(qName.equals("WRKP_ADDR")) {
        	String res = null;
            String str = temp;
            System.out.println(str);
            int idx = str.indexOf("동");
            int idx_g = str.indexOf("구");
            System.out.println(str+"222");
            if(idx < 0 || idx_g < 0) {}
            else {
            res = str.substring(idx_g+2, idx+1);
            }
            if(res != null) {

            	if(homes.get(res) != null) {
            		homes.put(res, homes.get(res)+1 );
            	}else {
            		homes.put(res, 1 );
            	}
            
            
        }
        	
        		
	}
        
    }
	
	public void characters(char[]ch, int start, int length){
		temp = new String(ch, start, length);
	}
	public Map<String,HomeInfo> getParkingInfo(Map<String, HomeInfo> homeInfo) {
		for(Entry<String, Integer> clean : homes.entrySet()) {
		for (Entry<String, HomeInfo> info : homeInfo.entrySet()) {
			
			if(clean.getKey().equals(info.getValue().getDong())) {
				
				HomeInfo in = info.getValue();
				in.setCleanCnt(in.getCleanCnt() + clean.getValue());
				homeInfo.put(info.getKey(), in);
			}
		}}
		
	
		return homeInfo;
	}
}





