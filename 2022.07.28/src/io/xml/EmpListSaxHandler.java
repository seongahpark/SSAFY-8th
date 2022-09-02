package io.xml;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler; // import 헷갈리지 않기

public class EmpListSaxHandler extends DefaultHandler{
	private List<Emp> empList = new ArrayList<>();
	private Emp emp;
	private String data;
	
	@Override
    public void startElement (String uri, String localName,
            String qName, Attributes attributes)throws SAXException {
		if(qName.equals("emp")) {
			// emp라는 태그를 만나면
			emp = new Emp();
		}
	}

	@Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException {
       switch(qName) {
       case "emp-id":
    	   emp.setEmpId(data);
    	   break;
       case "emp-nm":
    	   emp.setEmpNm(data);
    	   break;
       case "salary":
    	   emp.setSalary(Integer.parseInt(data));
    	   break;
       case "enter-dt":
    	   emp.setEnterDt(LocalDate.parse(data));
    	   break;
       case "emp":
    	   empList.add(emp);
    	   break;
       }
    }
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data = new String(ch, start, length); // 배열의 시작부터 길이까지 문자열이 만들어진다 
		
	}
	
	public List<Emp> getEmpList(){
		return this.empList;
	}
}
