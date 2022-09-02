package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		{
			ArrayList al = new ArrayList(); // Generic에 대한 경고
		}
		
		{
			//ArrayList<String> al = new ArrayList<>();
			List<String> al = new ArrayList<>(); // 왼쪽 List Interface 타입
			// 왼쪾은 원하는 기능. 오른쪽은 기능을 구현한 객체. 이렇게 사용하는 것을 권장
			al.add("손흥민");
			al.add("이강인");
			al.add("이승우");
//			System.out.println(al);
			
//			al.add("이강인");
//			System.out.println(al);
//			
//			al.remove(0);
//			System.out.println(al);
//			al.remove("이승우"); // by object
//			System.out.println(al);
//			
//			al.remove("이강인");
//			System.out.println(al);
//			
//			al.remove("이강인");
//			System.out.println(al);
//			
//			al.remove("이강인"); // 이미 비어있는 상태에서 remove를 하더라도 오류가 뜨는 것이 아니라 그냥 null로 나온다
//			System.out.println(al);
			
		}
		
		{
			List<Integer> al = new ArrayList<>();
			al.add(1);
			al.add(2);
			al.add(10);
			al.add((int)'A');
			
//			System.out.println(al);
		}
		
		{
			List<String> al = new ArrayList<>(); // 왼쪽 List Interface 타입
			// 왼쪾은 원하는 기능. 오른쪽은 기능을 구현한 객체. 이렇게 사용하는 것을 권장
			al.add("손흥민");
			al.add("이강인");
			al.add("이승우");
			al.add("슈퍼쏜");
			
//			//for문으로 순회
//			for(int i=0; i<al.size(); i++) {
//				String s = al.get(i);
//				System.out.print(s + " ");
//			}
//			
//			System.out.println();
//			
//			// for each, index가 없다
//			for(String s : al) {
//				System.out.print(s + " ");
//			}
//			
//			System.out.println();
//			
//			// Iterator. 순회시 Iterator 사용을 권장한다
//			Iterator<String> itr = al.iterator();
//			while(itr.hasNext()){ // 다음 것이 존재한다면
//				String s = itr.next();
//				System.out.print(s + " ");
//			}
		}
		
		// 순회 중 삭제
		{
//			List<String> al = new ArrayList<>(); // 왼쪽 List Interface 타입
//			// 왼쪾은 원하는 기능. 오른쪽은 기능을 구현한 객체. 이렇게 사용하는 것을 권장
//			al.add("손흥민");
//			al.add("이강인");
//			al.add("이강인");
//			al.add("슈퍼쏜");
			
			// for -> size()로 인한 문제 발생
//			int size = al.size();
//			for(int i=0; i<size; i++) {
//				String s = al.get(i);
//				if(s.equals("이강인")) {
//					al.remove(i);
//				}
//			}
			// 이렇게 되면 문제점 : 이미 remove로 index가 하나씩 당겨졌기 때문에
			// 삭제된 바로 다음 인덱스는 탐색을 하지 못한채로 건너뛰게 되는 문제가 발생한다
			
//			System.out.println(al);
//			
//			// 뒤에서 부터 변화가 되다보니 앞쪽에 대상이 되는 애들은 변화가 없으니 문제가 없다
//			// 즉, reverse order로 해결이 가능하다
//			for(int i=al.size() - 1; i>0; i--) {
//				String s = al.get(i);
//				if(s.equals("이강인")) al.remove(i);
//			}
//			System.out.println(al);
			
			// iterator 사용 -> 권장
//			Iterator<String> itr = al.iterator();
//			while(itr.hasNext()) {
//				String s = itr.next();
//				if(s.equals("이강인")) itr.remove(); // iterator을 통해 remove 해야 한다
//				// al.remove가 아니라는 것에 반드시 주의!
//			}
//			System.out.println(al);
			
//			// for each -> ConcurrentModificationException 에러 발생
//			for(String s : al) {
//				if(s.equals("이강인")) al.remove(s);
//			}
//			System.out.println(al);
			
			// ArrayList 안에 있는 elements 중에 조건에 true 한 애가 있다면 제거
//			al.removeIf(el -> el.equals("이강인"));
//			System.out.println(al);
		}
		
		// sort
		{
			List<String> al = new ArrayList<>(); // 왼쪽 List Interface 타입
			// 왼쪾은 원하는 기능. 오른쪽은 기능을 구현한 객체. 이렇게 사용하는 것을 권장
			al.add("손흥민");
			al.add("이강인");
			al.add("이승우");
			al.add("슈퍼쏜");		
			
			System.out.println(al);
			
			Collections.sort(al);
			
			System.out.println(al);
		}

	}

}
