package BOJ_1562_계단수;

import java.util.Scanner;

public class Main {
	static final int mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[][][] dp = new long[N+1][10][1<<10];
		
		//1번째 자리에서 i라는 숫자가 오는 경우를 dp배열에 담는다.
		for(int i=1; i<10; i++) {
			dp[1][i][1<<i] = 1;
		}
		
		//2번째 자리부터는 0 가넝이다
		for(int n=2; n<=N; n++) {
			for(int i=0; i<10; i++) {
				//j는 비트 체크
				for(int j = 0; j < (1<<10); j++) {
					int nextj = j|(1<<i);
					//i==0이면 인접한 수가 1인 경우만 더해준다
					if(i==0) dp[n][i][nextj] += dp[n-1][i+1][j]%mod;
					else if(i==9) dp[n][i][nextj] += dp[n-1][i-1][j]%mod;
					else dp[n][i][nextj] += dp[n-1][i+1][j]%mod + dp[n-1][i-1][j]%mod;
					
					dp[n][i][nextj] %= mod;
							
				}
			}
		}
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum += dp[N][i][(1<<10)-1]%mod;
			sum%=mod;
		}
		System.out.println(sum);
	}
}
