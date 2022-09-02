import java.util.*;
import java.io.*;

// DFS -> 시간 초과 (완전탐색으로는 힘들다)
public class BOJ_녹색옷입은애가젤다지_4485_2 {

	static int N, min;
	static int [][] arr;
	static boolean [][] visit;

	static int [] dy = { 0, 0, 1, -1 };
	static int [] dx = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			arr = new int[N][N];
			visit = new boolean[N][N];
			min = Integer.MAX_VALUE;
						
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visit[0][0] = true;
			dfs(0, 0, arr[0][0]);
			
			sb.append("Problem ").append(t).append(": ").append(min).append('\n');
			t++;
		}

		System.out.println(sb);
	}
	
	static void dfs(int y, int x, int c) {
		// 기저 조건
		if( y == N-1 && x == N-1) {
			min = Math.min(min, c); // 최소 비용 갱신
			return;
		}
		
		// 4방 탐색
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || nx >=N || ny >= N || visit[ny][nx]) continue;
			
			// 가지치기
			if(c + arr[ny][nx] >= min) continue;
			
			visit[ny][nx] = true;
			dfs(ny, nx, c + arr[ny][nx]);
			visit[ny][nx] = false;
			
		}
	}
}
