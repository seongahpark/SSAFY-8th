package io.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		File file = new File("./src/io/xml/emp-list.xml");
		EmpListSaxHandler handler = new EmpListSaxHandler();
		
		// SAXParser는 xml 파일과 그 파일을 처리할 수 있는 Handler를 입력받아 처리
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.parse(file, handler); // xml 문서를 읽으면서 시작 태그, 종료 태그, 텍스트 노드를 만나면
		// 전달된 핸들러의 해당 메소드를 호출해준다
		
		List<Emp> empList = handler.getEmpList();
		
		for(Emp emp : empList) {
			System.out.println(emp);
		}
	}

}
