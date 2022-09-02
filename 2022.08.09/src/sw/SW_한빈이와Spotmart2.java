package sw;
import java.util.*;
import java.io.*;

public class SW_한빈이와Spotmart2 {

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
		
		for(int i=srcIdx; i<src.length; i++) {
			tgt[tgtIdx] = src[i]; // 현재 타겟 인덱스에 src 집어넣고, 현재 tgtIdx 자리가 계속 덮어쓰기 됨
			comb(i + 1, tgtIdx+1); // 그 다음것을 취하러 쭉 간다
		}
	}

}
