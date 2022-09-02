package oop.override.equalshash;

import java.util.Objects;

public class Item {
	int itemId;
	String itemNm;
	
	// equals(); 재정의 하지 않는다. Object 클래스의 equals()를 사용한다
	// Object 클래스의 equals()는 재정의하지 않으면 기본적으로 == 로 비교한다
	// 객체의 내용 비교를 위해 equals()를 사용하려면? 재정의 해야 한다
	// String 클래스는 재정의 하고 있다
	
	@Override
	public boolean equals(Object obj) {
		// obj -> 비교되는 객체
		// 나 -> this
		// 유효성 검사를 먼저 해줘야 함
		if(obj != null && obj instanceof Item) {
			// 타입 캐스팅이 필요
			Item item = (Item) obj;
			
			// 비교하여 하여 결과 반환
			if(this.itemId == item.itemId && this.itemNm.equals(item.itemNm)) return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + itemId;
		result = 31 * result + itemNm.hashCode();
		
		return result;
		
		// java version 1.7
		//return Objects.hash(itemId, itemNm);
	}
}
