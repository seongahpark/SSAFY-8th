package boj;

import java.util.*;
import java.io.*;

public class BOJ_토마토_7576 {

	static int M, N, ans;
	static int [][] arr, res;
	static boolean [][] visited;
	
	static int [] dx = {0, 0, 1, -1};
	static int [] dy = {1, -1, 0, 0};
	
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		res = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) q.add(new int[] {i, j});
			}
		}
		
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0 && res[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				ans = Math.max(ans, res[i][j]);
			}
		}
		
		System.out.println(ans);
	}

	static void bfs() {
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(visited[nx][ny] || arr[nx][ny] != 0 ) continue;
				visited[nx][ny] = true;
				q.add(new int[] {nx, ny});
				res[nx][ny] = res[x][y] + 1;
			}
		}
	}
}
