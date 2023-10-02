package BOJ_2839_설탕배달;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp =new int[N+1];
		
		//3킬로 그램을 배달 할때는 최소 1개 필요
		dp[3] = 1;
		if(N>=5) dp[5] = 1;
		
		for(int i=5; i<N+1; i++) {
			//5킬로 그램 설탕을 배달 할 수 있는 경우
			if(dp[i-5] > 0) {
				dp[i] = dp[i-5] + 1;
			}
			//3킬로 그램 설탕을 배달 할 수 있는 경우
			else if(dp[i-3] > 0) {
				dp[i] = dp[i-3] + 1;
			}
		}
		System.out.println(Arrays.toString(dp));
		if(dp[N]==0) System.out.println(-1);
		else System.out.println(dp[N]);
	}
}
