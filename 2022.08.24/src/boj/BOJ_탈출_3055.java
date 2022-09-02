package boj;

import java.util.*;
import java.io.*;

// 물이 먼저 퍼지고 그 다음에 고슴도치가 이동
// bfs로 물이 퍼져 나갈 때, while(!isEmpty)한 동안 안에서 반복 처리 <- 고슴도치의 이동이 포함
// 고슴도치, 물 따로 큐를 생성하고, 고슴도치의 큐를 중심으로 처리
// -> 큐에 대한 작업을 현재 담긴 모든 대상을 전부 다 처리 다 하고 고슴도치 처리 하고..

public class BOJ_탈출_3055 {

	static int R, C, min;
	static char [][] arr;
	
	static int [] dx = { 1, -1, 0, 0};
	static int [] dy = {0, 0, 1, -1};
	
	static Queue<Node> wq = new ArrayDeque<>();
	static Queue<Node> gq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][];
		for(int i=0; i<R; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(arr[i][j] == 'S') gq.add(new Node(i, j, 0));
				else if(arr[i][j] == '*') wq.add(new Node(i, j, 0));
			}
		}
		
		min = Integer.MAX_VALUE;
		check();
		
		System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);
	}
	
	static void check() {
		// 고슴도치의 기준으로
		while(!gq.isEmpty()) {
			// 물 확산
			// 현재 물 큐에 있는 물만을 모두 꺼내서 처리
			int size = wq.size();
			for(int i=0; i<size; i++) { // 현재 물인 것만 모두 꺼내서
				Node node = wq.poll();
				for(int d=0; d<4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];
					if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
					if(arr[ny][nx] == '.') {
						// 물이 퍼진 상태를 arr에 표시
						arr[ny][nx] = '*';
						wq.add(new Node(ny, nx, 0)); // 다음 번 퍼질 물
					}
				}
			}
			// 고슴도치 이동
			// 물 확산을 미리 처리했으므로 고슴도치는 이동시에 빈 칸인 것만으로 이동 ('D' 이면 종료)
			size = gq.size();
			for(int i=0; i<size; i++) {
				Node node = gq.poll();
				for(int d=0; d<4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];
					if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
					if(arr[ny][nx] == 'D') { // 목적지 도달
						min = Math.min(min, node.d + 1);
						return;
					}
					else if(arr[ny][nx] == '.') {
						arr[ny][nx] = 'S';
						gq.add(new Node(ny, nx, node.d + 1)); // 다음 번 퍼질 물
					}
				}
			}
		}
	}

	static class Node{
		int y, x, d;
		public Node(int y, int x, int d){
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
