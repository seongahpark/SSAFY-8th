import java.util.*;
import java.io.*;

// Dijkstra
public class BOJ_녹색옷입은애가젤다지_4485_3 {

	static int N;
	static int [][] arr, cost;
	static boolean [][] visit;
	static final int INF = Integer.MAX_VALUE;
	
	static int [] dy = { 0, 0, 1, -1 };
	static int [] dx = { 1, -1, 0, 0 };
	
	static PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			arr = new int[N][N];
			cost = new int[N][N];
			visit = new boolean[N][N];
						
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Arrays.fill(cost[i], INF);
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dijkstra();
			
			sb.append("Problem ").append(t).append(": ").append(cost[N-1][N-1]).append('\n');
			t++;
		}

		System.out.println(sb);
	}
	
	static void dijkstra() {
		// 첫 번째 방문
		cost[0][0] = arr[0][0];
		pq.add(new Node(arr[0][0], 0, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(visit[n.y][n.x]) continue;
			visit[n.y][n.x] = true;
			
			for(int i=0; i<4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				// 꺼낸 좌표에서 이어 가려는 새로운 좌표의 비용을 갱신
				if(n.cost + arr[ny][nx] < cost[ny][nx]) {
					cost[ny][nx] = n.cost + arr[ny][nx];
					pq.add(new Node(cost[ny][nx], ny, nx));
				}
			}
		}
	}
	
	static class Node {
		int cost, y, x;
		public Node(int cost, int y, int x) {
			this.cost = cost;
			this.y = y;
			this.x = x;
		}
	}
}
