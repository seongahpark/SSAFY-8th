package com.ssafy.hw.step2;

import java.util.Arrays;
import java.util.Scanner;

public class Bridge_P {
	
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		// n * n 크기 배열 선언 ( 지도 )
		int[][] map = new int[n][n];
		
		// 지도 정보 입력 받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		// 최대값 저장
		int maxDistance = 0;
		for ( int i =0 ; i < n; i++ ) {
			for ( int j =0 ; j < n ; j++ ) {
				// 지금 위치가 섬인지 검사
				if (map[i][j] == 1) {	
					// 섬이면 현재 위치로부터 사방탐색 하여 가로 또는 세로에 있는 섬과 거리 측정, 최대값 저장
					int tmp = 1;
					
					for(int z = 0; z < 4 ; z++) {
						int nx = j;
						int ny = i;
						while(true) {
							nx += dx[z];
							ny += dy[z];
							
							if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[ny][nx] == 0) break;
							tmp++;
						}
					}
					maxDistance = Math.max(maxDistance, tmp);
				}
			}
		}
		System.out.println(maxDistance);

	}
}

/*
8
1 0 1 0 0 0 1 1
1 1 1 1 0 1 0 0
0 1 0 0 1 0 0 0
0 1 0 0 0 0 0 1
1 0 0 1 1 1 0 1
0 1 1 0 0 0 1 0
0 0 0 1 1 0 0 1
1 1 1 0 0 1 1 1
 * 
 */
