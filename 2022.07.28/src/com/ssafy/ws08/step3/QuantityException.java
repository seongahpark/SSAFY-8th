package com.ssafy.ws08.step3;

public class QuantityException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuantityException() {
		super("수량이 부족합니다");
	}
}

