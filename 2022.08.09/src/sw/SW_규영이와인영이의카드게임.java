package sw;

import java.io.*;
import java.util.*;

public class SW_규영이와인영이의카드게임 {

	static int T, win, lose, N = 9;
	static int [] input = new int[19];
	static int [] guCard = new int[9]; // 테케에서 고정
	static int [] inCard = new int[9]; // guCard에 없는 번호를 입력
	static int [] tgt = new int[9];
	
	static boolean [] select = new boolean[N];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			win = 0; lose = 0; // 초기화
			Arrays.fill(input, 0);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 규영이 카드
			int num = 0;
			for(int i=0; i<N; i++) {
				num = Integer.parseInt(st.nextToken());
				guCard[i] = num;
				input[num] = 1; // 인영이 카드 설정
			}
			
			// 인영이 카드
			num = 0;
			for(int i=1; i<=18;i++) {
				if(input[i] == 0) {
					inCard[num++] = i;
				}
			}
			
			perm(0);
			
			System.out.println("#" + t + " " + win + " " + lose);
		}
		br.close();

	}
	
	static void perm(int tgtIdx) {
		// 기저조건
		// 규영이의 카드로부터 임의의 카드를 순열로 완성
		if(tgtIdx == N) {
			// complete 코드
			check();
			return;
		}
		
		for(int i=0; i<N;i++) {
			// 이미 선택된 i 제외
			if(select[i]) continue;
			
			tgt[tgtIdx] = inCard[i];
			select[i] = true;
			perm(tgtIdx+1); // 현재 i를 선택해서 모든 경우의 순열을 따져보아 return 돼서 돌아오면 다음 선택으로 넘어간다
			select[i] = false;
		}
	}
	
	static void check() {
		int guSum = 0;
		int inSum = 0;
		for(int i=0; i<N;i++) {
			if(guCard[i] > tgt[i]) guSum += guCard[i] + tgt[i];
			else inSum += guCard[i] + tgt[i];
		}
		
		if(guSum > inSum) win++;
		else if(guSum < inSum) lose++;
	}
	
}

/*
4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18
*/