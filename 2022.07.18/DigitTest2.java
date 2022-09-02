
package com.ssafy.ws01.step3;

public class DigitTest2 {

	public static void main(String[] args) {
		// 변화가 생기는 지점을 기준으로 구분하도록 한다
		// 1. while문을 이용하여 숫자를 통해 구분하는 방식
		// 2. 이중 for문을 이용하여 구조를 파악해서 구분하는 방식
		
		// 1번 방법
		int target = 5 / 2; // 변화가 이루어지는 부분
		int blank = 0; // 출력할 공백 문자 개수
		boolean isIncrease = true; // 공백 문자 증감여부
		int no = 1;
		
		while(no <=17) {
			// 공백 출력
			for(int i=0; i<blank; i++) {
				System.out.printf("%3s", " ");
			}
			// 숫자 출력
			for(int i=0; i<5-blank*2; i++) {
				System.out.printf("%3d", no++);
			}
			// 개행
			System.out.println();
			
			// 공백 증감 여부 판단
			if(isIncrease) blank++;
			else blank--;
			
			// 변화 지점 확인 -> 반대로 전환
			if(blank >= target) isIncrease = false;
		}
		
		
		// 2번 방법
		blank = 0;
		no = 1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<blank; j++) {
				System.out.printf("%3s", " ");
			}
			
			for(int j=0; j<5-blank*2; j++) {
				System.out.printf("%3d", no++);
			}
			
			if(i < target) blank++;
			else blank--;
		
			System.out.println();
		}
		
		// 2번 교수님 방법
		blank = 0;
		no = 1;
		for(int i=0; i<5; i++) { // row
			for(int j=0; j<5; j++) { // col
				// 공백
				if(j < blank) System.out.printf("%3s", " ");
				// 숫자
				else if(j < 5 - blank) System.out.printf("%3d", no++);
			}
			System.out.println();
			
			if(i < target) blank++;
			else blank--;
		}
	}
}
