package BOJ_2631_줄세우기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] kids = new int[N];
		
		for(int i=0; i<N; i++) kids[i] = sc.nextInt();
		
		//오름 차순 길이 저장할 dp 배열
		int[] dp = new int[N];
		dp[0] = 1;
		
		int max = 0;
		for(int i=1; i<N; i++) {
			//최소 길이1
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				//i까지의 오름차순 길이 dp에 업데이트
				if(kids[i] > kids[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N - max);
	}// end main
}
