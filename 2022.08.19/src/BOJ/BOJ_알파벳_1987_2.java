package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_알파벳_1987_2 {
	
	static int R, C, res;
	static char [][] arr;
	static boolean [] chk = new boolean[26];
	
	static int dx[] = { 0, 0, 1, -1};
	static int dy[] = { 1, -1, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][];
		
		for(int i=0; i<R; i++){
			arr[i] = br.readLine().toCharArray();
		}
		
		chk[arr[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(res);
	}
	
	static void dfs(int x, int y, int cnt) {
		res = Math.max(res, cnt);
		chk[arr[x][y] - 'A'] = true;
		
		// 다음 방문이 가능하면 다시 방문
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || nx >= R || ny >= C || chk[arr[nx][ny] - 'A']) continue;
			dfs(nx, ny, cnt+1);
		}
		
		// visit 원복
		chk[arr[x][y] - 'A'] = false;
	}

}
