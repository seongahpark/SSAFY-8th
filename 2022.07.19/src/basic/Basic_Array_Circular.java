package basic;

public class Basic_Array_Circular {

	public static void main(String[] args) {
		char[] input = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int n = input.length;
		
		// normal
//		{
//			for(int i=0; i<n; i++) {
//				System.out.printf("%2s", input[i]);
//			}
//		}

//		System.out.println();
		// normal * 2
//		{
//			for(int i=0; i<n*2; i++) {
//				System.out.printf("%2s", input[i]);
//			}
//		}
		
//		{
//			for(int i=0; i<n*2 + 5; i++) {
//				System.out.printf("%2s", input[i%n]);
//				
//			}				
//		}
		
//		System.out.println();
		// while
//		{
//			int count = 0;
//			int i = 0;
//			while(true) {
//				if(count >= 20) break;
//				System.out.printf("%2s", input[i%n]);
//				count++;
//				i++;
//			}
//		}
		
//		System.out.println();
		
		// 이차원 배열 대각선 출력 (성공!)
		{
		    int [][] intArray = 
		        { { 1, 2, 3, 4, 5 },
		          { 6, 7, 8, 9,10 },
		          {11,12,13,14,15 },
		          {16,17,18,19,20 },
		          } ;
		    
		   int yLen = intArray.length;
		   int xLen = intArray[0].length;
		   
		   int r = 0, c = 0, start_c = 0;
		   int cnt = xLen + yLen - 1;
		   
		   // 반복 : r + c - 1
		   // r 은 처음에 증가하다가 고정
		   // c는 고정되다가 증가
		   while(cnt-- >= 0) {
			  while(r >= 0 && c < xLen) {
				  System.out.print(intArray[r][c] + " ");
				  r--;
				  c++;
			  }
			  r = c;
			  if(c > yLen - 1) {
				  start_c++;
				  c = start_c;
			  }else c = 0;
			  if(r >= yLen) r = yLen-1;
		   }
		}
	}

}
