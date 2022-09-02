// Daily 3-3 빌딩건설
package com.ssafy.ws02.step3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_STATIC {

	static int T, N, ans;
	static char [][] arr;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input.txt"));
//		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					//arr[i][j] = sc.next().charAt(0);
					arr[i][j] = st.nextToken().charAt(0);
					
					// 만약 int 배열이라면?
					// arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
			int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
			
			ans = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 8방향 탐색
					int cnt = 0;
					int tmp_x = 0, tmp_y = 0, tmp_res = 0;
					for(int z=0; z<8; z++){
						int nx = j + dx[z];
						int ny = i + dy[z];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N || arr[ny][nx] == 'B') cnt++;
					}
					if(cnt == 8) {
						for(int k =0; k<N; k++) {
							if(arr[i][k] == 'B') tmp_x++;
							if(arr[k][j] == 'B') tmp_y++;
						}
						tmp_res = tmp_x + tmp_y - 1;
						ans = Math.max(tmp_res, ans);
					}
				}
			}
			if(ans == 0) ans = 2;
			m();
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	static void m() {
		// area 작업
		System.out.println(arr);
	}

}
