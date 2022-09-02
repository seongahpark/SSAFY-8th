package oop.override.equalshash;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item1 = new Item(); // 0x1000
		item1.itemId = 1;
		item1.itemNm = "item";
		
		Item item2 = new Item(); // 0x2000
		item2.itemId = 1;
		item2.itemNm = "item";
		
		if(item1 == item2) System.out.println("Same"); // new 해서 만든거다보니 주소값이 달라 다를 수 밖에 없다
		else System.out.println("Not Same");
		
		if(item1.equals(item2)) System.out.println("Equal Same");
		else System.out.println("Not same");
		
		System.out.println(item1.hashCode());
	}

}
