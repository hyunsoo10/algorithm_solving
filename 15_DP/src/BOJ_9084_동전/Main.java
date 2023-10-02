package BOJ_9084_동전;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			//동전의 가짓 수
			int N = sc.nextInt();
			
			//동전의 금액 입력
			int[] coins = new int[N+1];
			for(int i=1; i<N+1; i++) coins[i] = sc.nextInt();
			
			//주어진 N가지 동전으로 만들어야 할 금액
			int M = sc.nextInt();
			
			int[][] dp = new int[N+1][M+1];
			
			//첫번째 동전으로 만들 수 있는 방법 1로 초기화
			for(int j=1; j<=M; j++) 
				if(j%coins[1] == 0) dp[1][j] = 1;
	
			
			for(int i=2; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					//1. 해당 동전 없이 만들 수 있었던 개수
					dp[i][j] = dp[i-1][j];
					//해당 동전만 사용해서 만들 수 있는 최초의 경우에 가짓수를 +1 해준다.
					if(j == coins[i]) dp[i][j] ++;
					//2. 해당 동전을 사용할 수 있는 경우에 추가 계산 필요
					if(j >= coins[i]) {
						//2. 해당 동전의 가치를  더해서 만들 수 있는 개수
						dp[i][j] += dp[i][j-coins[i]];
					}
				}
			}
			System.out.println(dp[N][M]);
		}// end testCase
	}
}
