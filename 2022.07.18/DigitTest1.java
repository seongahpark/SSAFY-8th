
package com.ssafy.ws01.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		int count = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				// i > j 인 경우에는 공백 출력 나머지는 숫자 출력인 것을 확인할 수 있다
				if(j < i) {
					System.out.printf("%3s", " "); // 공백 문자를 세자리로 출력하겠다
				}else {
					System.out.printf("%3d", count++);
				}
			}
			System.out.println();
		}
	}
}
