package com.ssafy.rent;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Open API를 통해 데이타 추출
 *
 */
public class ApiExplorer {
	public static void main(String[] args) throws IOException {
//       // StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade"); /*아파트 매매 URL*/
//       // StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHTrade"); /*연립 다세대 매매 URL*/
//        StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent"); /*아파트 전월세  URL*/
////    	StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHRent"); /*연립 다세대 전월세URL*/
//        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=VhV%2BKsNjBo0fEzXZKe%2Bvg%2B5ma5V6yRBggE7g%2BeUGz0SrYsZ%2FvVr7Kv70RHPzPJGqga%2Fk0DerMNhOzmPbSdd57g%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*동코드 검색*/
//        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("201912", "UTF-8")); /*거래 년월 검색*/

		String sp = File.separator;
		Path file = Paths.get("./res/ParkingHistory.xml");
		String content = "안녕하세요!!!";
		try {
			if (!Files.exists(file)) {
				Files.createFile(file);
				System.out.println("파일이 생성되었습니다.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String key = "6f5379776c746a64313130615977574c";
//		String serviceUrl = "https://api.odcloud.kr/api/15100293/v1";
		String serviceUrl = "http://openAPI.jongno.go.kr:8088/";
		String uuid = "uddi:077b5ab7-33f2-462d-9844-e2e24940acae";
		String serviceKey = "=SvFmnQ6BYKPyfE0Rq%2FSQjQoxAyKdQdkSMquzg%2BIOU0MpkzcOl%2FK3Qys3%2BS%2Fu%2F%2B3QQnXCeSj1PoyhQR3OeIdOXQ%3D%3D";

//		StringBuilder urlBuilder = new StringBuilder(serviceUrl);
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
		urlBuilder.append("/" +  URLEncoder.encode("6f5379776c746a64313130615977574c","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("xml","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("JongnoListEnvGuideCheck","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode("1000","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/

		
		
		
		
		
		
//		urlBuilder.append("/" + uuid);
		
		
//		 urlBuilder.append("?" + URLEncoder.encode("page", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8") );
//	        urlBuilder.append("&" + URLEncoder.encode("perPage", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8") );
//	        urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + "XML");
//	        urlBuilder.append("&" + URLEncoder.encode("serviceKey", "UTF-8") + serviceKey);

//		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + serviceKey); /* Service Key */
//		urlBuilder.append("&" + URLEncoder.encode("page", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));	
//		urlBuilder.append("&" + URLEncoder.encode("perPage", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));	
//		urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8"));	
////		
//		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
//		urlBuilder.append(
//				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 동코드 검색 */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/jdson");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
//		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
//			sb.append(line);
			Files.write(file, line.getBytes(), StandardOpenOption.APPEND);
			Files.write(file, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
		}
		rd.close();
		conn.disconnect();
//		System.out.println(sb.toString());
	}
}