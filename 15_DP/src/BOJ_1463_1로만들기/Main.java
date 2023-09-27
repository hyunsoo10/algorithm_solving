package BOJ_1463_1로만들기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		//상향식 DP로 구하기
		//1에서 N을 만드는 방법의 최솟값과 동일함
		//1에서 1을 만드는 최솟값은 0
		dp[1] = 0;
		
		for(int i=2; i<N+1; i++) {
			//1을 더해서 만드는 경우로 최소값 초기화
			int min = dp[i-1]+1;
			//2로 나눠지는 경우
			if(i%2 == 0) {
				//2를 곱해서 만드는 경우와 비교해서 최소값 구하기
				min = Math.min(min, dp[i/2]+1);
			}
			//3으로 나눠지는 경우
			if(i%3==0) {
				//3을 곱해서 만드는 경우와 비교해서 최소 값 구하기
				min = Math.min(min, dp[i/3]+1);
			}
			dp[i] = min;
		}
		System.out.println(dp[N]);
		
	}
}
