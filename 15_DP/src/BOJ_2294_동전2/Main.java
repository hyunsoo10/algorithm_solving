package BOJ_2294_동전2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n개의 동전을 이용해서 k원을 만든다.
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coins = new int[n+1];
		for(int i=1; i<n+1; i++) coins[i] = sc.nextInt();
		
		int[][] dp = new int[n+1][k+1];
		
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<k+1; j++) {
				
				//tmp1: 해당 코인을 사용하지 않았을 때의 동전 개수
				int tmp1 = dp[i-1][j];
				//tmp2: 해당 코인을 사용해서 만들었을 때의 동전 개수
				int tmp2 = 0;
				//j가 coins의 단위보다 작으면 해당 코인은 어차피 사용 못함
				if(j < coins[i]) {
					dp[i][j] = tmp1;
				}
	
				else {
					//해당 코인을 사용 할 수 있을 때는 두 경우를 비교해서 최소값을 넣어줘야 함
					//이전에도 만들 수 없었으면 지금도 못만드므로 tmp2 = 0
					if(dp[i][j - coins[i]] == 0) tmp2 = 0;
					else
						tmp2 = dp[i][j - coins[i]]+1;
					//해당 코인 1개로만 만들 수 있는 경우 고려
					if(j == coins[i]) {
						tmp2 = 1;
					}
				}
				
				//tmp1과 tmp2가 모두 0이면 그 값은 만들 수 없는 값임
				if(tmp1==0 && tmp2==0) dp[i][j] = 0;
				//둘 중에 하나가 0이면 0이 아닌 값을 대입
				else if(tmp1==0 || tmp2==0) dp[i][j] = Math.max(tmp1, tmp2);
				//둘다 값이 있다면 최소값 대입
				else {
					dp[i][j] = Math.min(tmp1, tmp2);
				}
			}
		}

		int ans = dp[n][k];
		//만들 수 없는 경우에는 -1 출력
		if(ans == 0) ans = -1;
		System.out.println(ans);
		
		
		
		
	}
}
