package basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicArray {

	public static void main(String[] args) {
		// 빈도수 출력
		{
			int[] alphaCnt = new int[26]; // index 0 : a의 빈도수
			
			String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
			
			int strLength = str.length();
			for(int i=0; i<strLength; i++) {
				alphaCnt[str.charAt(i) - 'a']++;
			}
			
			System.out.println(Arrays.toString(alphaCnt));
			for(int i=0; i<26; i++) {
				System.out.println( (char)(i+'a') + " : " + alphaCnt[i]);
			}
		}
		
		{
			// 규칙이 다른 경우 확인
			// 세자리 수가 각각 곱셈을 표현 236 (2*3=6) -> O / 333 (3*3 != 9) -> X
			int [] arr = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
			
			int cnt = 0;
			for(int i=0; i<arr.length-2; i+=3) {
				if(arr[i] * arr[i+1] == arr[i+2]) cnt++;
			}
			
			System.out.println("Success : " + cnt + ", Fail : " + (arr.length / 3 - cnt));
		}
		
		{
			// 배열 reverse
			String [] str_arr = {"111", "222", "333", "444", "555", "666", "777", "888"};
			int str_arr_length = str_arr.length;
			for(int i=0; i<(str_arr_length/2); i++) {
				String tmp = str_arr[i];
				str_arr[i] = str_arr[str_arr_length - i -1];
				str_arr[str_arr_length - i-1] = tmp;
			}
			
			// 교수님 풀이
//			int center = str_arr.length / 2;
//			for(int l=0, r=str_arr.length -1; l<center;l++, r--) {
//				String tmp = str_arr[l];
//				str_arr[l] = str_arr[r];
//				str_arr[r] = tmp;
//			}
			
			// 교수님 풀이 2, API 이용
			// java.util의 Collections에서 reverse를 사용
			List<String> strList = Arrays.asList(str_arr); // 중요, Arrays.asList로 가져간 내역들은 복사가 아님. 즉 reverse하면 원본이 변경
			Collections.reverse(strList);
			
			System.out.println(Arrays.toString(str_arr));
			System.out.println();
		}
	}

}
