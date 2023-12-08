package SWEA_9843_촛불이벤트;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			//양초의 개수
			long N = sc.nextLong();
			
			//왼쪽끝과 오른쪽 끝 변수
			long left = 1;
			long right = 2000000000L;
			//내가 찾은 최고의 정답
			long ans = 0;
			
			while(left <= right) {
				long mid = (left+right)/2;
				long totalCandle = mid * (mid+1)/2;
				
				if( N >= totalCandle) {
					ans = mid; // ans에 mid값 저장
					left = mid+1;
				}
				else {
					right = mid-1;
				}
			}//end while
			
			if(ans * (ans+1)/2 != N) ans = -1;
			
			System.out.printf("#%d %d\n", tc, ans);
			
			
			
		}//end testCase
	}// end main
}
