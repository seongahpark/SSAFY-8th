package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_알파벳_1987_3 {
	
	// 비트마스킹
	static int R, C, res;
	static int [][] arr;
	
	static int dx[] = { 0, 0, 1, -1};
	static int dy[] = { 1, -1, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		
		for(int i=0; i<R; i++){
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				arr[i][j] = tmp[j] - 'A';
			}
		}
		
		// arr[0][0] -> 어떤 int값이 있을 것. 그 값 만큼 1을  << 연산 수행
		dfs(0, 0, 1, 1 << arr[0][0]);
		
		System.out.println(res);
	}
	
	static void dfs(int x, int y, int cnt, int visit) {
		res = Math.max(res, cnt);
		
		// 다음 방문이 가능하면 다시 방문
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || nx >= R || ny >= C || (visit & 1 << arr[nx][ny]) != 0) continue;
			dfs(nx, ny, cnt+1, visit | 1 << arr[nx][ny]);
		}
	}

}
