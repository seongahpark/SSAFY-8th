import java.util.*;
import java.io.*;

// 못풀었음
public class BOJ_미세먼지안녕_17144 {
	static int R, C, T, upX = -1, upY, downX = -1, downY, res;
	static int [][] arr, tmp;
	
	static int [] dy = { 0, 0, 1, -1 };
	static int [] dx = { -1, 1, 0, 0 };
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		tmp = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					if(upX == -1) {
						upX = j;
						upY = i;
					}else {
						downX = j;
						downY = i;		
					}
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
				if(arr[i][j] > 0) res += arr[i][j];
			}
		}

		System.out.println(res);
	}
	
	static void dust() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] > 0) {
					// 먼지가 있을 때
					int val = arr[i][j] / 5; // 퍼질 미세먼지의 양 계산
					int chk = 0; // 몇 방향으로 나갈건지 체크
					for(int d=0; d<4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						
						if(ny < 0 || nx < 0 || ny >= R || nx >= C || arr[ny][nx] == -1) continue;
						chk++;
						tmp[ny][nx] += val; // 먼지 확산 값 저장
					}
					tmp[i][j] = arr[i][j] - (val * chk);					
				}
			}
		}
		
		// 계산이 다 끝나면 tmp 값들 arr로 옮겨줌
		for(int i=0; i<R; i++) {
			for(int j=0; j<R; j++) {
				if(arr[i][j] != -1) arr[i][j] = tmp[i][j];
			}
		}
	}
	
	static void wind() {
//		for(int j=0; j<R; j++) {
//			System.out.println(Arrays.toString(arr[j]));
//		}
		System.out.println();
		
		// 위
		int x = upX;
		int y = upY - 1; // 시작점
		
		int flag = 1;
		while(true) {
			switch(flag) {
			case 1:
				// 위 -> 아래
				if(y-1 >= 0) {
					arr[x][y] = arr[x][y-1];
					
				}
				else flag++;
				y--;
				break;
			case 2:
				// 오 -> 왼
				if(x+1 < C-1) {
					arr[x][y] = arr[x+1][y];
					
				}
				else flag++;
				x++;
				break;
			case 3:
				// 아래 -> 위
				if(y+1 < upY) {
					arr[x][y] = arr[x][y+1];
					
				}
				else flag++;
				y++;
				break;
			case 4:
				// 왼 -> 오
				if(x-1 > upX) {
					arr[x][y] = arr[x-1][y];
					
				}
				x--;
				break; 
			}
			if(x == upX && y == upY) break;
		}
		
		// 아래
		x = downX;
		y = downY + 1; // 시작점
		
		flag = 1;
		while(true) {
			switch(flag) {
			case 1:
				// 아래 -> 위
				if(y+1 < R-1) {
					arr[x][y] = arr[x][y+1];
				}
				else flag++;
				y++;
				break;
			case 2:
				// 오 -> 왼
				if(x+1 < C-1) {
					arr[x][y] = arr[x+1][y];
					
				}
				else flag++;
				x++;
				break;
			case 3:
				// 
				if(y-1 > downY) {
					arr[x][y] = arr[x][y-1];
					
				}
				else flag++;
				y--;
				break;
			case 4:
				// 왼 -> 오
				if(x-1 > downX) {
					arr[x][y] = arr[x-1][y];
				}
				x--;
				break; 
			}
			if(x == downX && y == downY) break;
		}
		
//		for(int j=0; j<R; j++) {
//			System.out.println(Arrays.toString(arr[j]));
//		}
//		System.out.println("================");
	}
}
