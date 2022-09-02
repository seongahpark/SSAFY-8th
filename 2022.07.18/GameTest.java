
package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {
	// choice 1 -> 가위, 2 -> 바위, 3-> 보
	// res 1 -> 이김, 2 -> 비김, 3-> 짐
	public static int rsp(int choice) {
		int com = (int)Math.random() * 3 + 1;
		
		if((choice == 1 && com == 3) || (choice == 2 && com == 1) || (choice == 3 && com == 2)) {
			System.out.println("이겼습니다!!!");
			return 1; // 유저가 이기는 경우
		}
		else if(choice == com) {
			System.out.println("비겼습니다!!!");
			return 2;
		}
		System.out.println("졌습니다!!!");
		return 3;
	}
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요. ").append("\n")
		.append("1. 5판 3승").append("\n")
		.append("2. 3판 2승").append("\n")
		.append("3. 1판 1승").append("\n")
		.append("번호를 입력하세요.  ");
		
		System.out.println(sb);
		
		Scanner sc = new Scanner(System.in);
		int com = 0, user = 0;
		int gameCnt = 0, winCnt = 0;
		int round = sc.nextInt();
		int count = 0;
		
		switch(round) {
			case 1:
				winCnt = 3;
				gameCnt = 5;
				break;
			case 2:
				winCnt = 2;
				gameCnt = 3;
				break;
			case 3:
				winCnt = 1;
				gameCnt = 1;
				break;
			default:
				System.out.println("잘못된 입력입니다");
		}
		while(count < gameCnt && (com < winCnt && user < winCnt)) {			
			System.out.printf("가위바위보 중 하나 입력 : ");
			int choice = sc.nextInt();
	
			int res = 0;
			if(choice == 1) {
				res = rsp(1);
			}
			else if(choice == 2) {
				res = rsp(2);
			}
			else if(choice == 3) {
				res = rsp(3);
			}
			
			if(res == 1) user++;
			else if(res == 3) com++;
			
			count++;
		}
		if(user > com) System.out.println("### 사용자 승!");
		else if(com > user) System.out.println("### 컴퓨터 승!");
		else System.out.println("### 무승부!!!");
		sc.close();
	}

}
