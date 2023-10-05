package BOJ_22115_창영이와커피;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N개의 커피로 K만큼 카페인 섭취
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coffee = new int[N+1];
		for(int i=0; i<N; i++) coffee[i] = sc.nextInt();
		
		//dp 배열
		int[] dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		//0으로 초기화
		dp[0] = 0;
		
		//
		for(int i=0; i<N+1; i++) {
			for(int j=coffee[i]; j<K+1; j++) {
				dp[j] = Math.min(dp[j], dp[j-coffee[i]]+1);
			}
		}//end for

		System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);
		
	}
}
