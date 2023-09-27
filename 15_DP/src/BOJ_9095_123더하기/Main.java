package BOJ_9095_123더하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[] dp = new int [n+1];
			
			//1을 만들수 있는 총 방법은 1이므로 1로 초기화
			//2을 만들 수 있는 방법은 2가지이므로 2로 초기화 하고 시작
			//3을 만들 수 있는 방법은 4가지이므로 4로 초기화 하고 시작
			dp[1] = 1;
			if(n>=2)dp[2] = 2;
			if(n>=3)dp[3] = 4;
			//4부터 dp 배열에 담기
			for(int i=4; i<n+1; i++) {
				//i숫자를 만들기 위해서
				//1. i-1까지 만든 방법에서 +1을 해주는 방법 : dp[i-1]
				//2. i-2까지 만든 방법에서 +2를 해주는 방법 : dp[i-2] + 1;
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n]);
		}
	}
}
