import java.util.*;
import java.io.*;

public class BOJ_미세먼지안녕_17144_2 {
	static int R, C, T, ans;
	static int [][] arr, tmp;
	
	static int [] dy = { 0, 0, 1, -1 };
	static int [] dx = { -1, 1, 0, 0 };
	
	static int [][] cPos = new int[2][2];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		tmp = new int[R][C];
		
		int cIdx = 0;
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					cPos[cIdx][0] = i;
					cPos[cIdx][1] = j;
					cIdx++;
				}
			}
		}
		
		// 위잉
		for(int i=0; i<T; i++) {
			dust();
			wind();
		}
		
		// 먼지값 계산
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] > 0) ans += arr[i][j];
			}
		}

		System.out.println(ans);
	}
	
	static void dust() {
		// tmp 맵 초기화
		for(int i=0; i<R; i++) {
			Arrays.fill(tmp[i], 0);
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				tmp[i][j] += arr[i][j];
				if(arr[i][j] < 5) continue;
				int val = arr[i][j] / 5;
				
				for(int d=0; d<4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					
					if(ny < 0 || nx < 0 || ny >= R || nx >= C || arr[ny][nx] == -1) continue;
					tmp[i][j] -= val;
					tmp[ny][nx] += val;
				}
			}
		}
		
		// 계산이 다 끝나면 tmp 값들 arr로 옮겨줌
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
	}
	
	static void wind() {
		// tmp 맵 초기화
		for(int i=0; i<R; i++) {
			Arrays.fill(tmp[i], 0);
		}
		
		// 2개의 공기청정기
		for(int idx = 0; idx<2; idx++) {
			int ny = cPos[idx][0];
			int nx = cPos[idx][1] + 1; // 공기청정기 바로 오른쪽에서부터 이동해야 함
			
			// 공기청정기 -> 오른쪽 끝
			while(nx < C-1) {
				tmp[ny][nx+1] = arr[ny][nx];
				nx++;
			}
			
			// 오른쪽 끝 -> 위, 아래
			if(idx == 0) {
				while(ny > 0) {
					tmp[ny-1][nx] = arr[ny][nx];
					ny--;
				}
			}else {
				while(ny < R-1) {
					tmp[ny+1][nx] = arr[ny][nx];
					ny++;
				}
			}
			
			// 오른쪽 끝 -> 왼쪽
			while(nx > 0) {
				tmp[ny][nx-1] = arr[ny][nx];
				nx--;
			}
			
			// 왼쪽 끝 -> 공기청정기
			if(idx == 0) {
				while(ny < cPos[idx][0] - 1) {
					tmp[ny+1][nx] = arr[ny][nx];
					ny++;
				}
			}else {
				while(ny > cPos[idx][0] + 1) {
					tmp[ny-1][nx] = arr[ny][nx];
					ny--;
				}
			}
		}
		
		// tmp -> arr
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if( i == 0 || i == R-1 || j == 0 || j == C-1 || i == cPos[0][0] || i == cPos[1][0])
					arr[i][j] = tmp[i][j];
			}
		}	
	}
}
