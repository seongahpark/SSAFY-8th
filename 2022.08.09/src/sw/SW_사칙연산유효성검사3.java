package sw;
import java.util.*;
import java.io.*;

public class SW_사칙연산유효성검사3 {

	static int N, ans;
	static char [] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1]; // 0 dummy
			
			for(int i=1; i<=N; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0); 
			}
			
			ans = dfs(1)? 1 : 0; // 맨 위 노드부터 시작
			
			System.out.println("#" + t + " " + ans);
		}
		br.close();
	}

	static boolean dfs(int x) {
		// 기저 조건
		if(x>N) return false;
		if(Character.isDigit(node[x])) {
			if(x*2 > N) return true;
			return false;
		}else {
			//현재 index의 노드가 연산자
			return (dfs(x*2) && dfs(x*2+1));
		}
	}
}
