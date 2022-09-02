package boj;

import java.util.*;
import java.io.*;

public class BOJ_토마토_7576_2 {

	static int M, N, max;
	static int [][] arr;
	
	static int [] dx = {0, 0, 1, -1};
	static int [] dy = {1, -1, 0, 0};
	
	static Queue<Node> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) q.add(new Node(i, j, 0));
			}
		}
		
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(max);
	}

	static void bfs() {
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			// 꺼내면 일수 체크 max로 대체
			max = Math.max(max, n.d);

			for(int i=0; i<4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				if(nx < 0 || ny < 0 || ny >= N || nx >= M) continue;
				if(arr[ny][nx] != 0 ) continue;

				arr[ny][nx] = 1;
				q.add(new Node(ny, nx, n.d + 1));
			}
		}
	}
	
	static class Node{
		int y, x, d;
		
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
