package basic;

public class Basic_MinMaxTest {

	public static void main(String[] args) {
		{
			int a = 3, b= 5;
			int max = 0;
			if(a>b) max = a;
			else max = b;
		}
		
		{
			int a=3, b=5;
			int max = 0;
			max = a > b ? a : b;
		}
		
		{
			int a = 3, b = 5;
			int max = Math.max(a, b);
		}
		
		{
			int[] intArray = {1, 3, 5, 7};
			int min = Integer.MAX_VALUE; // Long도 Max, Min Value 다 제공한다
			int max = Integer.MIN_VALUE;
			for(int i=0; i<intArray.length; i++) {
				min = Math.min(min,  intArray[i]);
				max = Math.max(max, intArray[i]);
			}
		}

	}

}
