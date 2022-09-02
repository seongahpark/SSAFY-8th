package collections.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// String
		// set 순서 유지 X, 중복 X
		{
			Set<String> set = new HashSet<>();
			set.add("hello");
			set.add("world");
			set.add("hello");
			set.add("ssafy");
			
			// 순서가 유지되면서 들어가는 자료구조가 아니다
			
			for(String s : set) {
				//System.out.println(s + " ");
			}
		}
		
		{
			Set<MyClass> set = new HashSet<>();
			set.add(new MyClass(7, 3, 3));
			set.add(new MyClass(5, 2, 3));
			set.add(new MyClass(7, 3, 4));
			set.add(new MyClass(9, 11, -1));
			set.add(new MyClass(4,2,3));
			
			// set은 equals와 hashCode를 통해 판단하여 데이터를 받아들임
			// 여기서는 hashCode가 다르기 때문에 중복되는 7 3 3을 둘 다 저장함
			// 따라서 equals를 오버라이딩 하여 체크해보도록 함
			
			for(MyClass s : set) {
				System.out.println(s + " ");
			}			
		}

	}
	
	static class MyClass{
		int y;
		int x;
		int c;
		
		public MyClass(int y, int x, int c){
			this.y = y;
			this.x = x;
			this.c = c;
		}

		@Override
		public String toString() {
			return "MyClass [y=" + y + ", x=" + x + ", c=" + c + "]";
		}
		
		@Override
		public boolean equals(Object o) {
			if(o != null && o instanceof MyClass) {
				MyClass mc = (MyClass)o;
				if(this.y == mc.y && this.x == mc.x && this.c == mc.c)return true;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.y, this.x, this.c);
		}
	}

}
