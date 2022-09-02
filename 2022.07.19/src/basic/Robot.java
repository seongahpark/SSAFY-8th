package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Robot {

	static int dx[] = {1, -1, 0, 0}; // 우, 좌, 상, 하
	static int dy[] = {0, 0, -1, 1};
	static int test_case, N;
	static char arr [][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= test_case; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			
			// INPUT
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<N; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
			}
			
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			
			// SOLVE
			int res = 0;
			for(int i=0; i<N; i++) {
				for(int j =0; j<N; j++) {
					if(arr[i][j] == 'A') {
						int nx = j;
						while(true) {
							nx += dx[0];
							if(nx >= N || arr[i][nx] != 'S') break;
							res++;
						}
					}else if(arr[i][j] == 'B') {
						for(int z=0; z<2; z++) {
							int nx = j;
							while(true) {
								nx += dx[z];
								if(nx < 0 || nx >= N || arr[i][nx] != 'S') break;
								res++;
							}
						}
					}else if(arr[i][j] == 'C') {
						for(int z=0; z<4; z++) {
							int nx = j;
							int ny = i;
							while(true) {
								nx += dx[z];
								ny += dy[z];
								if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[ny][nx] != 'S') break;
								res++;
							}
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
		
	}

}
