package sw;
import java.util.*;
import java.io.*;

public class SW_암호문1 {

	static int T = 10;
	static int N, M;
	static List<String> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			//초기화
			list.clear();
			
			N = Integer.parseInt(br.readLine()); // 첫째 줄
			StringTokenizer st = new StringTokenizer(br.readLine()); // 둘째 줄
			for(int i=0; i<N; i++) {
				list.add(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine()); // 셋째 줄
			st = new StringTokenizer(br.readLine()); // 넷째 줄
			
			for(int i=0; i<M; i++) {
				st.nextToken(); // I 명령어 날려보냄
				int x = Integer.parseInt(st.nextToken()); // idx
				int y = Integer.parseInt(st.nextToken()); // 문자열 개수
				
				// x의 위치에 y개 만큼 문자열 추가
				int count = x + y;
				for(int j=x; j<count; j++) {
					list.add(j, st.nextToken());
				}
			}
			
			// 출력, 처음 10개만
			sb.append("#").append(t).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
