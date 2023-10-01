package BOJ_17070_파이프옮기기1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] map = new int[N+2][N+2];
		//파이프의 끝이 가로 방향인지, 대각선 방향인지, 세로 방향인지에 대한 정보를 저장하기 위한 3차원 배열
		int[][][] dp = new int[N+2][N+2][3];
		
		//인덱스를 범위를 벗어나는 부분을 그냥 벽으로 생각하기 위해 N+2크기로 맵 생성
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) map[i][j] = sc.nextInt();
		}//입력 끝

		//맵을 둘러싼 벽 모두 1로 채워서 벽처럼 표시
		for(int i = 0; i < N+2;  i++) {
			map[i][0] = 1;
			map[i][N+1] = 1;
		}
		for(int j = 0; j < N+2;  j++) {
			map[0][j] = 1;
			map[N+1][j] = 1;
		}
		
		//첫 파이프 위치 dp에 추가
		//(1,2)의 위치에 가로 파이프의 끝이 있다는 것을 의미
		dp[1][2][0] = 1;
		
		for(int i=1; i<N+1; i++) {
			for(int j=2; j<N+1; j++) {
				//가로 방향
				if(map[i][j+1] == 0) {
					//가로 방향의 파이프 끝 정보 업데이트
					//가로, 대각선 방향의 파이프에서 이동가능
					dp[i][j+1][0] += dp[i][j][0] + dp[i][j][1];
					//대각선으로도 갈수 있으면 대각선으로도 이동
					//가로, 대각선, 세로 모든 방향의 파이프에서 이동 가능
					if(map[i+1][j]==0 && map[i+1][j+1]==0) {
						dp[i+1][j+1][1] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
					}
				}
				//세로 방향
				if(map[i+1][j] == 0) {
					//대각선과 세로 방향의 파이프 끝에서만 이동 가능
					dp[i+1][j][2] += dp[i][j][1] + dp[i][j][2];
				}
			}
		}
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
			
	}
}
