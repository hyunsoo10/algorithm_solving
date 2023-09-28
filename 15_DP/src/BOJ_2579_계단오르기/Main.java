package BOJ_2579_계단오르기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//계단은 한번에 한 계단 or 두 계단
		//연속된 세 계단 모두 밟기 불가능
		//마지막 도착  계단은 반드시 밟는다
		
		//계단의 개수
		int N = sc.nextInt();
		
		int[] stairs = new int[N+1];
		//계단의 점수
		for(int i=1; i<N+1; i++) stairs[i] = sc.nextInt();

		//dp 배열
		int[] dp = new int[N+1];
		//1번 2번 dp값은 고정이므로 초기화
		dp[1] = stairs[1];
		//계단의 크기가 2이상일때만 2번 dp값도 미리 초기화
		if(N>=2) dp[2] = stairs[1]+stairs[2];
		
		//3번 값 부터 점화식 활용해서 dp 배열 채우기
		for(int i=3; i<N+1; i++) {
			dp[i] = Math.max(dp[i-3] + stairs[i-1]+stairs[i],dp[i-2] + stairs[i]);
		}
		System.out.println(dp[N]);
	}
}
