package BOJ_22115_창영이와커피;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N개의 커피로 K만큼 카페인 섭취
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coffee = new int[N+1];
		for(int i=1; i<N+1; i++) coffee[i] = sc.nextInt();
		
		//dp 배열
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<K+1; j++) {
				//i커피 보다 적은 양의 카페인 j는 dp[i-1][j]의 값을 그대로 가져오면된다.
				if(j < coffee[i]) dp[i][j] = dp[i-1][j];
				//i의 커피로 j를 채울 수 있으면 dp[i][j] = 1이다.
				else if(j == coffee[i]) dp[i][j] = 1;
				else {
					int tmp1 = dp[i-1][j];
					int tmp2 = dp[i-1][j-coffee[i]];
					
					if(tmp1 == 0 && tmp2 ==0) {
						dp[i][j] = 0;
					}else if (tmp1 == 0 && tmp2 != 0) {
						dp[i][j] = tmp2+1;
					}else if(tmp1 !=0 && tmp2 == 0) {
						dp[i][j] = tmp1;
					}else {
						dp[i][j] = Math.min(tmp1, tmp2+1);
					}
				}	
			}
		}//end for
		
		int ans = dp[N][K];
		//마실 수 없는 경우라면 정답에 -1
		if(ans == 0) ans = -1;
		//그런데 K가 0이라면 마시지 않아도 조건 만족이므로 ans = 0
		if(K==0) ans = 0;
		System.out.println(ans);
		
	}
}
