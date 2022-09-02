package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_알파벳_1987 {
	
	static int R, C, res;
	static char [][] arr;
	static boolean [] chk;
	
	static int dx[] = { 0, 0, 1, -1};
	static int dy[] = { 1, -1, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		chk = new boolean[26];
		
		for(int i=0; i<R; i++){
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		
		chk[arr[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(res);
	}
	
	static void dfs(int x, int y, int cnt) {
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C ) continue;
			int tmp = arr[nx][ny] - 'A';
			if(chk[tmp]) continue;
			
			chk[tmp] = true;
			dfs(nx, ny, cnt + 1);
			chk[tmp] = false;
		}
		
		res = Math.max(res, cnt);
	}

}
