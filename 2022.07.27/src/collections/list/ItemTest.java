package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ItemTest {

	public static void main(String[] args) {
		
		// #1. Item Class에 Comparable Interface 구현
		{
//			List<Item> al = new ArrayList<>();
//			al.add(new Item(1, "item1"));
//			al.add(new Item(3, "item3"));
//			al.add(new Item(2, "item2"));
//			al.add(new Item(2, "item5"));
//			System.out.println(al);
//			
//			Collections.sort(al);
//			
//			System.out.println(al);
		}
		
		{
			// #2. Comparator Interface 사용
			List<Item> al = new ArrayList<>();
			al.add(new Item(1, "item1"));
			al.add(new Item(3, "item3"));
			al.add(new Item(2, "item2"));
			al.add(new Item(2, "item5"));
			System.out.println(al);
			
//			Collections.sort(al, new Comparator<Item>() {
//
//				@Override
//				public int compare(Item o1, Item o2) {
//					return o1.itemId == o2.itemId ? o1.itemNm.compareTo(o2.itemNm): o1.itemId - o2.itemId;
//				}
//				
//			});
			
			// #3 Lambda
			Collections.sort(al, (o1, o2) -> o1.itemId == o2.itemId ? o1.itemNm.compareTo(o2.itemNm): o1.itemId - o2.itemId);
			System.out.println(al);
		}
	}
	
//	static class ComparatorImpl implements Comparator<Item>{
//
//		@Override
//		public int compare(Item o1, Item o2) {
//			return o1.itemId == o2.itemId ? o1.itemNm.compareTo(o2.itemNm): o1.itemId - o2.itemId;
//		}
//		
//	}
	
	static class Item { // implements Comparable<Item>
		int itemId;
		String itemNm;
		
		public Item(int itemId, String itemNm) {
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if(obj != null && obj instanceof Item) {
				Item item = (Item)obj;
				if(this.itemId == item.itemId && this.itemNm == item.itemNm) return true;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.itemId, this.itemNm);
		}

//		@Override
//		public int compareTo(Item o) {
//			// itemId만으로 정렬
//			// natural ordering -> 오름차순 정렬
//			// 오름차순 : this - 파라미터
//			// 내림차순 : 파라미터 - this 또는 -(this - 파라미터)
//			//return this.itemId - o.itemId;
//			
//			return this.itemId == o.itemId ? this.itemNm.compareTo(o.itemNm): this.itemId - o.itemId;
//		}
		
	}

}
