package BOJ_12865_평범한배낭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//물품의수  N(1 ≤ N ≤ 100)
		int N = sc.nextInt();
		//버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)
		int K = sc.nextInt();
		
		int[][] items = new int[N+1][2];
		
		//i번째 물건의 0번인덱스에 해당 물건의 무게, 1번 인덱스에 해당 물건의 가치가 각각 담긴다.
		for(int i=1; i<=N; i++) {
			for(int j=0; j<2; j++) items[i][j] = sc.nextInt();
		}//물건 정보 입력 끝
		
		//0-1 knapsack
		int dp[][] = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			for(int w=1; w<=K; w++) {
				//i번 아이템의 무게가  w 이하일 경우
				if(items[i][0] <= w) {
					//해당 아이템을 넣었을 때와, 넣지 않았을 때의 값을 비교해야함
					//1. 해당 아이템을 넣었 을 때 : 해당 아이템의 무게를 뺐을 때의 배낭에 채울 수 있는 최대 가치 + 해당 아이템의 가치
					//2. 해당 아이템을 넣지 않았을 떄 : 그냥 그 아이템을 넣지 않았을 때의 최대 가치
					dp[i][w] = Math.max(dp[i-1][w-items[i][0]] + items[i][1], dp[i-1][w]);
				}else {
					//현재 무게를 배낭에 넣을 수 없을 때는 그냥 그 아이템을 넣지 않았을 때의 최대 가치가 최대값이다
					dp[i][w] = dp[i-1][w];
				}
			}
		}// end for

		System.out.println(dp[N][K]);
		
		
	}
}
