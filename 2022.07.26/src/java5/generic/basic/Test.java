package java5.generic.basic;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		ObjectContainer oc = new ObjectContainer();
		oc.setElement("String"); // String
		// ... 다른 코드 ...
		String str = (String)oc.getElement(); // 타입을 알고있을 경우
		
		if(oc.getElement() instanceof String) {
			String str2 = (String)oc.getElement(); // 타입을 모를 경우. 타입 검사가 필요함
		}
		
		StringContainer sc = new StringContainer(); // 한 가지 타입만 사용할 경우
		sc.setElement("String");
		String str3 = sc.getElement();
		
		// 즉 여러 타입을 받아주고 싶으면 object로 담아줬지만, 뺄 때 캐스팅을 해주고, 타입 체크를 해줘야 하는 번거로움이 있다
		// 한 가지 타입만을 사용할 경우 각 타입별로 모두 만들어야 됐다
		
		// 제네릭 컨테이너를 이용하여 타입을 자유롭게 담아보자
		// T를 대체할(T 대신 실제로 사용될 타입) 타입을 <> 안에 명시
		GenericContainer<String> gc = new GenericContainer<>();
		gc.setElement("String");
		String str4 = gc.getElement();
		
		GenericContainer<Integer> gc2= new GenericContainer<>();
		gc2.setElement(10);
		Integer n1 = gc2.getElement();
		
		int[] intArray = { 1, 2, 3};
		String[] strArray = {"Hello", "World", "Ssafy"};
		
		// Reference 타입의 Collections을 활용해보자
//		ArrayList old = new ArrayList(); // 옛날 버전의 Collections
//		old.add("Hello");
		
		ArrayList<String> list = new ArrayList<>();
		list.add("Hello");
		
		List<MyClass> mcList = new ArrayList<>();
		mcList.add(new MyClass());
	}
	
	static class MyClass{
		int n;
	}

}
