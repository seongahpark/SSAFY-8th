package sw;
import java.util.*;
import java.io.*;

public class SW_한빈이와Spotmart {

	static int T, N, M, ans;
	static int[] src, tgt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 초기화
			src = new int[N];
			tgt = new int[2];
			
			ans = -1;
			
			// 입력 처리
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			
			// 조합
			comb(0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건  - tgt
		if(tgtIdx == 2) {
			// complete code
			int sum = tgt[0] + tgt[1];
			if(sum > M) return;
			ans = Math.max(ans, sum);
			return;
		}
		
		// 기저조건 - src
		if(srcIdx == N) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		// 재귀 호출
		comb(srcIdx+1, tgtIdx+1); // 현재를 선택하고 간다
		comb(srcIdx+1, tgtIdx); // 현재를 선택하지 않고 간다
	}

}
