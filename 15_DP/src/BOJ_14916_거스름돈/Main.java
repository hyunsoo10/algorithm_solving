package BOJ_14916_거스름돈;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		//초기값 세팅
		if(N>=2) dp[2] = 1;
		if(N>=4) dp[4] = 2;
		if(N>=5) dp[5] = 1;
		
		for(int i=6; i<N+1; i++) {
			if(dp[i-5] > 0) {
				dp[i] = dp[i-5] + 1;
			}
			else if(dp[i-2] > 0) {
				dp[i] = dp[i-2] + 1;
			}
		}
		
		if(dp[N] == 0) System.out.println(-1);
		else System.out.println(dp[N]);
	}
}
