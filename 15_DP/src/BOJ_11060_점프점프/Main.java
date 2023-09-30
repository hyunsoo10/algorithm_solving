package BOJ_11060_점프점프;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력 정보 받기
		int N = sc.nextInt();
		int[] maze = new int[N+1];
		for(int i=1; i<=N; i++) maze[i] = sc.nextInt();
		
		//최소 점프 누적시켜 나갈 dp 배열
		int[] dp = new int[N+1];

		//1번 위치에서 jump가능한 범위로 일단 dp 업데이트
		int tmp = maze[1];
		for(int i=1; i<=tmp; i++) dp[1+i] = 1;
		
		//2번 위치 부터 시작
		for(int i=2; i<=N; i++) {
			//해당 미로의 jump 가능 범위
			int range = maze[i];
			
			if(dp[i] == 0) break;
			//0일 경우엔 점프가 불가능 하므로 1부터 반복문을 돌린다.
			for(int j=1; j<=range; j++) {
				
				//범위 내에 있을 때만
				if(i+j<N+1) {
					//해당 jump로 갈 수 있는 위치가 0이면 그전 위치 + 1
					if (dp[i+j] == 0) dp[i+j] = dp[i]+1;
					//0이 아니면 이미 다른 방법으로 온 것이므로 최소값 업데이트
					else {
						dp[i+j] = Math.min(dp[i+j], dp[i]+1);
					}					
				}
			}
		}// end for

		if(N==1) System.out.println(0);
		else if(dp[N]==0) System.out.println(-1);
		else System.out.println(dp[N]);
		
		
	}
}
