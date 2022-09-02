import java.util.*;
import java.io.*;

public class SWEA_특이한자석_4013 {

	static int T, K, ans;
	static int [] score = { 1, 2, 4, 8}; // 자석 4개 별 점수
	static int [] dir; // 자석별 회전 방향
	static int [][] gear = new int[4][8];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			ans = 0;
			
			for(int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시뮬레이션
			for(int i=0; i<K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken()) - 1; // 0 based
				int dir = Integer.parseInt(st.nextToken());
				
				// 움직이는 자석, 날개의 상태를 기준으로 각 자석이 어떻게 움직여야 하는지
				check(id, dir);
				// 자석을 하나씩 회전
				rotate();
			}
			
			// 채점
			for(int i=0; i<4; i++) {
				if(gear[i][0] == 1) ans += score[i];
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	static void check(int id, int d) {
		dir = new int[4];
		dir[id] = d;
		
		// 오른쪽 자석들
		for(int i=id+1; i<4; i++) {
			if(gear[i-1][2] != gear[i][6]) {
				dir[i] = dir[i-1] * (-1); // 반대로
			}
		}
		// 왼쪽 자석들
		for(int i=id-1; i>=0; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				dir[i] = dir[i+1] * (-1); // 반대로
			}
		}
	}
	
	static void rotate() {
		// 4개의 자석 회전 처리
		for(int i=0; i<4; i++) {
			int tmp;
			switch(dir[i]) {
			case 1:
				// 시계 방향
				tmp = gear[i][7];
				for(int j=7; j>0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = tmp;
				break;
			case -1:
				// 반시계 방향
				tmp = gear[i][0];
				for(int j=0; j<7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = tmp;
				break;
			}
		}
	}

}
