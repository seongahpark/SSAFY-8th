package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ItemSortTest {

	public static void main(String[] args) {
		{
			List<Item> al = new ArrayList<>();
			al.add(new Item(1, "item1"));
			al.add(new Item(2, "item2"));
			al.add(new Item(3, "item3"));
			
//			System.out.println(al);
			
			// for
//			for(int i=0; i<al.size(); i++) {
//				Item item = al.get(i);
//				System.out.println(item);
//			}
			
//			Iterator<Item> itr = al.iterator();
//			while(itr.hasNext()) {
//				System.out.println(itr.next());
//			}
			
//			// for-each
//			for(Item item : al) {
//				System.out.println(item);
//			}
			
			// 단순 순회 - lambda
			//al.forEach(item -> System.out.println(item));
		}
		
		{
			List<Item> al = new ArrayList<>();
			al.add(new Item(1, "item1"));
			al.add(new Item(2, "item2"));
			al.add(new Item(2, "item2"));
			al.add(new Item(3, "item3"));
			
			Item item2 = new Item(2, "item2");
			
//			for(int i=0; i<al.size(); i++) {
//				Item item = al.get(i);
//				if(item.equals(item2)) al.remove(i);
//			}
			
			// Iterator
//			Iterator<Item> itr = al.iterator();
//			while(itr.hasNext()) {
//				if(itr.next().equals(item2)) itr.remove();
//			}
			
			// lambda removeIf
			al.removeIf(el -> el.equals(item2));
			System.out.println(al);
		}

	}
	
	static class Item{
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
		
	}

}
