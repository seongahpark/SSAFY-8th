package java5.generic.basic;

public class GenericContainer<T> { // Generic이라는 것을 알려주기 위해 <T> 추가
	private T element;

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
}
