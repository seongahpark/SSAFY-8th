package swea;

import java.util.*;
import java.io.*;

public class SWEA_준환이의양팔저울_3234 {

	static int T, N;
	static int [] arr;
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    
	    for(int t=1; t<=T; t++) {
	    	N = Integer.parseInt(br.readLine());
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	
	    	arr = new int[N];
	    	for(int i=0; i<N; i++) {
	    		arr[i] = Integer.parseInt(st.nextToken());
	    	}
	    }
	}
	
	static void dfs() {
		
	}

}
