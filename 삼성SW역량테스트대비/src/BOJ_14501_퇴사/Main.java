package BOJ_14501_퇴사;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N : 퇴사 전까지 남은 일수
		int N = sc.nextInt();
		
		//T : 상담 완료 하는데 걸리는 시간
		//P : 상담 했을 때 받을 수 있는 금액
		int[]T = new int[N+1];
		int[]P = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		int[] dp = new int[N+2];
		
		//N번째 날 부터 1번째 날로 역순으로 쳌
		for(int i=N; i>0; i--) {
			//해당 날짜에서 상담이 걸리는 날짜
			int next = i + T[i];
			//만약 퇴사 날을 넘어간다면
			if(next > N+1) {
				//일을 하지 못하므로, 해당 날보다 앞쪽의 날짜의 값을 가져와야 함
				dp[i] = dp[i+1];
			}else {
				//일을 할 수 있는 경우면
				//해당 날에 일을 했을 때와 하지 않았을 때의 값중 큰 값을 대입
				dp[i] = Math.max(dp[i+1], P[i] + dp[next]);
			}
		}
		System.out.println(dp[1]);
	}
}
