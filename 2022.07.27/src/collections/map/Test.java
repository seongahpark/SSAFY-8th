package collections.map;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// 순서가 유지되지 않는 자료구조
		Map<String, String> map = new HashMap<>();
		map.put("love", "사랑하다");
		map.put("hate", "미워하다");
		map.put("same", "똑같다");
		map.put("ssafy", "무조건 취업");
		
		String meaning = map.get("same");
		System.out.println(meaning);
		
		map.put("love", "사랑하다2"); // 중복을 허용하지 않지만, 오류가 발생하지는 않는다
		// 중복이 되면 덮어쓰는 구조
		
		map.put("equals", "똑같다"); // value는 중복이 가능하다

		for(String key : map.keySet()) {
			System.out.print(key);
			System.out.println(" " + map.get(key));
		}
		
		{
//			Map<String, Integer> map2 = new HashMap<>();
//			map2.put("hi", 1);
//			map2.put("hello", 100);
//			map2.put("bye", -100);
//			
//			for(String key : map2.keySet()) {
//				System.out.println(key + " " + map2.get(key));
//			}
		}
		
		
	}

}
