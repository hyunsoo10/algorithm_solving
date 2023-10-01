package BOJ_4811_알약;

import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			//약의 개수
			N = sc.nextInt();
			if(N==0) break;
			
			long[] dp = new long[N+1];
			//0,1,2 의 경우 초기화
			dp[0] = 1;
			dp[1] = 1;
			if(N>=2) dp[2] = 2;
			
			for(int i=3; i<=N; i++) {
				for(int j=0; j<i; j++) {
					dp[i] += dp[j] * dp[i-j-1];
				}
			}
			
			System.out.println(dp[N]);
		}
			
		
	}
}
