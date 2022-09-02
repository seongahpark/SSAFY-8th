package sw;
import java.util.*;
import java.io.*;

public class SW_암호문2 {

	static int T = 10;
	static int N, Order;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=T; t++) {
			arr = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			Order = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<Order;i++) {
				String l = st.nextToken(); // l
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				
				int [] tmp = new int[num];
				for(int j=0; j<num; j++) {
					tmp[j] = Integer.parseInt(st.nextToken());
				} 
				
				for(int j=num-1; j>=0; j--) {
					arr.add(idx, tmp[j]);
				}
			}
			System.out.print("#" + t + " ");
			for(int i=0; i<10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
		}	
		
		br.close();
	}

}
