import java.util.*;
import java.io.*;

public class BOJ_녹색옷입은애가젤다지_4485 {

	static int N, idx = 1, res;
	static int [][] arr, road;

	static int [] dy = { 0, 0, 1, -1 };
	static int [] dx = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			arr = new int[N][N];
			road = new int[N][N];
						
			for(int i=0; i<N; i++) {
				Arrays.fill(road[i], 987654);
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = dijkstra();
			
			sb.append("Problem ").append(idx).append(": ").append(res).append('\n');
			idx++;
		}

		System.out.println(sb);
	}
	
	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		road[0][0] = arr[0][0];
		
		pq.add(new Node(arr[0][0], 0, 0));
		
		while(!pq.isEmpty()) {
			int cost = pq.peek().cost;
			int y = pq.peek().y;
			int x = pq.peek().x;
			
			pq.poll();
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(road[ny][nx] > arr[ny][nx] + cost) {
					road[ny][nx] = arr[ny][nx] + cost;
					pq.add(new Node(road[ny][nx], ny, nx));
				}
			}
		}
		
		return road[N-1][N-1];
	}

	static class Node implements Comparable<Node>{
		int cost, y, x;
		public Node(int cost, int y, int x) {
			this.cost = cost;
			this.y = y;
			this.x = x;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
