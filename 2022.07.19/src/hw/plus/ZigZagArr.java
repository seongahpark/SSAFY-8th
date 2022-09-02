package hw.plus;

public class ZigZagArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
