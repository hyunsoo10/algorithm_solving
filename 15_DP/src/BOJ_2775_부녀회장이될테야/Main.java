package BOJ_2775_부녀회장이될테야;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		/**
		 * a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 
		 * 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
		 * */

		//테스트 케이스
		int TC = sc.nextInt();
		
		//백준  : 동전 거스름돈, 2839(설탕배달)
		
		for(int i=0; i<TC; i++) {
			//k층의 n호
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] dp = new int[k+1][n+1];
			
			//0층 사람들 채우기
			for(int j=1; j<n+1; j++) dp[0][j] = j;
			for(int a=1; a<k+1; a++) {	
				for(int b=1; b<n+1; b++) {
					//a층의 n호에는 a-1층의 n호의 사람과 a층의 n-1호 사람이 산다
					dp[a][b] = dp[a-1][b] + dp[a][b-1];
				}
			}//0층~k층까지 탐색
			
			System.out.println(dp[k][n]);
			
		}
		
	}
}
