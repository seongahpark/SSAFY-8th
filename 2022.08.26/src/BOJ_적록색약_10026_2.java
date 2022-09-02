import java.util.*;
import java.io.*;

public class BOJ_적록색약_10026_2 {

	static int N, cnt, cnt2;
	static char [][] map;
	static boolean [][] visit;
	static int [] dy = { 0, 0, 1, -1 };
	static int [] dx = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					dfs(i, j);
					cnt2++;
				}
			}
		}	
		
		System.out.println(cnt + " " + cnt2);
	}
	
	static void dfs(int y, int x) {
		visit[y][x] = true;
		
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] != map[y][x]) continue;
			dfs(ny, nx);
		}
	}
}
