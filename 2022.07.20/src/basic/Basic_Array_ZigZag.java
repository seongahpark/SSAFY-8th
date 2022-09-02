package basic;

public class Basic_Array_ZigZag {

	public static void main(String[] args) {
	    
	    // 1. 대각선 지그재그
	    {
		    int [][] intArray = 
		        { { 1, 2, 3, 4, 5 },
		          { 6, 7, 8, 9,10 },
		          {11,12,13,14,15 },
		          {16,17,18,19,20 },
		          } ;
	
		    // 대각선 : 왼쪽 아래에서 오른쪽 위로
		    int col = intArray[0].length;
		    int row = intArray.length;
		    int line = col + row - 1; // 총 대각선 수
		    
		    // 대각선 수 만큼 반복
		    int r = 0;
		    int c = 0;
		    for(int i=0; i<line; i++) {
		    	// default 값
		    	r = i; // i 증가 처럼 처음에는 같이 증가한다 -> 고정으로 변화
		    	c = 0; // 처음에는 0 고정 -> 증가하는 형태로 변화
		    	
		    	if(i >= row) { // 변화 시점
		    		r = row - 1; // r의 고정
		    		c = i - row + 1; // 점점 증가
		    	}
		    	
		    	while(true) {
		    		if(r<0 || c > col-1) {
		    			System.out.println(); // 단순 개행
		    			break;
		    		}
		    		System.out.printf("%3d", intArray[r][c]);
		    		r--;
		    		c++;
		    	}
		    }
	    }
	    
	    // 2. 대각선 지그재그 : 왼쪽 아래에서 오른쪽 위로 다시 오른쪽 위에서 왼쪽 아래로
	    {
		    int [][] intArray = 
		        { { 1, 2, 3, 4, 5 },
		          { 6, 7, 8, 9,10 },
		          {11,12,13,14,15 },
		          {16,17,18,19,20 },
		          } ;
		    
		    // 대각선 : 왼쪽 아래에서 오른쪽 위로
		    int col = intArray[0].length;
		    int row = intArray.length;
		    int line = col + row - 1; // 총 대각선 수
		    
		    // 대각선 수 만큼 반복
		    int r = 0;
		    int c = 0;
		    for(int i=0; i<line; i++) {
		    	
		    	if( i % 2 == 0) {
			    	// default 값
			    	r = i; // i 증가 처럼 처음에는 같이 증가한다 -> 고정으로 변화
			    	c = 0; // 처음에는 0 고정 -> 증가하는 형태로 변화
			    	
			    	if(i >= row) { // 변화 시점
			    		r = row - 1; // r의 고정
			    		c = i - row + 1; // 점점 증가
			    	}
			    	
			    	while(true) {
			    		if(r<0 || c > col-1) {
			    			System.out.println(); // 단순 개행
			    			break;
			    		}
			    		System.out.printf("%3d", intArray[r--][c++]);
			    	}		    		
		    	}else {
			    	r = 0; 
			    	c = i; 
			    	
			    	if(i >= col) { // 변화 시점
			    		r = i - col + 1;
			    		c = col - 1;
			    	}
			    	
			    	while(true) {
			    		if(c<0 || r > row-1) {
			    			System.out.println(); // 단순 개행
			    			break;
			    		}
			    		System.out.printf("%3d", intArray[r++][c--]);
			    	}		    		
		    	}
		    }	    	
	    }
	}
}
