package boj;

import java.io.*;
import java.util.*;

// 시뮬레이션 + BFS
public class BOJ_아기상어_16236 {

	static int N, sy, sx, sSize = 2, sEatCnt, ans;	
	static int [][] arr;
	static boolean [][] visit;
	static Queue<Node> q = new ArrayDeque<>();
	
	static int [] dx = { 0, 0, 1, -1 };
	static int [] dy = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					sy = i;
					sx = j;
				}
			}
		}
		
		while(true) {
			// 먹이 사냥이 가능한 동안, 먹이 사냥 <= bfs(), bfs()는 사냥하는 동안 걸린 초를 return
			// bfs()가 0을 return 하면 더 이상 먹을 고기가 없다
			// bfs()가 0이 아닌 값을 return 하면, 먹이 사냥에 걸린 시간이므로 ans에 누적
			int cnt = bfs();
			if(cnt == 0) break;
			ans += cnt;
		}
		
		System.out.println(ans);
	}
	
	static int bfs() {
		// 가장 작은 y, x, dis(거리)
		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minDis = Integer.MAX_VALUE;
		
		// visit 초기화
		for(int i=0; i<N; i++) {
			Arrays.fill(visit[i], false);
		}
		
		// 시작 위치부터 큐에 담고 bfs 시작
		visit[sy][sx] = true; // 항상 상어 시작 위치에서 출발
		q.add(new Node(sy, sx, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			// 물고기이고, 먹을 수 있는지 체크
			if(arr[node.y][node.x] != 0 && arr[node.y][node.x] < sSize) {
				// 먹이에 대한 계산
				if(node.d < minDis) {
					minDis = node.d;
					minY = node.y;
					minX = node.x;
				}else if(node.d == minDis) { // 같은 거리끼리 있는 친구들
					if(node.y < minY) {
						minDis = node.d;
						minY = node.y;
						minX = node.x;	
					}else if(node.y == minY) {
						if(node.x < minX) {
							minDis = node.d;
							minY = node.y;
							minX = node.x;
						}
					}
				}
			}
				
			// 가지치기
			if(node.d + 1 >= minDis) continue;
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || arr[ny][nx] > sSize ) continue;
				visit[ny][nx] = true;
				q.add(new Node(ny, nx, node.d + 1));
			}
		}
		
		// 먹이를 먹었냐 못먹었냐에 대한 결과 처리
		if(minDis == Integer.MAX_VALUE) return 0; // 먹을 물고기를 찾지 못했다
		else {
			sEatCnt++; // 먹은 물고기 수 증가
			if(sEatCnt == sSize) {
				sSize++;
				sEatCnt = 0;
			}
			
			arr[minY][minX] = 0; // 먹은 물고기 자리는 빈칸
			arr[sy][sx] = 0; // 상어가 출발한 자리
			
			// 새로운 상어의 자리 : 먹은 물고기의 자리
			sy = minY;
			sx = minX;
		}
		
		return minDis; // 먹은 물고기로 이동하는 데 걸린 최소 거리(초)
	}
	
	static class Node {
		int y, x, d;
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
